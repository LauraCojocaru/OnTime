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

import java.util.Calendar;

/**
 * Created by Laura on 8/14/2015.
 */
public class Date extends Activity {

    DatePicker datePicker;
    Button save;
    String dataN;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);
        datePicker = (DatePicker)findViewById(R.id.datepicker);
        save = (Button)findViewById(R.id.save2);
        Calendar c = Calendar.getInstance();
        dataN = "Date: "+c.get(Calendar.YEAR)+" "+c.get(Calendar.MONTH);



        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
                //System.out.println("obnDateChanged");
                dataN = "Date: " + arg1 + "." + arg2 + "." + arg3;
                //intentN.putExtra("date",dataN);
            }
        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent salveaza = new Intent();
                salveaza.putExtra("date",dataN);
                //Log.d("LOGCAT", dataN);
                setResult(1, salveaza);
                finish();
            }
        });

    }

    @Override
    public String toString(){
        return dataN;
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
