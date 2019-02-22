//package com.example.ubantu.neverfeelalone;

public class Questions {

    public String mQuestions[] = {
            "WHAT IS 1?",
            "WHAT IS 2?",
            "WHAT IS 3?",
            "WHAT IS 4?",
            "WHAT IS 5?",
            "WHAT IS 6?",
            "WHAT IS 7?",
            "WHAT IS 8?",
            "WHAT IS 9?"


    };

    private String mChoices[][] = {

            {"number 1","number 2","number 3","number 4"},
            {"number 1","number 2","number 3","number 4"},
            {"number 1","number 2","number 3","number 4"},
            {"number 1","number 2","number 3","number 4"},
            {"number 5","number 2","number 3","number 4"},
            {"number 6","number 2","number 3","number 4"},
            {"number 7","number 2","number 3","number 4"},
            {"number 8","number 2","number 3","number 4"},
            {"number 9","number 2","number 3","number 4"}

    };

    public String getQuestion (int a){
        String question = mQuestions[a];
        return question;
    }

    public  String getChoice1(int a){
        String choice = mChoices[a][0];
        return  choice;
    }

    public  String getChoice2(int a){
        String choice = mChoices[a][1];
        return  choice;
    }

    public  String getChoice3(int a){
        String choice = mChoices[a][2];
        return  choice;
    }

    public  String getChoice4(int a){
        String choice = mChoices[a][3];
        return  choice;
    }



}
