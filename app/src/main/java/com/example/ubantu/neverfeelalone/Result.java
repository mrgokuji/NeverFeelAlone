package com.example.ubantu.neverfeelalone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;

public class Result extends AppCompatActivity {
    TextView tv;
    String finalData;
    private DatabaseReference mDatabase;
    private DatabaseReference demoRef;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tv = (TextView) findViewById(R.id.Result);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        getResult();

        //getKeysFromFile();
    }

    private void getResult(){
        try{

            String mainData = "";
            FileInputStream fin = openFileInput("Killer.list");
            int c;
            finalData = "Results : ";
            while( (c = fin.read()) != -1){
                if(c == 10){
                    finalData += "\n";
                    tv.setText(finalData);
                    if(mainData.equalsIgnoreCase("")){
                        continue;
                    }
                    else{
                        demoRef = mDatabase.child(mainData);
                        finalData += mainData;
                        tv.setText(finalData);
                        mainData = "";
                        demoRef.child("Result").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               finalData += dataSnapshot.getValue();
                                tv.setText(finalData);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                finalData += "Didnot get";
                                tv.setText(finalData);
                            }
                        });
                        continue;
                    }
                }
                mainData += Character.toString((char)c);
            }
            tv.setText(finalData);
        } catch(Exception e){

        }

    }

    private void getKeysFromFile(){
        try{

            String mainData = "Contents : ";
            FileInputStream fin = openFileInput("Killer.list");
            int c;
            while( (c = fin.read()) != -1){
                mainData += Character.toString((char)c);
            }
            tv.setText(mainData);
        } catch(Exception e){
        }
    }
}
