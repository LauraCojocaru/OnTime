package com.example.laura.reminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by Laura on 8/14/2015.
 */
public class Time extends Activity {

    TimePicker timePicker;
    Button save;
    String timp;
    private int ora,minut;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker);
        timePicker = (TimePicker)findViewById(R.id.timepicker);
        save = (Button)findViewById(R.id.save3);
        timePicker.getCurrentHour();
        ora = timePicker.getCurrentHour();
        minut = timePicker.getCurrentMinute();


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
                ora = arg1;
                minut = arg2;
                timp = arg1 + ":" + arg2;
            }

        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent salveazaT = new Intent();
                salveazaT.putExtra("time",timp);
                setResult(1, salveazaT);
                finish();
            }
        });

    }

    @Override
    public String toString(){
        return timp ;
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
