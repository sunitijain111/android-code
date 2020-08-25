package com.example.edureka_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_push= (Button) findViewById(R.id.button);
        Button button_push2= (Button) findViewById(R.id.button2);
        button_push.setOnClickListener(this);
        button_push2.setOnClickListener(this);
       // onClickListener();
//        Button button_push= (Button) findViewById(R.id.button);
//        Button button_push2= (Button) findViewById(R.id.button2);
//
//        button_push.setOnClickListener(new View.OnClickListener() {
//                                           TextView tv= findViewById(R.id.textView);
//                                           @Override
//                                           public void onClick(View v) {
//                                               Log.d("tag", "onClick: button");
//                                               tv.setText("someone pushed it");
//                                           }//on click
//                                       }
//
//        );
//
//        button_push2.setOnClickListener(new View.OnClickListener() {
//                                            TextView tv= findViewById(R.id.textView);
//                                            @Override
//                                            public void onClick(View v) {
//                                                Log.d("tag", "onClick: button");
//                                                tv.setText("someone pushed other");
//                                            }//on click
//                                        }
//
//        );
    }
//better way
    @Override
    public void onClick(View v) {
        TextView tv= findViewById(R.id.textView);
        switch (v.getId())
        {
            case R.id.button:
                Log.d("tag", "onClick: button");
                                             tv.setText("someone pushed it");
                 break;
            case R.id.button2:
                Log.d("tag", "onClick: button");
                tv.setText("someone pushed other");

                break;
        }
    }
}