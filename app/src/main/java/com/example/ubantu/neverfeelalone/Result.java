package com.example.ubantu.neverfeelalone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Result extends AppCompatActivity {
    TextView tv;
    Button clear;
    String finalData;
    private DatabaseReference mDatabase;
    private DatabaseReference demoRef;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tv = (TextView) findViewById(R.id.s);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        clear = (Button) findViewById(R.id.clear);
        getResult();

        //getKeysFromFile();
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput("Killer.list", MODE_PRIVATE);
                    outputStream.close();
                    finalData = "Loading...\n";
                    tv.setText(finalData);
                    getResult();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void getResult(){
        try{

            String mainData = "";
            FileInputStream fin = openFileInput("Killer.list");
            int c;
            finalData = "Results :\n";
            while( (c = fin.read()) != -1){
                if(c == 10){
                    if(mainData.equalsIgnoreCase("")){
                        continue;
                    }
                    else{
                        demoRef = mDatabase.child(mainData);
                        mainData = "";
                        demoRef.child("Result").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               finalData += dataSnapshot.getValue();
                               finalData += "\n";
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
