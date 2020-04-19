package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText n1;
EditText n2;
TextView tv;
Button ad,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1= (EditText) findViewById(R.id.editText);
        n2= (EditText) findViewById(R.id.editText2);
        tv= (TextView)findViewById(R.id.textView);
        ad= (Button) findViewById(R.id.button);
        sub= (Button) findViewById(R.id.button2);
        mul= (Button) findViewById(R.id.button3);
        div= (Button) findViewById(R.id.button4);

        //if button is clicked
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no1= Integer.parseInt(n1.getText().toString());
                Integer no2= Integer.parseInt(n2.getText().toString());

                Integer add= no1+no2;
                tv.setText("addition is "+add.toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no1= Integer.parseInt(n1.getText().toString());
                Integer no2= Integer.parseInt(n2.getText().toString());

                Integer subb= no1-no2;
                tv.setText("subtraction is "+subb.toString());
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no1= Integer.parseInt(n1.getText().toString());
                Integer no2= Integer.parseInt(n2.getText().toString());

                Integer mulp= no1*no2;
                tv.setText("multipliction is "+mulp.toString());
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no1= Integer.parseInt(n1.getText().toString());
                Integer no2= Integer.parseInt(n2.getText().toString());

                Integer divi= no1/no2;
                tv.setText("division is "+divi.toString());
            }
        });

    }
}
