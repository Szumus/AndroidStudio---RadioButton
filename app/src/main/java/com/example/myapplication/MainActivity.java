package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int correctAnswres = 0;
    private TextView error, wynik;

    private Button btnCheck;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = findViewById(R.id.errorTextView);
        wynik = findViewById(R.id.resultTextView);
        btnCheck = findViewById(R.id.checkAnswersButton);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswres = 0;

                boolean allAnswer = true;

                if(!answer1()) allAnswer = false;
                if(!answer2()) allAnswer = false;
                if(!answer3()) allAnswer = false;
                if(!answer4()) allAnswer = false;

                if(allAnswer = true){
                    if(correctAnswres >= 3){
                        wynik.setText("Wygrałeś!! Zdobyte punkty: " + correctAnswres);
                        wynik.setTextColor(Color.GREEN);
                    } else if (correctAnswres <= 2) {
                        wynik.setText("Przegrałeś!! :< Zdobyte punkty:  " + correctAnswres);
                        wynik.setTextColor(Color.RED);
                    }else{
                        wynik.setText("Zdobyte punkty: " + correctAnswres);
                    }
                } else{
                    error.setText("Odpowiedzi nie mogą zostać puste!");
                }

            }
        });
    }


    private boolean answer1() {
        RadioGroup radio1 = findViewById(R.id.radioGroup);
        int selectedId = radio1.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return false;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        if (selectedAnswer.equals("Trinity Force")){
            correctAnswres++;
        }
        return true;
    };

    private boolean answer2() {
        RadioGroup radio1 = findViewById(R.id.radioGroup2);
        int selectedId = radio1.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return false;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        if (selectedAnswer.equals("Riot Games")){
            correctAnswres++;
        }
        return true;

    };

    private boolean answer3() {
        RadioGroup radio1 = findViewById(R.id.radioGroup4);
        int selectedId = radio1.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return false;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        if (selectedAnswer.equals("Mid,Jungle,Top")){
            correctAnswres++;
        }
        return true;

    };

    private boolean answer4(){
        RadioGroup radio1 = findViewById(R.id.radioGroup3);
        int selectedId = radio1.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return false;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        if (selectedAnswer.equals("Pyke")){
            correctAnswres++;
        }
        return true;

    }
}
