package com.example.aviralgarg0996.imsecsupport;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.PrivateKey;

public class LoginPage extends AppCompatActivity {
    private Button btnLogin;
    private TextView ForgetText;
    private EditText userText,PassText;
    private String UserEmail,UserPassword;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    private ProgressBar progressBar;
    private Spinner dropdown;
    Variables v=new Variables();
    private String username,user="";
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        dropdown = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,v.ActivaeUsers);
        dropdown.setAdapter(adapter);
       dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               switch(position){
                   case 0:
                       username=v.HOD_CSEemail;
                       user="AccountsOffice";
                       break;
                   case 1:
                       username=v.Sports_Officer;
                       user="SportsOfficer";
                       break;
                   case 2:
                       username=v.Director;
                       user="Director";
                       break;
                   case 3:
                       username=v.admin;
                       break;
           }}

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }

       });

        auth=FirebaseAuth.getInstance();
        btnLogin=(Button)findViewById(R.id.btn_login);
        ForgetText=(TextView)findViewById(R.id.textView3);
        //userText=(EditText)findViewById(R.id.email2);
        PassText=(EditText)findViewById(R.id.password2);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });


        ForgetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this,ForgotPassword.class));
            }
        });
    }



    public void SignIn(){

//        UserEmail=userText.getText().toString().trim();
        UserPassword=PassText.getText().toString().trim();
/*if (UserEmail.isEmpty())
{
    Toast.makeText(LoginPage.this,"Please Enter the Email Id",Toast.LENGTH_LONG).show();
}
else*/ if (UserPassword.isEmpty())
{
    Toast.makeText(LoginPage.this,"Please enter Valid Password",Toast.LENGTH_LONG).show();
}
else {
    auth.signInWithEmailAndPassword(username, UserPassword)
            .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                        // there was an error

                        Toast.makeText(LoginPage.this,"Error in logging!!",Toast.LENGTH_LONG).show();
                    } else {
                        if(FirebaseAuth.getInstance().getCurrentUser().getEmail().equals(v.admin))
                            startActivity(new Intent(LoginPage.this,AdminUser.class));
                        else {
                            i = new Intent(LoginPage.this, LoggedIn.class);
                            i.putExtra("hello_user",user);
                            startActivity(i);
                        }

                        Toast.makeText(LoginPage.this, "Logged In", Toast.LENGTH_LONG).show();
                       }
                }
            });

}

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
