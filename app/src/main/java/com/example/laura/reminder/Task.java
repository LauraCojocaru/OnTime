package com.example.laura.reminder;

/**
 * Created by Laura on 8/14/2015.
 */
public class Task {
    public String title;
    public String date;
    public String time;
    @Override
    public String toString ()
    {
        // acesta functie este apelata de catre ArrayAdapter pentru a transforma obiectul intr-un String ce
        // sa fie afisat in lista
        return title + date + time;
    }
}
