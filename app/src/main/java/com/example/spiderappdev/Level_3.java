package com.example.spiderappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class Level_3 extends AppCompatActivity {
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        Button getResult = findViewById(R.id.getRes);
        result=findViewById(R.id.result);
        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar t = Calendar.getInstance();
                int h = t.get(Calendar.HOUR);
                int m = t.get(Calendar.MINUTE);
                int s = t.get(Calendar.SECOND);
                double sp=getSpifactor(h,m,s);
                result.setText(String.valueOf(sp));
            }
        });
    }
    static int factorial(int n){
        int x=1;
        for(int i=1;i<=n;i++){
            x=x*i;
        }
        return x;
    }
    double getSpifactor(int h, int m, int s){
        double spi = (factorial(h))/((m*m*m)+(s));
        result.setText(String.valueOf((spi)));
        return spi;
    }

}