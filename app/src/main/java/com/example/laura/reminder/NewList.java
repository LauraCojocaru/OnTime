package com.example.laura.reminder;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Laura on 8/13/2015.
 */
public class NewList extends ListActivity {
    NewListAdapter adapter;
    ImageButton addbutton;
    TextView addtext;
    String date,time,title;


    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.new_list);
        adapter = new NewListAdapter(this);
        setListAdapter(adapter);
        //ArrayList<>

        addbutton = (ImageButton)findViewById(R.id.add);
        addtext = (TextView)findViewById(R.id.edit);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adaugaTask = new Intent(NewList.this,AddTask.class);
                startActivityForResult(adaugaTask,100);
            }
        });
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.tasks.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });



    }
    @Override
    public void onActivityResult (int requestCode, int responseCode, Intent data) {

        if (requestCode == 100) {

            date = data.getStringExtra("date");
            time = data.getStringExtra("time");
            title = data.getStringExtra("title");

            Toast.makeText(getApplicationContext(), "Time = " + time + " Date = " + date + " Title = " + title , Toast.LENGTH_SHORT).show();

            adapter.adauga(title,date,time);
            adapter.notifyDataSetChanged();

        }
    }
    /*private void saveTasks() {

        SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String json = gson.toJson(users);

        editor.putString("participants", json);
        editor.commit();
    }

    private void retrieveUsers() {

        SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("participants", null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        users = gson.fromJson(json, type);
    }*/
}
