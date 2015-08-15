package com.example.laura.reminder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Laura on 8/13/2015.
 */
public class NewListAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<Task> tasks;

    public NewListAdapter (Activity _context)
    {
        this.context = _context;
        tasks = new ArrayList<Task>();
    }

    @Override
    public View getView (int position, View convertView, ViewGroup list)
    {
        // functia trebuie sa intoarca view-ul de pe pozitia position din lista
        // convertView este un element din lista ce nu mai este vizibil si poate fi convertit
        View task;
        if (convertView == null){

            LayoutInflater inflater = context.getLayoutInflater();
            task = inflater.inflate(R.layout.item_new_list, null);


            TagTask tag = new TagTask();
            tag.title = (TextView) task.findViewById(R.id.item2title);
            tag.date = (TextView) task.findViewById(R.id.date);
            tag.time = (TextView) task.findViewById(R.id.time);
            task.setTag(tag);
        }
        else task = convertView;


        TagTask tag = (TagTask)task.getTag();

        tag.title.setText("Title:" + tasks.get(position).title);
        tag.date.setText(tasks.get(position).date);
        tag.time.setText("Time:" + tasks.get(position).time);

        return task;
    }
    @Override
    public int getCount ()
    {
        // intoarce nr de elemente din lista
        return tasks.size ();
    }

    @Override
    public Object getItem(int position)
    {
        // intoarce elementul de pe pozitia position din model
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // fiecare element din lista poate avea un id, nu este insa obligatoriu
        return 0;
    }

    public void adauga (String title ,String date, String time)
    {
        Task t = new Task ();
        t.title = title;
        t.date = date;
        t.time = time;
        tasks.add(t);
        // acesta functie determina adaptorul sa ceara listei sa reafiseze continutul
        this.notifyDataSetChanged();
    }
}
