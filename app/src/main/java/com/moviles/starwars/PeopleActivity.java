package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PeopleActivity extends AppCompatActivity {

    static TextView name;
    static TextView height;
    static TextView mass;
    static TextView hair_color;
    static TextView skin_color;
    static TextView eye_color;
    static TextView birth_year;
    static TextView gender;
    static ArrayList<People> pe;

    static int actual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        pe = new ArrayList<People>();


        Intent intent = getIntent();
        pe.addAll((ArrayList<People>) intent.getSerializableExtra("people"));
        System.out.println(pe.toString());



        name = findViewById(R.id.text_name);
        height= findViewById(R.id.text_height);
        mass= findViewById(R.id.text_mass);
        hair_color= findViewById(R.id.text_hair_color);
        skin_color= findViewById(R.id.text_skin_color);
        eye_color= findViewById(R.id.text_eye_color);
        birth_year = findViewById(R.id.text_birth_year);
        gender = findViewById(R.id.text_gender);
        actual = 0;
        updateInfo();
    }


    public static void updateInfo(){
        name.setText("Nombre: " + pe.get(actual).getName());
        height.setText("Altura: " + pe.get(actual).getHeight());
        mass.setText("Masa: " + pe.get(actual).getMass());
        hair_color.setText("Color del Pelo: " + pe.get(actual).getHair_color());
        skin_color.setText("Piel: " + pe.get(actual).getSkin_color());
        eye_color.setText("Ojos: " + pe.get(actual).getEye_color());
        birth_year.setText("Año: " + pe.get(actual).getBirth_year());
        gender.setText("Género: " + pe.get(actual).getGender());
    }

    public static void nextPerson(View view){
        actual = (actual+1)%pe.size();
        updateInfo();
    }

    public static void prevPerson(View view){
        actual = (actual+pe.size()-1)%pe.size();
        updateInfo();
    }

    public void terminate(View view){
        finish();
    }


}
