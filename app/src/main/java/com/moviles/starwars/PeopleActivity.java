package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PeopleActivity extends AppCompatActivity {

    TextView name;
    TextView height;
    TextView mass;
    TextView hair_color;
    TextView skin_color;
    TextView eye_color;
    TextView birth_year;
    TextView gender;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

         name = findViewById(R.id.text_name);
         height= findViewById(R.id.text_height);
         mass= findViewById(R.id.text_mass);
         hair_color= findViewById(R.id.text_hair_color);
         skin_color= findViewById(R.id.text_skin_color);
         eye_color= findViewById(R.id.text_eye_color);
         birth_year = findViewById(R.id.text_birth_year);
         gender = findViewById(R.id.text_gender);




    }
}
