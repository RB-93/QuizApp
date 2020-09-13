package com.rohit.examples.android.thefizzquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.Objects;

/**
 * Activity to show Quiz Rules and starting Quiz Activity
 */
public class IntroActivity extends AppCompatActivity {

    // Variable declaration for the views/widgets on the screen
    private ConstraintLayout constraintLayout;

    private CardView rule_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Finding View Ids of the elements
        constraintLayout = findViewById(R.id.cl);
        Button rule_button = findViewById(R.id.rules_btn);
        Button start_button = findViewById(R.id.start_btn);

        // Inflating the popup window over the current activity to handle view IDs from different XML layout file
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = Objects.requireNonNull(inflater).inflate(R.layout.rules_popup, null);

        final PopupWindow popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rule_card = popupView.findViewById(R.id.cv_rules);

        // Hiding the view - popup view from the interface
        rule_card.setVisibility(View.GONE);

        // Setting Click listener for the Rules Button to show or hide Rules Popup window.
        rule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Handling touch events for the popup window to manipulate hiding and showing the popup
                        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                            public boolean onTouch(View v, MotionEvent event) {
                                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                                    popupWindow.dismiss();
                                    return true;
                                }
                                return false;
                            }
                        });
                        popupWindow.setOutsideTouchable(true);
                        popupWindow.showAtLocation(constraintLayout, Gravity.BOTTOM, 0, 0);
                        Animation slide = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.slide_up);
                        rule_card.startAnimation(slide);
                        rule_card.setVisibility(View.VISIBLE);
                    }
                }, 100);
            }
        });

        //Handling click listener for launching Quiz Activity
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStart = new Intent(IntroActivity.this, QuizActivity.class);
                startActivity(intentStart);

            }
        });
    }
}