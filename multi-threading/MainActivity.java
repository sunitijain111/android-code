package com.example.lab5;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_query, edit_query_2;
    TextView textView;
    TextView text1;
    boolean twice = false;
    Thread t = null;
    Integer a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_query = findViewById(R.id.edit_query);
        edit_query_2 = findViewById(R.id.edit_query_2);



        textView = findViewById(R.id.text);
        text1 = findViewById(R.id.text1);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runthread();
                runthread1();
            }
        });
    }

    private void runthread1() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                a = Integer.parseInt(edit_query.getText().toString().trim());
                b= Integer.parseInt(edit_query_2.getText().toString().trim());
                Integer c= a+b;
                String str1 = Integer.toString(c);
                text1.setText("Thread 1 : sum is : "+str1);
            }
        });
    }

    private void runthread() {
        twice = true;
        if (twice) {

            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            a = Integer.parseInt(edit_query.getText().toString().trim());
                            b= Integer.parseInt(edit_query_2.getText().toString().trim());
                            Integer c= a-b;
                            String str1 = Integer.toString(c);
                            textView.setText("Thread 2 : difference is : "+str1);
                            twice = false;
                        }
                    });
                }
            });
            t.start();
            t.setName("Suniti");
            t.setPriority(Thread.MAX_PRIORITY);
        }
    }
}