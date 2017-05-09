package com.example.aviralgarg0996.imsecsupport;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoggedIn extends AppCompatActivity {
    private Button SignOut;

    private RecyclerView WorkList;
    private String User_Name;
    private DatabaseReference mdatabase;
    private FirebaseAuth mauth;

FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
       Bundle users= getIntent().getExtras();
        User_Name=users.getString("hello_user");
        Toast.makeText(LoggedIn.this,User_Name,Toast.LENGTH_LONG).show();
        mdatabase= FirebaseDatabase.getInstance().getReference().child(User_Name);
        WorkList=(RecyclerView)findViewById(R.id.work_list1);
        WorkList.setHasFixedSize(true);
        WorkList.setLayoutManager(new LinearLayoutManager(this));

        SignOut=(Button)findViewById(R.id.btn_signout);

        mauth=FirebaseAuth.getInstance();
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(LoggedIn.this,LoginPage.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Work,LoggedIn.WorkViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Work, LoggedIn.WorkViewHolder>(
                Work.class,R.layout.workview,
                LoggedIn.WorkViewHolder.class,
                mdatabase

        ) {
            @Override
            protected void populateViewHolder(LoggedIn.WorkViewHolder viewHolder, Work model, final int position) {

                viewHolder.setWorkTit(model.getWorkTit());
                viewHolder.setWorkDesc(model.getWorkDesc());
                viewHolder.setCurdate(model.getDate());
                //subButton=(Button)viewHolder.mView.findViewById(R.id.BtnSubmit1);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LoggedIn.this,"You clicked on card"+String.valueOf(position),Toast.LENGTH_LONG).show();

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(LoggedIn.this);
                        builder1.setMessage("You want to Submit your Work");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Toast.makeText(LoggedIn.this,"Work is Submitted",Toast.LENGTH_LONG).show();
                                    }
                                });

                        builder1.setNegativeButton(
                                "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                });
            }
        };
        WorkList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class WorkViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public WorkViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setWorkTit(String title){
            TextView postTitle=(TextView)mView.findViewById(R.id.WorkFetch1);
            postTitle.setText(title);
        }

        public void setWorkDesc(String description){
            TextView postDescription=(TextView)mView.findViewById(R.id.WorkFetch2);
            postDescription.setText(description);
        }
        public void setCurdate(String AssignDate){
            TextView assignDate=(TextView)mView.findViewById(R.id.CurDate);
            assignDate.setText(AssignDate);
        }
        public void setSubdate(String SubmitDate){
            TextView submitDate=(TextView)mView.findViewById(R.id.SubDate);
            submitDate.setText(SubmitDate);
        }
    }
}
