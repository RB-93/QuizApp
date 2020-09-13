package com.rohit.examples.android.thefizzquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Splash Activity, very first activity for the app
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Getting view IDs from resource XML
        TextView game_text = findViewById(R.id.textView_game);
        TextView tag_text = findViewById(R.id.textView_tag);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        // Setting progress bar visibility to hidden
        progressBar.setVisibility(View.INVISIBLE);

        // Animation for Game title text
        Animation scale = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.scale_down);
        game_text.startAnimation(scale);

        Animation fade = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);
        tag_text.startAnimation(fade);

        //Handler method to synchronize the delay between view visibility
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        }, 2000);

        // Handler method to delay launching next activity
        // Time to delay next activity launch
        int TIME_OUT = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intentIntro = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(intentIntro);
                finish();
            }
        }, TIME_OUT);
    }
}