package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText text;
    TextView encrypted, decrypted, secretkey;
    Button   push , secretkeypushme ;
    symmetric magic;
    int state= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.enter);
        push = findViewById(R.id.push);
        encrypted= findViewById(R.id.encrypted);
        decrypted= findViewById(R.id.decrypted);
        secretkey = findViewById(R.id.secretkey);
        secretkeypushme= findViewById(R.id.secretkeypushme);


        push.setOnClickListener(this);
        secretkeypushme.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId()== R.id.push)
        {
            String to_convert= text.getText().toString().trim();
            try {
                magic =new symmetric();
                magic.setText(to_convert);
                //sent for conersion

                //calling encyption && decryption
               try {
                   String encypted_Msg = magic.encrypt();
                   try{
                   String decrypted_Msg = magic.decrypt();

                   encrypted.setText(encypted_Msg);
                   decrypted.setText(decrypted_Msg);}
                   catch( Exception e)
                   {
                       Toast.makeText(MainActivity.this, "couldn't decrypt ", Toast.LENGTH_SHORT).show();
                   }
               }
               catch (Exception e)
               {
                   Toast.makeText(MainActivity.this, "couldn't encrypt ", Toast.LENGTH_SHORT).show();
               }


            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "couldn't make class instance", Toast.LENGTH_SHORT).show();
            }

        }
        else if(v.getId()== R.id.secretkeypushme)
        {
            if(state ==0)
            {String key = magic.get_key();
            secretkey.setText(key);
            state =1;
            secretkeypushme.setText("push me to hide the key");
            }
            else
            {
                state= 0;
                secretkey.setText("");
                secretkeypushme.setText(" push me to see secret key! shhh!!!! ");
            }
        }
    }

}