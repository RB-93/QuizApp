package com.rohit.examples.android.thefizzquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This activity shows the list of Questions and shows Result upon submission
 */
public class QuizActivity extends AppCompatActivity {

    /**
     * Setting the Main score and the no of correct responses of questions to 0 (zero)
     */
    private int quizScore = 0;
    private int correctAns = 0;

    /**
     * Variable declaration for all the view elements (or widgets) to be presented on screen
     */
    private CardView cvQ1;
    private CardView cvQ2;
    private CardView cvQ3;
    private CardView cvQ4;
    private CardView cvQ5;
    private CardView cvQ6;
    private CardView cvQ7;
    private CardView cvQ8;

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;

    private EditText editText1;
    private EditText editText2;

    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Fetching all the view IDs of the Widget elements from the ID resource
        cvQ1 = findViewById(R.id.CardQ1);
        cvQ2 = findViewById(R.id.CardQ2);
        cvQ3 = findViewById(R.id.CardQ3);
        cvQ4 = findViewById(R.id.CardQ4);
        cvQ5 = findViewById(R.id.CardQ5);
        cvQ6 = findViewById(R.id.CardQ6);
        cvQ7 = findViewById(R.id.CardQ7);
        cvQ8 = findViewById(R.id.CardQ8);

        radioGroup1 = findViewById(R.id.rg1);
        radioGroup2 = findViewById(R.id.rg2);
        radioGroup3 = findViewById(R.id.rg3);
        radioGroup4 = findViewById(R.id.rg4);

        checkBox1 = findViewById(R.id.checkA1);
        checkBox2 = findViewById(R.id.checkB1);
        checkBox3 = findViewById(R.id.checkC1);
        checkBox4 = findViewById(R.id.checkD1);
        checkBox5 = findViewById(R.id.checkA2);
        checkBox6 = findViewById(R.id.checkB2);
        checkBox7 = findViewById(R.id.checkC2);
        checkBox8 = findViewById(R.id.checkD2);

        editText1 = findViewById(R.id.res_et1);
        editText2 = findViewById(R.id.res_et2);

        submit = findViewById(R.id.submit_button);
        Button restart = findViewById(R.id.restart_button);

        // Handling click listener when Restart button is pressed
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restarting the Intro Activity to either display Rules or Start a new Quiz round based on user selection
                Intent intentRestart = new Intent(QuizActivity.this, IntroActivity.class);
                startActivity(intentRestart);

