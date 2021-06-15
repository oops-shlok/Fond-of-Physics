package com.example.spiderappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class Level_3 extends AppCompatActivity {
    TextView result;
    TextView time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        result=findViewById(R.id.result);
        Button getRes = findViewById(R.id.getRes);
        time=findViewById(R.id.textView11);
        getRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeZone timeZone = TimeZone.getTimeZone("Asia/Delhi");
                Calendar calendar = Calendar.getInstance(timeZone);
                int h = calendar.get(Calendar.HOUR);
                int m = calendar.get(Calendar.MINUTE);
                int s = calendar.get(Calendar.SECOND);
                double spi=calculatespi(h,m,s);
                time.setText(String.valueOf(h)+":"+String.valueOf(m)+":"+String.valueOf(s));
                result.setText(String.valueOf(spi));
            }
        });
    }
    static int factorial(double n){
        int x=1;
        for(int i=1;i<=n;i++) {
            x=x*i;
        }
        return x;
    }
    static double calculatespi(double h, double m, double s){
        double spivalue = (factorial(h)/((m*m*m)+s));
        return spivalue;
    }
}
