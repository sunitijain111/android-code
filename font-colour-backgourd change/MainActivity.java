  package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.lab2.R.id.changebkcolor;
import static com.example.lab2.R.id.changecolor;
import static com.example.lab2.R.id.changefont;

  public class MainActivity extends AppCompatActivity {
    private TextView texta;
    private int i, j,z;
    private String[] mycolours={"#006400","#134234","#873434","#879324","#987243"};
    private Typeface[] fonts={ Typeface.MONOSPACE, Typeface.SERIF};
//Typeface[] fonts={not woking Typeface.SANS_SERIF,workingTypeface.SERIF,Typeface.MONOSPACE};
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        i=0; j=0; z=0;

          addListenerOnButton();
      }

      private void addListenerOnButton() {

          final Button button = findViewById(changecolor);

          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Log.d("tag", "clicked 1");
                  texta = (TextView)findViewById(R.id.contentview);

                  i= i+1;
                    i= i%mycolours.length;
                  texta.setTextColor(Color.parseColor(mycolours[i]));


              }
          }); //buttoon 1


          final Button button2 = findViewById(changebkcolor);

          button2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Log.d("tag", "clicked 2");
                  texta = (TextView)findViewById(R.id.contentview);


                   j= j+1;
                  j= j%mycolours.length;
                  texta.setBackgroundColor(Color.parseColor(mycolours[j]));


              }
          }); //button 2
          final Button button3 = findViewById(changefont);

          button3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Log.d("tag", "clicked 3");
                  texta = (TextView)findViewById(R.id.contentview);

                   z= z+1;
                   z= z%3;
                   if(z==0)
                       texta.setTypeface(Typeface.SERIF);
                  else if(z==1)
                      texta.setTypeface(Typeface.MONOSPACE);
                    else
                        texta.setTypeface(Typeface.DEFAULT);

              }
          }); //button 2
          };


      }


