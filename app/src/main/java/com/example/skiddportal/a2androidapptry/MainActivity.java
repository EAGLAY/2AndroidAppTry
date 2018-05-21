package com.example.skiddportal.a2androidapptry;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static SeekBar red,green,blue;

    Button knopf, ok;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv6;

    /*int r = red.getProgress();
    int g = green.getProgress();
    int b = blue.getProgress();*/

    int r,g,b;
    int res1;
    int res2;
    int res3;
    int sum;

    Random rnd = new Random();
    int [] arr = {Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255))};
    int savecolor;
    int savecolor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        knopf = (Button) findViewById(R.id.button);
        ok = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv6 = (TextView) findViewById(R.id.textView6);

        /*int farbe = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
        tv1.setBackgroundColor(farbe);
        tv2.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
        tv3.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
        tv4.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));*/

        Thread delay = new Thread(){
            @Override
            public void run(){
                while (!(isInterrupted()))
                    try {
                        Thread.sleep(1500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                //tv1.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
                                //.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
                                //tv4.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
                                //tv1.setVisibility(View.INVISIBLE);
                                tv1.setBackgroundColor(arr[0]);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*finally {
                       finish();
                    }*/

            }
        };
        delay.start();

        Thread disappear = new Thread(){

            @Override
            public void run(){
                while (!(isInterrupted()))
                    try {
                        Thread.sleep(3000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv1.setVisibility(View.INVISIBLE);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*finally {
                       finish();
                    }*/
            }
        };
        disappear.start();

        seekRed();
        seekBlue();
        seekGreen();
        buttons();

    }



    public void seekRed(){
        red = (SeekBar) findViewById(R.id.skbr1);
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv3.setBackgroundColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
                r = red.getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    public void seekBlue() {
        blue = (SeekBar) findViewById(R.id.skbr2);
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv3.setBackgroundColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
                b = blue.getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void seekGreen(){
        green = (SeekBar) findViewById(R.id.skbr3);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv3.setBackgroundColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
                g = green.getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void buttons(){
        knopf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tv3.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
                //tv3.setBackgroundColor(arr[0]);
                //tv2.setBackgroundColor(arr[1]);
                //tv4.setBackgroundColor(arr[1]);

                /*ColorDrawable farbe = (ColorDrawable) tv3.getBackground();
                savecolor2 = farbe.getColor();
                tv2.setBackgroundColor(savecolor2);
                */
                savecolor = arr[0];
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                        ColorDrawable daisy = (ColorDrawable) tv3.getBackground();
                        savecolor2 = daisy.getColor();
                        tv2.setBackgroundColor(savecolor2);
                        tv4.setBackgroundColor(savecolor);
                        //String colval = String.format("%02x,%02x,%02x",red.getProgress(), green.getProgress(), blue.getProgress());

                        int diff = r-g;
                        int diff1 = r-b;
                        int diff2 = b-g;
                        int sum = diff+diff1;
                        tv6.setText(""+sum);
               }catch (Exception e){

               }
            }
        });
    }
}


