package com.example.planetapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planets> {

    //using custom adapter --> MyCustomAdapter
    //using custom layout --> extends ArrayAdapter<Planets>

    private ArrayList<Planets> planets;
    Context context;

    public MyCustomAdapter(ArrayList<Planets> planets, Context context) {
        super(context, R.layout.my_list_item, planets);
        this.planets = planets;
        this.context = context;
    }

    //View Holder class: used to cached reference to the views within an item layout, so that they don't need to be repeatedly looked up during scrolling

    private static class MyViewHolder{
        TextView planetName;
        TextView totalMoons;
        ImageView planetImage;
    }

    //getView(): used to create and return a view for a specific item in the list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1- Get the planet object for the current position
        Planets planet = getItem(position);

        //2- Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            //convertView: is a recycled view that you can reuse to improve the performance of your list.

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.
                    inflate(R.layout.my_list_item,parent,false);


            //finding the views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.totalMoons = (TextView)convertView.findViewById(R.id.total_moons);
            myViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);

        }else{
            //reusing the view(that's recycled)
            myViewHolder = (MyViewHolder) convertView.getTag();

            result = convertView;
        }

        //set the data to the view
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.totalMoons.setText(planet.getMoonCount());
        myViewHolder.planetImage.setImageResource(planet.getPlanetImage());



        //binding data to view within the convertView

        return result;


    }
}
