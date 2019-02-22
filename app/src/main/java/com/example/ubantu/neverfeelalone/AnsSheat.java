package com.example.ubantu.neverfeelalone;

public class AnsSheat {

    public String[] ques = new String[10];
    public String[] ans = new String[10];

    public AnsSheat() {
    }

    public AnsSheat(String[] ques, String[] ans) {
        this.ques = ques;
        this.ans = ans;
    }

    public void addVal(String ques, String ans, int pos){
        this.ques[pos] = ques;
        this.ans[pos] = ans;
    }
}
