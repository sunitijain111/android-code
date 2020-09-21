 package com.example.firebase_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

 public class registration extends AppCompatActivity {

    private EditText email, pass;private TextView signin; private Button btnreg;

private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();

        email= findViewById(R.id.email_reg);
        pass= findViewById(R.id.password_reg);
        btnreg= findViewById(R.id.btn_reg);
        signin= findViewById(R.id.signin_text);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail= email.getText().toString().trim();
                String mPass= pass.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail))
                {
                    email.setError("Required field");
                    return ;
                }

                if(TextUtils.isEmpty(mPass))
                {
                    pass.setError("Required field");
                    return ;
                }

                mAuth.createUserWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            startActivity(new Intent( getApplicationContext(), HomeActivity.class));
                            Toast.makeText(getApplicationContext(), "Succesful ",Toast.LENGTH_LONG).show();
                        }
                        else
                        { Toast.makeText(getApplicationContext(), " fail ",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

         signin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext() , MainActivity.class));
             }
         });
    }
}