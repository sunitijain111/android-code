package com.example.lab3b;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button one = (Button) findViewById(R.id.button1);
        Button two= (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four= (Button) findViewById(R.id.button4);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        TextView tv= findViewById(R.id.textView);
        switch(v.getId())
        {
            case R.id.button1:
                tv.setText("Button one pushed");
                tv.setTextColor(Color.parseColor("#A7226E"));
                break;

            case R.id.button2:
                tv.setText("button two pushed");
                tv.setTextColor(Color.parseColor("#EC2049"));
                break;
            case R.id.button3:
                tv.setText("Button three pushed");
                tv.setTextColor(Color.parseColor("#F7DB4F"));
                break;

            case R.id.button4:
                tv.setText("button four pushed");
                tv.setTextColor(Color.parseColor("#F26B38"));
                break;
        }
    }
}