package com.example.aviralgarg0996.imsecsupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AssignWork extends AppCompatActivity {
private ListView UserList;
   private String[] Department = new String[] {
            "Director", "Sports Officer", "Accounts Office","Hostel Warden","Registrar Office","Chief Proctor"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_work);
        UserList = (ListView) findViewById(R.id.User_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                AssignWork.this,
                android.R.layout.simple_list_item_1,
                Department);
        UserList.setAdapter(arrayAdapter);
    }
}
