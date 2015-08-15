package com.example.laura.reminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Laura on 8/14/2015.
 */
public class AddTask extends Activity {
    Button save,delete,addDate,addTime;
    EditText con;
    String date,timp,titlu;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        //final Intent intentN = new Intent();

        save = (Button)findViewById(R.id.save);
        delete = (Button)findViewById(R.id.delete);
        addDate = (Button)findViewById(R.id.adddate);
        addTime = (Button)findViewById(R.id.addtime);
        con = (EditText)findViewById(R.id.addtitle);
        titlu = "";

        /*day = data.getDayOfMonth();
        month = data.getMonth();
        year = data.getYear();

        hour = time.getCurrentHour();
        minute = time.getCurrentMinute();*/

        addDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent data = new Intent(AddTask.this,Date.class);
                startActivityForResult(data,1);
            }
        });
        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent time = new Intent(AddTask.this,Time.class);
                startActivityForResult(time, 2);
            }
        });


        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

              //Toast. makeText(getApplicationContext() , "Timp = " + timp  + " Date =" +date, Toast.LENGTH_SHORT ).show();

                Intent salveaza = new Intent();
                salveaza.putExtra("date",date);
                salveaza.putExtra("time",timp);
                titlu = con.getText().toString();
                System.out.println(titlu);
                salveaza.putExtra("title",titlu);

                setResult(1, salveaza);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                setResult(0);
                finish();
            }
        });

    }
    @Override
    public  void onActivityResult (int requestCode, int responseCode, Intent data) {
        System.out.println("onb result "+requestCode);
        if (requestCode == 1) {
            //System.out.println(data.getExtras());
            date = data.getStringExtra("date");
        System.out.println(date);
        }
            if (requestCode == 2)
            {
                timp = data.getStringExtra("time");
                //System.out.println(timp);
            }
    }



    @Override
    public void onStart ()
    {
        super.onStart();
    }

    @Override
    public void onRestart ()
    {
        super.onRestart();
    }

    @Override
    public void onResume ()
    {
        super.onResume();
    }

    @Override
    public void onPause ()
    {
        super.onPause();
    }

    @Override
    public void onStop ()
    {
        super.onStop();
    }

    @Override
    public void onDestroy ()
    {
        super.onDestroy();
    }

    // functii folosite pentru salvarea si restaurarea starii

    @Override
    public void onSaveInstanceState (Bundle outState)
    {
        // apelarea functiei din activitatea parinte este recomandata, dar nu obligatorie
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState (Bundle inState)
    {
        // apelarea functiei din activitatea parinte este recomandata, dar nu obligatorie
        super.onRestoreInstanceState(inState);
    }

}