                // Finish current activity as soon as the next activity called and launched
                finish();
            }
        });

        /*
         * Handling click listener for Quiz submission
         * Grading logic for each Quiz correct or incorrect responses fed by the user
         */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Getting selected Ids of user selected choices/options
                int selectedIdRg1 = radioGroup1.getCheckedRadioButtonId();
                int selectedIdRg2 = radioGroup2.getCheckedRadioButtonId();
                int selectedIdRg3 = radioGroup3.getCheckedRadioButtonId();
                int selectedIdRg4 = radioGroup4.getCheckedRadioButtonId();
                boolean selectedCheckBox1 = checkBox1.isChecked();
                boolean selectedCheckBox2 = checkBox2.isChecked();
                boolean selectedCheckBox3 = checkBox3.isChecked();
                boolean selectedCheckBox4 = checkBox4.isChecked();
                boolean selectedCheckBox5 = checkBox5.isChecked();
                boolean selectedCheckBox6 = checkBox6.isChecked();
                boolean selectedCheckBox7 = checkBox7.isChecked();
                boolean selectedCheckBox8 = checkBox8.isChecked();

                // Getting text responses entered by the user into a variable
                String et1Response = editText1.getText().toString();
                String et2Response = editText2.getText().toString();

                /*
                 * Finding buttons for color toggle if right or wrong option(s) is/are checked
                 * Changing colors of the Quiz card to RED, YELLOW & GREEN accordingly
                 * RED, if the response(s) entered is/are incorrect
                 * YELLOW, if there is no response entered by the user (left unselected/ empty)
                 * GREEN, if the response(s) entered is/are correct
                 */
                RadioButton radioButton1 = findViewById(selectedIdRg1);
                RadioButton radioButton2 = findViewById(selectedIdRg2);
                RadioButton radioButton3 = findViewById(selectedIdRg3);
                RadioButton radioButton4 = findViewById(selectedIdRg4);

                // Grading logic for Question No. 1
                if (selectedIdRg1 == R.id.radioB1) {
                    quizScore += 10;
                    correctAns++;
                    cvQ1.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    radioButton1.setTextColor(Color.parseColor("#00E676"));

                } else if (selectedIdRg1 == -1) {
                    cvQ1.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    radioButton1.setTextColor(Color.parseColor("#FF3D00"));
                    cvQ1.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                }

                // Grading logic for Question No. 2
                if (selectedIdRg2 == R.id.radioB2) {
                    quizScore += 10;
                    correctAns++;
                    cvQ2.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    radioButton2.setTextColor(Color.parseColor("#00E676"));
                } else if (selectedIdRg2 == -1) {
                    cvQ2.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    cvQ2.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                    radioButton2.setTextColor(Color.parseColor("#FF3D00"));

                }

                // Grading logic for Question No. 5
                if (selectedIdRg3 == R.id.radioC3) {
                    quizScore += 10;
                    correctAns++;
                    cvQ5.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    radioButton3.setTextColor(Color.parseColor("#00E676"));
                } else if (selectedIdRg3 == -1) {
                    cvQ5.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    cvQ5.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                    radioButton3.setTextColor(Color.parseColor("#FF3D00"));
                }

                // Grading logic for Question No. 7
                if (selectedIdRg4 == R.id.radioD4) {
                    quizScore += 10;
                    correctAns++;
                    cvQ7.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    radioButton4.setTextColor(Color.parseColor("#00E676"));
                } else if (selectedIdRg4 == -1) {
                    cvQ7.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    cvQ7.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                    radioButton4.setTextColor(Color.parseColor("#FF3D00"));
                }

                // Grading logic for Question No. 3
                if ((selectedCheckBox2 && selectedCheckBox4) && (!selectedCheckBox1 && !selectedCheckBox3)) {
                    quizScore += 20;
                    correctAns++;
                    cvQ3.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox4.setTextColor(Color.parseColor("#00E676"));
                } else if ((selectedCheckBox2) && (!selectedCheckBox4 && !selectedCheckBox1 && !selectedCheckBox3)) {
                    quizScore += 10;
                    cvQ3.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox4.setTextColor(Color.parseColor("#00E676"));
                } else if ((selectedCheckBox4) && (!selectedCheckBox2 && !selectedCheckBox1 && !selectedCheckBox3)) {
                    quizScore += 10;
                    cvQ3.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox4.setTextColor(Color.parseColor("#00E676"));
                } else if (selectedCheckBox1 || selectedCheckBox3) {
                    checkBox1.setTextColor(Color.parseColor("#FF3D00"));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox3.setTextColor(Color.parseColor("#FF3D00"));
                    checkBox4.setTextColor(Color.parseColor("#00E676"));
                    cvQ3.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                } else {
                    cvQ3.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                }

                // Grading logic for Question No. 8
                if ((selectedCheckBox6 && selectedCheckBox7) && (!selectedCheckBox5 && !selectedCheckBox8)) {
                    quizScore += 20;
                    correctAns++;
                    cvQ8.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox6.setTextColor(Color.parseColor("#00E676"));
                    checkBox7.setTextColor(Color.parseColor("#00E676"));
                } else if ((selectedCheckBox6) && (!selectedCheckBox7 && !selectedCheckBox5 && !selectedCheckBox8)) {
                    quizScore += 10;
                    cvQ8.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox7.setTextColor(Color.parseColor("#00E676"));
                } else if ((selectedCheckBox7) && (!selectedCheckBox6 && !selectedCheckBox5 && !selectedCheckBox8)) {
                    quizScore += 10;
                    cvQ8.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    checkBox2.setTextColor(Color.parseColor("#00E676"));
                    checkBox7.setTextColor(Color.parseColor("#00E676"));
                } else if (selectedCheckBox5 || selectedCheckBox8) {
                    checkBox6.setTextColor(Color.parseColor("#00E676"));
                    checkBox5.setTextColor(Color.parseColor("#FF3D00"));
                    checkBox7.setTextColor(Color.parseColor("#00E676"));
                    checkBox8.setTextColor(Color.parseColor("#FF3D00"));
                    cvQ8.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                } else {
                    cvQ8.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                }

                // Grading logic for Question No. 4
                if (et1Response.equals("4")) {
                    quizScore += 10;
                    correctAns++;
                    cvQ4.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    editText1.setTextColor(Color.parseColor("#00E676"));

                } else if (et1Response.isEmpty()) {
                    cvQ4.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    cvQ4.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                    editText1.setTextColor(Color.parseColor("#FF3D00"));
                }

                // Grading logic for Question No. 6
                if (et2Response.equalsIgnoreCase("Missouri")) {
                    quizScore += 10;
                    correctAns++;
                    cvQ6.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.correctColorCard));
                    editText2.setTextColor(Color.parseColor("#00E676"));
                } else if (et2Response.isEmpty()) {
                    cvQ6.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.noAttemptCardColor));
                } else {
                    cvQ6.setBackgroundColor(ContextCompat.getColor(QuizActivity.this, R.color.wrongCardColor));
                    editText2.setTextColor(Color.parseColor("#FF3D00"));
                }

                // Once all responses submitted, disabled the SUBMIT BUTTON
                submit.setEnabled(false);

                // Function callback to show Quiz Result
                getResult();
            }
        });
    }

    /**
     * Method to display the result in the toast message with Correct No. of Quiz response(s)
     */
    private void getResult() {
        Toast.makeText(this, "You got " + quizScore + " points", Toast.LENGTH_LONG)
                .show();
        Toast.makeText(this, "Total ques: 8 \n Correct Ans: " + correctAns, Toast.LENGTH_LONG)
                .show();
    }

    /**
     * Handling Back navigation, showing the user a toast message about Quiz progress reset
     */
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "All progress reset", Toast.LENGTH_SHORT).show();
        moveTaskToBack(false);
        super.onBackPressed();
    }
}