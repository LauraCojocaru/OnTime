package com.example.laura.reminder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Laura on 8/13/2015.
 */
public class MainPage extends ListActivity {

    ElementAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.main_page);
        adapter = new ElementAdapter(this);
        setListAdapter(adapter);


        adapter.adauga("To Do List", R.drawable.buton1);
        adapter.adauga("Birthdays", R.drawable.buton2);
        adapter.adauga("Exit", R.drawable.buton3);




    }

    @Override
    public void onListItemClick (ListView list, View v, int position, long id)
    {
        if(position == 0)
        {
            Intent todolist = new Intent(MainPage.this,NewList.class);
            startActivity(todolist);
        }
        else
        if(position == 1) {
            Intent birthday = new Intent(MainPage.this,Birthday.class);
            startActivity(birthday);
        }
        else
            {
                finish();
            }
    }
}



