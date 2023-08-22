package com.example.planetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planets> planets;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1- AdapterView: a ListView

        listView = findViewById(R.id.list_item);

        //2- Data source: ArrayList<Planets>
        planets = new ArrayList<>();

        Planets planet1 = new Planets("Earth","1 Moon",R.drawable.earth);
        Planets planet2 = new Planets("Mercury","0 Moon",R.drawable.mercury);
        Planets planet3 = new Planets("Venus","0 Moon",R.drawable.venus);
        Planets planet4 = new Planets("Mars","2 Moon",R.drawable.mars);
        Planets planet5 = new Planets("Jupiter","79 Moon",R.drawable.jupiter);
        Planets planet6 = new Planets("Saturn","1 Moon",R.drawable.saturn);
        Planets planet7 = new Planets("Uranus","1 Moon",R.drawable.uranus);
        Planets planet8 = new Planets("Neptune","1 Moon",R.drawable.neptune);
        Planets planet9 = new Planets("Pluto","1 Moon",R.drawable.pluto);

        planets.add(planet1);
        planets.add(planet2);
        planets.add(planet3);
        planets.add(planet4);
        planets.add(planet5);
        planets.add(planet6);
        planets.add(planet7);
        planets.add(planet8);
        planets.add(planet9);

        //3- Adapter

        adapter = new MyCustomAdapter(planets,getApplicationContext());
        listView.setAdapter(adapter);

        //Handling click events

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet name"+adapter.getItem(position).getPlanetName(),Toast.LENGTH_LONG ).show();
            }
        });
    }
}