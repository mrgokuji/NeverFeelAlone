package com.example.ubantu.neverfeelalone;

import com.google.firebase.database.IgnoreExtraProperties;

public class Questions {

    public String mQuestions[] = {
            "What is your Gender?",
            "What is your sexual orientation?",
            "How would you describe your body weight?",
            "Are you a virgin?",
            "Is prostitution legal where you live?",
            "Would you pay for sex?",
            "Are you depressed?",
            "Employed?",
            "depressed?",
            "your answers are correct ? ",
            ""


    };

    private String mChoices[][] = {

            {"Male","Female","Transgender male","Transgender female"},
            {"Straight","Bisexual","Gay/Lesbian","NONE OF THESE"},
            {"Normal weight","Underweight","Obese","Overweight"},
            {"Yes","No"," "," "},
            {"Yes","No"," "," "},
            {"No","Yes but I haven't","Yes and I have"," "},
            {"Yes"," "," ","No"},
            {"A student","Employed for wages","Self-employed","Unable to work"},
            {"Yes","NO","",""},
            {"Yes","Its a joke","I'll tell you later","No"},
            {"","","",""}

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