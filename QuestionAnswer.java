package com.example.quizapp;

public class QuestionAnswer {

    public static String[] question = {


            "Which method can be defined only once in a program ?",
            "Which keyword is used by method to refer to the current object that invoked it ?",
            "Which of these access specifiers can be used for an interface ?",
            "Which of the following is the correct way of importing an entire package ?",
            "What is the return type of Constructors ?"

    };

    public static String[][] options ={

            {"finalise method","main method","static method","private method"},
            {"import","this","catch","abstract"},
            {"public","protected","private","All of the mentioned"},
            {"Importpkg.","importpkg.*","Importpkg.*","importpkg."},
            {"int","float","void","None of the mentioned"}

    };

    public static String correct_answer[] = {

            "main method",
            "this",
            "public",
            "importpkg.*",
            "None of the mentioned"

    };

}
