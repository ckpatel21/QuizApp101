package com.example.selfanalysisquiz;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.selfanalysisquiz.MESSAGE";

    private String [] questions = {"Do you complain often of \"feeling bad,\" and if so, what is the cause?",
            "Do you find fault with other people at the slightest provocation?",
            "Do you frequently make mistakes in your work, and if so, why?",
            "Are you sarcastic and offensive in your conversation?",
            "Do you suffer frequently with indigestion? If so, what is the cause?",
            "Do you deliberately avoid the association of anyone, and if so, why?",
            "Does life seem futile and the future hopeless to you?",
            "Do you like your occupation? If not, why?",
            "Do you often feel self-pity, and if so why?",
            "To which do you devote most time, thinking of SUCCESS, or of FAILURE?" };


    private Integer score = 0;

    Button yes;
    Button no;

    TextView question;

    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index+1 == questions.length){
//                    Toast.makeText(MainActivity.this, "Your score is " + score, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Result.class);
                    String res = score.toString();
                    intent.putExtra(EXTRA_MESSAGE, res);
                    startActivity(intent);
                }
                question.setText(questions[++index]);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                if (index+1 == questions.length){
//                    Toast.makeText(MainActivity.this, "Your score is " + score, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Result.class);
                    String res = score.toString();
                    intent.putExtra(EXTRA_MESSAGE, res);
                    startActivity(intent);
                }
                question.setText(questions[++index]);
            }
        });

    }
}