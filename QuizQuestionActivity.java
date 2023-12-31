package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.R.id;

public class QuizQuestionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView receiver_msg,text;
    TextView question,totalQuestionsTextView;
    Button btn_option1,btn_option2,btn_option3,btn_option4,btn_nextquestion,btn_quit1;

    int score=0;
    int totalQuestion= QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);


        receiver_msg=(TextView) findViewById(R.id.text);
        text=(TextView)findViewById(id.text1);
        question=(TextView) findViewById(R.id.text2);
        totalQuestionsTextView=(TextView)findViewById(R.id.textView);
        btn_option1=(Button) findViewById(R.id.button_1);
        btn_option2=(Button) findViewById(R.id.button_2);
        btn_option3=(Button) findViewById(R.id.button_3);
        btn_option4=(Button) findViewById(R.id.button_4);
        btn_nextquestion=(Button) findViewById(R.id.button_next);
        btn_quit1=(Button) findViewById(R.id.button_quit);

        Intent intent=getIntent();
        String str= intent.getStringExtra("message_key");

        receiver_msg.setText(str);


       btn_option1.setOnClickListener(this);
       btn_option2.setOnClickListener(this);
       btn_option3.setOnClickListener(this);
       btn_option4.setOnClickListener(this);
       btn_nextquestion.setOnClickListener(this);
       btn_quit1.setOnClickListener(this);


       totalQuestionsTextView.setText("Total Questions: "+totalQuestion);

       LoadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        btn_option1.setBackgroundColor(Color.YELLOW);
        btn_option2.setBackgroundColor(Color.YELLOW);
        btn_option3.setBackgroundColor(Color.YELLOW);
        btn_option4.setBackgroundColor(Color.YELLOW);
        question.setTextColor(Color.BLACK);
        totalQuestionsTextView.setTextColor(Color.BLACK);


        Button clickedButton = (Button) view;
        if (clickedButton.getId()== id.button_next){

            LoadNewQuestion();
            if(selectedAnswer.equals(QuestionAnswer.correct_answer[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;

            LoadNewQuestion();

        }else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
        if(clickedButton.getId()==id.button_quit){
            String passStatus ="";
            if(score>totalQuestion*0.6){
                passStatus="Passed";
            }
            else{
                passStatus="Failed";
            }

            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is"+score+"out of"+totalQuestion)
                    .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                    .setCancelable(false)
                    .show();

        }

    }

    void LoadNewQuestion(){

        if(currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;
        }


        question.setText(QuestionAnswer.question[currentQuestionIndex]);
        btn_option1.setText(QuestionAnswer.options[currentQuestionIndex][0]);
        btn_option2.setText(QuestionAnswer.options[currentQuestionIndex][1]);
        btn_option3.setText(QuestionAnswer.options[currentQuestionIndex][2]);
        btn_option4.setText(QuestionAnswer.options[currentQuestionIndex][3]);


    }
    void finishQuiz(){
        String passStatus ="";
        if(score>totalQuestion*0.6){
            passStatus="Passed";
        }
        else{
            passStatus="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is"+score+"out of"+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();



    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        LoadNewQuestion();
    }

}