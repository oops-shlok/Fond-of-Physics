package com.example.spiderappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    public Vibrator vibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                vibe.vibrate(100);
                openlevel_1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                openlevel_2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                openlevel_3();
            }
        });
    }
    int click=0;

    @Override
    public void onBackPressed(){
        click++;
        if(click==100){
            super.onBackPressed();
        }
    }


    public void openlevel_1(){
        Intent intent=new Intent(this,Level_1.class);
        startActivity(intent);
    }
    public void openlevel_2(){
        Intent intent=new Intent(this,Level_2.class);
        startActivity(intent);
    }
    public void openlevel_3(){
        Intent intent=new Intent(this,Level_3.class);
        startActivity(intent);
    }
}

