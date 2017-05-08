package com.example.aviralgarg0996.imsecsupport;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Director extends AppCompatActivity {
    private EditText Work_Title,Work_description;
    private FirebaseAuth auth;
    private Button adddb;
    private DatabaseReference databaseReference;
    private String UserForWork,WorkTitle,WorkDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);
        Work_Title=(EditText)findViewById(R.id.Work_Title);
        Work_description=(EditText)findViewById(R.id.Work_Description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth= FirebaseAuth.getInstance();


        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            UserForWork= null;
        } else {
            UserForWork= extras.getString("String_I_Need");
        }
        adddb = (Button) findViewById(R.id.btn_adddb);
        adddb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });
    }
    public void saveUserInfo(){
        WorkTitle=Work_Title.getText().toString().trim();
        WorkDescription=Work_description.getText().toString().trim();
        String user =UserForWork;
        Date d = new Date();
        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
        databaseReference = FirebaseDatabase.getInstance().getReference().child(user);
        DatabaseReference newPost=databaseReference.push();
        newPost.child("workTit").setValue(WorkTitle);
        newPost.child("workDesc").setValue(WorkDescription);
        newPost.child("date").setValue(s);
    }

}
