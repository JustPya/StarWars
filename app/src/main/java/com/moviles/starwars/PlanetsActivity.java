package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlanetsActivity extends AppCompatActivity {


    static TextView name;
    static TextView rotation_period;
    static TextView orbital_period;
    static TextView diameter;
    static TextView climate;
    static TextView gravity;
    static TextView terrain;
    static TextView surface_water;
    static TextView population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
        name.findViewById(R.id.text_name_planet);
        rotation_period.findViewById(R.id.text_rotation_period);
        orbital_period.findViewById(R.id.text_orbital_period);
        diameter.findViewById(R.id.text_diameter);
        climate.findViewById(R.id.text_climate);
        gravity.findViewById(R.id.text_gravity);
        terrain.findViewById(R.id.text_terrain);
        surface_water.findViewById(R.id.text_surface_water);
        population.findViewById(R.id.text_population);

    }
}
