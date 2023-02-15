package com.example.skygrassroot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] skyLetter = {"f", "d","h","l","k","t","b"};
    String [] grassLetter = {"a","c","e","i","m","n","o","r","s","u","v","w","x","z"};
    String [] rootLetter = {"g","j","p","q","y"};
    Button btnSky, btnRoot, btnGrass;
    TextView textView, textViewAnswer, textViewGrassInfo, TextViewRootInfo, TextViewSkyInfo;
    int category = 0, index=0, grassCorrectCount=0, grassWrongCount=0, skyCorrectCount=0, skyWrongCount=0, rootCorrectCount=0, rootWrongCount=0;
    String answer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky_grass_root);

        btnSky = findViewById(R.id.btnSky);
        btnSky.setOnClickListener(this);
        btnRoot = findViewById(R.id.btnRoot);
        btnRoot.setOnClickListener(this);
        btnGrass = findViewById(R.id.btnGrass);
        btnGrass.setOnClickListener(this);
        textView = findViewById(R.id.textViewSkyRoot);
        textViewAnswer = findViewById(R.id.textViewSkyResult);
        textViewGrassInfo = findViewById(R.id.textViewResultGrass);
        TextViewRootInfo = findViewById(R.id.textViewResultRoot);
        TextViewSkyInfo = findViewById(R.id.textViewResultSky);

        GenerateLetter();

    }

    private void GenerateLetter() {
        Random rnd = new Random();
        category = rnd.nextInt(3);
        if (category ==0){
            index = rnd.nextInt(skyLetter.length);
            textView.setText(skyLetter[index]);
            answer = "SKY";
        } else if (category == 1){
            index = rnd.nextInt(rootLetter.length);
            textView.setText(rootLetter[index]);
            answer = "ROOT";
        }else if (category ==2){
            index = rnd.nextInt(grassLetter.length);
            textView.setText(grassLetter[index]);
            answer = "GRASS";
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGrass:
                if (answer == "GRASS") {
                    textViewAnswer.setText("Awesome!");
                    grassCorrectCount++;
                } else {
                    textViewAnswer.setText("OOPs!!");
                    grassWrongCount++;
                }
                textViewGrassInfo.setText("Grass Letters\nRight " + grassCorrectCount + "\nWrong " + grassWrongCount);
                break;
            case R.id.btnSky:
                if (answer == "SKY") {
                    textViewAnswer.setText("Awesome!");
                    skyCorrectCount++;
                } else {
                    textViewAnswer.setText("OOPs!!");
                    skyWrongCount++;
                }
                TextViewSkyInfo.setText("Sky Letters\nRight " + skyCorrectCount + "\nWrong " + skyWrongCount);
                break;
            case R.id.btnRoot:
                if (answer == "ROOT") {
                    textViewAnswer.setText("Awesome!");
                    rootCorrectCount++;
                } else {
                    textViewAnswer.setText("OOPs!!");
                    rootWrongCount++;
                }
                TextViewRootInfo.setText("Root\nRight " + rootCorrectCount + "\nWrong " + rootWrongCount);
                break;
        }
        GenerateLetter();
    }
}