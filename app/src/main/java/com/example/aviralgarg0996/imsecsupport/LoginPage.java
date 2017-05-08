package com.example.aviralgarg0996.imsecsupport;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        auth=FirebaseAuth.getInstance();
        //mAuthlistener=new FirebaseAuth.AuthStateListener();
        //auth.addAuthStateListener(mAuthlistener);
        btnLogin=(Button)findViewById(R.id.btn_login);
        ForgetText=(TextView)findViewById(R.id.textView3);
        userText=(EditText)findViewById(R.id.email2);
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
        UserEmail=userText.getText().toString().trim();
        UserPassword=PassText.getText().toString().trim();
if (UserEmail.isEmpty())
{
    Toast.makeText(LoginPage.this,"Please Enter the Email Id",Toast.LENGTH_LONG).show();
}
else if (UserPassword.isEmpty())
{
    Toast.makeText(LoginPage.this,"Please enter Valid Password",Toast.LENGTH_LONG).show();
}
else {
    auth.signInWithEmailAndPassword(UserEmail, UserPassword)
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
                        if (UserEmail.equals("aviralgarg0996@gmail.com"))
                            startActivity(new Intent(LoginPage.this,AdminUser.class));
                        else
                        {
                        Intent intent = new Intent(LoginPage.this, LoggedIn.class);
                        startActivity(intent);
                        finish();
                    }}
                }
            });

}
    }
}
