package com.moviles.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public static final String URL_SWAPI = "https://swapi.co/api/";
    private TextView tvName;
    String nameResponse = "";
    People p[];
    private Button people;
    private Button planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.idtext);
        people = findViewById(R.id.people);
        planets = findViewById(R.id.planets);
    }

    public void makeCall(View view){
        callWebService("");
    }

    public void callWebService(String serviceEndPoint) {

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
                            abc(s);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
//                        JSONObject obj = new JSONObject(s);
//
//                        JsonReader jsonReader = new JsonReader(responseBodyReader);
//                        jsonReader.beginObject(); // Start processing the JSON object
//                        String key = jsonReader.nextName(); // Fetch the next key
//                        System.out.println("KEYYYYYYYYYY>>> " + key);
//                        while(jsonReader.hasNext()){
//
//                            System.out.println("OOOOOOOOOOOOOOOOO>>> " + jsonReader.nextString());
//                        }
//                        String value = jsonReader.nextString();
//
//                        Log.v("INFO",value);
//                        nameResponse = value;
//
//                        tvName.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvName.setText(nameResponse);
//
//                            }
//                        });

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
        tvName.setText(nameResponse);
    }

    public void abc(String s)throws JSONException{

    }
}
