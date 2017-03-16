package com.example.android.myquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int finalScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitScore(v);
            }
        });
    }


    public void submitScore(View view) {
        score = 0;

        boolean checkedMercury = false;
        boolean checkedPluto = false;
        boolean checkedRadioButton1 = false;
        boolean checkedRadioButton2 = false;
        boolean checkedMelvill = false;
        boolean checkedAlan = false;
        boolean checkedJasmine = false;

        EditText answerOne = (EditText) findViewById(R.id.answer1);
        String answer1 = answerOne.getText().toString().trim();
        if (answer1.matches("Blue")) {
            score++;
        }
        CheckBox melvillCheckBox = (CheckBox) findViewById(R.id.Melvill);
        checkedMelvill = melvillCheckBox.isChecked();

        CheckBox alanCheckBox = (CheckBox) findViewById(R.id.Alan);
        checkedAlan = alanCheckBox.isChecked();

        CheckBox jasmineCheckBox = (CheckBox) findViewById(R.id.Jasmine);
        checkedJasmine = jasmineCheckBox.isChecked();

        EditText answerThree = (EditText) findViewById(R.id.answer3);
        String answer3 = answerThree.getText().toString().trim();

        if (answer3.matches("Blue,Red,Green")) {
            score++;
        }

        CheckBox mercuryCheckBox = (CheckBox) findViewById(R.id.Mercury);
        checkedMercury = mercuryCheckBox.isChecked();

        CheckBox plutoCheckBox = (CheckBox) findViewById(R.id.Pluto);
        checkedPluto = plutoCheckBox.isChecked();

        RadioButton radiobutton1 = (RadioButton) findViewById(R.id.RadioButton1);
        checkedRadioButton1 = radiobutton1.isChecked();

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.RadioButton2);
        checkedRadioButton2 = radioButton2.isChecked();

        finalScore = calculateScore(checkedJasmine, checkedAlan, checkedMelvill, checkedMercury, checkedPluto, checkedRadioButton1, checkedRadioButton2);

        displayMessage("Your Score is:" + finalScore);
    }

    //calculate score
    private int calculateScore(boolean checkedJasmine, boolean checkedAlan, boolean checkedMelvill, boolean checkedMercury, boolean checkedPluto, boolean checkedRadioButton1, boolean checkedRadioButton2) {


        if (checkedAlan) {
            score++;
        }

        if (checkedMercury) {
            score++;
        }


        if (checkedRadioButton2) {
            score++;
        }
        return score;
    }

    //Print Score
    private void displayMessage(String message) {
        TextView finalScoreTextView = (TextView) findViewById(R.id.final_score);
        finalScoreTextView.setText(message);

        if (finalScore == 5) {
            Toast.makeText(this, "Congratulations! You have a perfect score!", Toast.LENGTH_SHORT).show();
        }
        if (finalScore == 4) {
            Toast.makeText(this, "Your final score is 4!", Toast.LENGTH_SHORT).show();
        } else if (finalScore == 3) {
            Toast.makeText(this, "Your final score is 3!", Toast.LENGTH_SHORT).show();
        } else if (finalScore == 2) {
            Toast.makeText(this, "Your final score is 2", Toast.LENGTH_SHORT).show();
        } else if (finalScore == 1) {
            Toast.makeText(this, "Your final score is 1", Toast.LENGTH_SHORT).show();
        } else if (finalScore == 0) {
            Toast.makeText(this, "You need to improve your General knowledge", Toast.LENGTH_SHORT).show();
        }

    }

    // Reset Score
    public void Reset(View v) {
        score = 0;
        //finalScore = 0;
        displayMessage("Score set to Zero");
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.RadioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.RadioButton2);
        CheckBox melvillCheckBox = (CheckBox) findViewById(R.id.Melvill);
        CheckBox alanCheckBox = (CheckBox) findViewById(R.id.Alan);
        CheckBox jasmineCheckBox = (CheckBox) findViewById(R.id.Jasmine);
        CheckBox mercuryCheckBox = (CheckBox) findViewById(R.id.Mercury);
        CheckBox plutoCheckBox = (CheckBox) findViewById(R.id.Pluto);
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        melvillCheckBox.setChecked(false);
        alanCheckBox.setChecked(false);
        jasmineCheckBox.setChecked(false);
        mercuryCheckBox.setChecked(false);
        plutoCheckBox.setChecked(false);
        EditText answerOne = (EditText) findViewById(R.id.answer1);
        answerOne.setText("");
        EditText answerThree = (EditText) findViewById(R.id.answer3);
        answerThree.setText("");
    }
}





