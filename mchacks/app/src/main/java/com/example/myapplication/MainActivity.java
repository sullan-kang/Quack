package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.SystemClock;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    private int count = 0;
    Context context = this;
    private long lastClickTime = 0;
    private MediaPlayer mp;
    private int angrycout=0;
    private long changeClock= 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button btn = (Button) findViewById(R.id.btn);
        final GifImageButton gif = (GifImageButton) findViewById(R.id.gif);
        //final MediaPlayer mp = MediaPlayer.create(context, R.raw.quack);
        //final MediaPlayer md = MediaPlayer.create(context, R.raw.pissed_quack);
       // final RelativeLayout ly = (RelativeLayout) findViewById(R.id.bg);
        //txt = (TextView) findViewById(R.id.btn);

        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                count++;
                changeClock = lastClickTime;

                if (angrycout==20){
                    //ly.setBackgroundResource(R.drawable.fried_bg);
                    //gif.setImageResource(R.drawable.fried_bg);
                    gif.getBackground().setAlpha(0);
                    gif.setAlpha(0);
                    return;

                }

                gif.setImageResource(R.drawable.picture2);


                stopPlaying();
                mp=MediaPlayer.create(context, R.raw.quack);
                mp.start();

                if (SystemClock.elapsedRealtime() - lastClickTime < 1000) {
                    gif.setImageResource(R.drawable.picture3);
                    if (mp.isPlaying()) {
                        stopPlaying();
                        mp=MediaPlayer.create(context, R.raw.pissed_quack);
                        angrycout++;
                        mp.start();
                    }

                }

                lastClickTime = SystemClock.elapsedRealtime();
                if (SystemClock.elapsedRealtime() - changeClock >1500) {
                    gif.setImageResource(R.drawable.picture1);}

                    //if (SystemClock.elapsedRealtime() - lastClickTime > 250){
                //    gif.setImageResource(R.drawable.picture1);
                //}

              /*  try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        //mp.release();
                        //mp = MediaPlayer.create(context, R.raw.quack);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }
*/


                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void stopPlaying() {
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}