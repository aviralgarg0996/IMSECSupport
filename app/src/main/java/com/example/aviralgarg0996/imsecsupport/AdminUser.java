package com.example.aviralgarg0996.imsecsupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AdminUser extends AppCompatActivity {
    private Button btn_Signout2,btn_assignData,btn_checkUpdates;
    FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
        btn_Signout2=(Button)findViewById(R.id.btn_signout2);
        btn_assignData=(Button)findViewById(R.id.btn_assignWork);
        btn_checkUpdates=(Button)findViewById(R.id.btn_chckUpdate);
        btn_assignData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminUser.this,AssignWork.class));
            }
        });
        btn_Signout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(AdminUser.this,LoginPage.class));
            }
        });
        btn_checkUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminUser.this,CheckUpdate.class));
            }
        });



    }
}
