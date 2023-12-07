package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView welcome, luckyNum;
    Button share_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = findViewById(R.id.luckyNumText);
        luckyNum = findViewById(R.id.luckyNum);
        share_button = findViewById(R.id.button);

        Intent i = getIntent();
        String name = i.getStringExtra("name");

        int randomNum = generateRandom();
        luckyNum.setText(""+randomNum);

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(name, randomNum);
            }
        });
    }

    public int generateRandom(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(1000);
        return randomNumberGenerated;
    }

    public void shareData(String name, int randNum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "Their Lucky number was "+randNum);

        startActivity(Intent.createChooser(i, "Choose a Platform Dude!"));
    }
}