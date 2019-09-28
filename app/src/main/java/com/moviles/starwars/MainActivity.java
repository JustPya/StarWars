package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public static final String URL_SWAPI = "https://swapi.co/api/";
    private TextView tvName;
    String nameResponse = "";
    private ArrayList<People> pe;
    private ArrayList<Planets> pl;
    private Button people;
    private Button planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.idtext);
        people = findViewById(R.id.people);
        planets = findViewById(R.id.planets);
        pe =  new ArrayList<>();
        pl =  new ArrayList<>();
    }

    public void people(View view){
        callWebService("people");
    }

    public void planets(View view){
        callWebService("planets");
    }

    public void callWebService(String serviceEndPoint) {
        if(serviceEndPoint.equals("people")){
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        URL urlService = new URL (URL_SWAPI + "people" );
                        HttpsURLConnection connection =  (HttpsURLConnection) urlService.openConnection();
                        connection.setRequestMethod("GET");
                        InputStream responseBody = connection.getInputStream();

                        if (connection.getResponseCode() == 200) {
                            // Success
                            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                            BufferedReader b = new BufferedReader(responseBodyReader);
                            String s = b.readLine();
                            System.out.println(s);
                            try{
                                abc(s, "people");
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            // Error handling code goes here
                            Log.v("ERROR", "ERROR");
                        }

                    } catch (MalformedURLException e) {
                        System.out.println(">>>>>>>>>>>>>>");
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out.println(">>>>>>>>>>>>>>adfggalkdfhglk");
                        e.printStackTrace();
                    }
                }
            });

        }else {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        URL urlService = new URL (URL_SWAPI + "planets" );
                        HttpsURLConnection connection =  (HttpsURLConnection) urlService.openConnection();
                        connection.setRequestMethod("GET");
                        InputStream responseBody = connection.getInputStream();

                        if (connection.getResponseCode() == 200) {
                            // Success
                            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                            BufferedReader b = new BufferedReader(responseBodyReader);
                            String s = b.readLine();
                            System.out.println(s);
                            try{
                                abc(s, "planets");
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            // Error handling code goes here
                            Log.v("ERROR", "ERROR");
                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public void abc(String s, String t)throws JSONException{
        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("results");
        if(t.equals("people")){
            for(int i = 0; i < arr.length(); i++) {
                String name = arr.getJSONObject(i).getString("name");
                String height = arr.getJSONObject(i).getString("height");
                String mass = arr.getJSONObject(i).getString("mass");
                String hair_color = arr.getJSONObject(i).getString("hair_color");
                String skin_color = arr.getJSONObject(i).getString("skin_color");
                String eye_color = arr.getJSONObject(i).getString("eye_color");
                String birth_year = arr.getJSONObject(i).getString("birth_year");
                String gender = arr.getJSONObject(i).getString("gender");

                People people = new People(name,height, mass, hair_color, skin_color, eye_color, birth_year, gender);
                System.out.println(people.getName());
                pe.add(people);
            }

            }else{
            for(int i = 0; i < arr.length(); i++) {
                String name = arr.getJSONObject(i).getString("name");
                String rotation_period = arr.getJSONObject(i).getString("rotation_period");
                String orbital_period = arr.getJSONObject(i).getString("orbital_period");
                String diameter = arr.getJSONObject(i).getString("diameter");
                String climate = arr.getJSONObject(i).getString("climate");
                String gravity = arr.getJSONObject(i).getString("gravity");
                String terrain = arr.getJSONObject(i).getString("terrain");
                String surface_water = arr.getJSONObject(i).getString("surface_water");
                String population = arr.getJSONObject(i).getString("population");

                Planets planets = new Planets(name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population);
                pl.add(planets);
                System.out.println(planets.getName());

            }

        }
    }
}
