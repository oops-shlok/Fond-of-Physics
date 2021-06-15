package com.example.spiderappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Level_2 extends AppCompatActivity {
    double v;
    double lorz;
    int c=3*100000000;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        EditText input = findViewById(R.id.speed);
        EditText input2= findViewById(R.id.lorentz);
        Button check = findViewById(R.id.check);
        result= findViewById(R.id.answer);
        final Vibrator vibe = (Vibrator) Level_2.this.getSystemService(Context.VIBRATOR_SERVICE);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputLor= input.getText().toString();
                String lorentzcal = input2.getText().toString();
                double v = Double.parseDouble(inputLor);
                double lorz = Double.parseDouble(lorentzcal);
                double gamma = calcluatelorentz(v);
                if(v>=c || v<0){
                    Toast.makeText(Level_2.this,"Invalid Input of speed",Toast.LENGTH_SHORT).show();
                }else{
                    if(gamma == lorz){
                        Toast.makeText(Level_2.this,"Yay! Your Answer is Correct ! ✌🏻",Toast.LENGTH_SHORT).show();
                        result.setBackgroundColor(Color.GREEN);
                    }else{
                        Toast.makeText(Level_2.this,"Oops! Your Answer is Incorrect ! 🙁",Toast.LENGTH_SHORT).show();
                        result.setBackgroundColor(Color.RED);
                        vibe.vibrate(100);
                    }
                }
            }
        });
    }

    double calcluatelorentz(double v){
        double gamma = 1 / (Math.sqrt(1 - (Math.pow(v, 2) / Math.pow(c, 2))));
        result.setText(String.valueOf((gamma)));
        return gamma;
    }

}