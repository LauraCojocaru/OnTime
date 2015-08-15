package com.example.laura.reminder;

import android.app.Activity;
import android.net.Uri;
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
public class ElementAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Element> elemente;

    public ElementAdapter (Activity _context)
    {
        this.context = _context;
        elemente = new ArrayList<Element>();
    }

    @Override
    public View getView (int position, View convertView, ViewGroup list)
    {
        // functia trebuie sa intoarca view-ul de pe pozitia position din lista
        // convertView este un element din lista ce nu mai este vizibil si poate fi convertit
        View element;
        if (convertView == null){

            LayoutInflater inflater = context.getLayoutInflater();
            element = inflater.inflate(R.layout.element, null);


            TagElement tag = new TagElement();
            tag.text = (TextView) element.findViewById(R.id.textelem);
            tag.image = (ImageView) element.findViewById(R.id.imagine);
            element.setTag(tag);
        }
        else element = convertView;


        TagElement tag = (TagElement)element.getTag();

        tag.text.setText(elemente.get(position).text);
        tag.image.setImageResource(elemente.get(position).image);

        return element;
    }

    @Override
    public int getCount ()
    {
        // intoarce nr de elemente din lista
        return elemente.size ();
    }

    @Override
    public Object getItem(int position)
    {
        // intoarce elementul de pe pozitia position din model
        return elemente.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // fiecare element din lista poate avea un id, nu este insa obligatoriu
        return 0;
    }

    public void adauga (String text ,int image)
    {
        Element e = new Element ();
        e.text = text;
        e.image = image;
        elemente.add(e);
        // acesta functie determina adaptorul sa ceara listei sa reafiseze continutul
        this.notifyDataSetChanged();
    }
}
