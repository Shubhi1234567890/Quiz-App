package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn_start , btn_about;
    TextView name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=(Button) findViewById(R.id.btn_start);
        btn_about=(Button) findViewById(R.id.btn_about);
        name = (TextView) findViewById(R.id.text2);

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String ed_text= name.getText().toString().trim();


                if(TextUtils.isEmpty(name.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Please enter the name first", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent1 = new Intent(MainActivity.this,QuizQuestionActivity.class);
                    intent1.putExtra("message_key",ed_text);
                    startActivity(intent1);
                }

            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,Developers.class);
                startActivity(intent2);
            }
        });







    }
}