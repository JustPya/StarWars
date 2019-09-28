package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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


    static ArrayList<Planets> pl;


    static int actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        pl = new ArrayList<Planets>();

        Intent intent = getIntent();
        pl.addAll((ArrayList<Planets>) intent.getSerializableExtra("planets"));
        System.out.println(pl.toString());

        name=findViewById(R.id.text_name_planet);
        rotation_period=findViewById(R.id.text_rotation_period);
        orbital_period=findViewById(R.id.text_orbital_period);
        diameter=findViewById(R.id.text_diameter);
        climate=findViewById(R.id.text_climate);
        gravity=findViewById(R.id.text_gravity);
        terrain=findViewById(R.id.text_terrain);
        surface_water=findViewById(R.id.text_surface_water);
        population=findViewById(R.id.text_population);
        actual = 0;
        updateInfo();


    }

    public static void updateInfo(){
        name.setText("Nombre: " + pl.get(actual).getName());
        rotation_period.setText("Rotación: " + pl.get(actual).getRotation_period());
        orbital_period.setText("Periodo orbital: " + pl.get(actual).getOrbital_period());
        diameter.setText("Diámetro: " + pl.get(actual).getDiameter());
        climate.setText("Clima: " + pl.get(actual).getClimate());
        gravity.setText("Gravedad: " + pl.get(actual).getGravity());
        terrain.setText("Terreno: " + pl.get(actual).getTerrain());
        surface_water.setText("Superficie Acuática: " + pl.get(actual).getSurface_water());
        population.setText("Población: " + pl.get(actual).getPopulation());
    }


    public  void nextPlanet(View view){
        actual = (actual+1)%pl.size();
        updateInfo();
    }

    public  void prevPlanet(View view){
        actual = (actual+pl.size()-1)%pl.size();
        updateInfo();
    }

    public void terminate(View view){
        finish();
    }

}
