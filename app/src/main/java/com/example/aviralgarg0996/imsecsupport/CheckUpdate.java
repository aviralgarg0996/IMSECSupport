package com.example.aviralgarg0996.imsecsupport;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CheckUpdate extends ListActivity {
    Variables v=new Variables();
   private String[] Department = v.users;
           //new String[] {
           // "Director", "SportsOfficer", "AccountsOffice","Hostel Warden","Registrar Office","Chief Proctor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_update);
        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,Department));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
            Intent intent=new Intent(this, CheckForWork.class);
            intent.putExtra("String_I_Required",Department[position]);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
