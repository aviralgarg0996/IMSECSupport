package com.example.aviralgarg0996.imsecsupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LoggedIn extends AppCompatActivity {
    private Button SignOut;
    private Button CheckWork;
    private String User_Name;
    private FirebaseAuth mauth;
FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        SignOut=(Button)findViewById(R.id.btn_signout);
        CheckWork=(Button)findViewById(R.id.buttoneCheck);
        mauth=FirebaseAuth.getInstance();
        //final String User_Name=mauth.getCurrentUser().getDisplayName().toString().trim();
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(LoggedIn.this,LoginPage.class));

            }
        });
       // CheckWork.setText(User_Name);
     /*  CheckWork.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(LoggedIn.this,CheckForWork.class);
               intent.putExtra("User_String",User_Name);
               startActivity(intent);
           }
       });*/
    }
}
