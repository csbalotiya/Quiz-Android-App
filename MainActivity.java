package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView optionA, optionB, optionD,optionC;
    private TextView  questionNumber,question , score;
    private TextView checkout1,checkout2 ;
    int currentIndex = 0 ;
    int mscore = 0;
    int qn = 1;
    ProgressBar progressBar;
    int currentQuestion,currentOptionA,currentOptionB,currentOptionC,currentOptionD ;

    private AnswerClass[] questionBank = new AnswerClass[]{

       new AnswerClass(R.string.Question1, R.string.Question1_A, R.string.Question1_B, R.string.Question1_C, R.string.Question1_D, R.string.Answer1),
       new AnswerClass(R.string.Question2, R.string.Question2_A, R.string.Question2_B, R.string.Question2_C, R.string.Question2_D, R.string.Answer2),
       new AnswerClass(R.string.Question3, R.string.Question3_A, R.string.Question3_B, R.string.Question3_C, R.string.Question3_D, R.string.Answer3),
       new AnswerClass(R.string.Question4, R.string.Question4_A, R.string.Question4_B, R.string.Question4_C, R.string.Question4_D, R.string.Answer4),
       new AnswerClass(R.string.Question5, R.string.Question5_A, R.string.Question5_B, R.string.Question5_C, R.string.Question5_D, R.string.Answer5)
    };

    final  int PROGRESS_BAR = (int)Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionA =findViewById(R.id.OptionA);
        optionB =findViewById(R.id.OptionB);
        optionC =findViewById(R.id.OptionC);
        optionD =findViewById(R.id.OptionD);

        question = findViewById(R.id.Question);
        score = findViewById(R.id.Score);
        questionNumber = findViewById(R.id.QuestionNumber);

        checkout1 = findViewById(R.id.selectoption);
        checkout2 = findViewById(R.id.CorrectAnswer);
        progressBar = findViewById(R.id.ProgressBar);

        currentQuestion = questionBank[currentIndex].getQuestionId();
        question.setText(currentQuestion);

        currentOptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);
        currentOptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);

        currentOptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);

        currentOptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);

       optionA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               checkAnswer(currentOptionA);
               updateQuestion();
           }
       });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionB);
                updateQuestion();
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionC);
                updateQuestion();
            }
        });
        optionD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionD);
                updateQuestion();
            }
        });

    }
    private void checkAnswer(int userSelection) {

        int correctAnswer = questionBank[currentIndex].getAnswerId();

        checkout1.setText(userSelection);
        checkout2.setText(correctAnswer);

        String m = checkout1.getText().toString().trim();
        String n = checkout2.getText().toString().trim();

        if(m.equals(n)){
            Toast.makeText(getApplicationContext(), "Right",Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong",Toast.LENGTH_SHORT).show();
        }

    }

    private void updateQuestion() {

        currentIndex = (currentIndex+1)%questionBank.length;
        currentQuestion = questionBank[currentIndex].getQuestionId();
        question.setText(currentQuestion);


        currentQuestion = questionBank[currentIndex].getQuestionId();
        question.setText(currentQuestion);
        currentOptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);
        currentOptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);
        currentOptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);
        currentOptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);
        qn = qn+1;
        if(qn <= questionBank.length){
            questionNumber.setText(qn + "/"+questionBank.length+"Question");
        }
        score.setText("Score" + mscore+"/"+questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);
    }

}
