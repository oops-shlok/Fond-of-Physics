package com.example.spiderappdev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Level_1 extends AppCompatActivity {
    double v;
    int c=3*100000000;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        EditText input = findViewById(R.id.speed);
        Button calculatebtn = findViewById(R.id.calculate);
        Result = findViewById(R.id.result);
        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputLor= input.getText().toString();
                double v = Double.parseDouble(inputLor);
                calculatebtnLor(v);
                if(input.equals(null)){
                    Toast.makeText(Level_1.this,"Enter a value",Toast.LENGTH_SHORT).show();
                }
                if(v>=c || v<=0 ){
                    Toast.makeText(Level_1.this,"Invalid Input In v",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void calculatebtnLor(double v){
        double gamma = 1 / (Math.sqrt(1 - (Math.pow(v, 2) / Math.pow(c, 2))));
        Result.setText(String.valueOf((gamma)));
    }

}