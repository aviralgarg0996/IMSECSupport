package com.example.aviralgarg0996.imsecsupport;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AssignWork extends ListActivity {
    Variables v=new Variables();
   private String[] Department = v.users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_work);

        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, Department));

    }
       @Override
        protected void onListItemClick(ListView list, View v, int position, long id) {
            // TODO Auto-generated method stub
            super.onListItemClick(list, v, position, id);

                try {
                    Intent intent=new Intent(this, Director.class);
                    intent.putExtra("String_I_Need",Department[position]);
                    startActivity(intent);


                } catch (Exception e) {
                    // TODO: handle exception
                }}


}
