package com.example.spiderappdev;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Level_3 extends AppCompatActivity {
    TextView result;
    TextView time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        result=findViewById(R.id.result);
        time=findViewById(R.id.textView11);
        Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                                String dateTime = simpleDateFormat.format(calendar.getTime());
                                time.setText(dateTime);
                                int hh = calendar.get(Calendar.HOUR);
                                int mm = calendar.get(Calendar.MINUTE);
                                int ss = calendar.get(Calendar.SECOND);
                                double spi= calculatespi(hh,mm,ss);
                                result.setText(String.valueOf(spi));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }


    static int factorial(double n){
        int x=1;
        for(int i=1;i<=n;i++) {
            x=x*i;
        }
        return x;
    }
    static double calculatespi(double hh, double mm, double ss){
        double spivalue = (factorial(hh)/((mm*mm*mm)+ss));
        return spivalue;
    }
}