package com.example.bibliothqueenligne;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class inscription2 extends AppCompatActivity {
    TextInputEditText inputEditTextfullname,inputEditTextusername,inputEditTextpassword,inputEditTextemail;
    Button valider;



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);

        inputEditTextfullname=findViewById(R.id.fullname);
        inputEditTextusername=findViewById(R.id.username);
        inputEditTextpassword=findViewById(R.id.password);
        inputEditTextemail=findViewById(R.id.email);
        valider=findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                String fullname,username,password,email;
                fullname=String.valueOf(inputEditTextfullname.getText()) ;
                username=String.valueOf(inputEditTextusername.getText());
                password=String.valueOf(inputEditTextpassword.getText());
                email=String.valueOf(inputEditTextemail.getText());

                if(!fullname.equals("") && !username.equals("") && !email.equals("") && !password.equals("")){





                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public  void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[4];
                        field[0] = "username";
                        field[1] = "password";
                        field[2] = "fullname";
                        field[3] = "email";
                        //Creating array for data
                        String[] data = new String[4];
                        data[0] = username;
                        data[1] = password;
                        data[2] = fullname;
                        data[3] = email;
                        PutData putData= new PutData("http://192.168.0.109/loginandroid/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if(result.equals("Sign Up Success")){
                                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(getApplicationContext(),connexion.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Veuillez remplir tous les champs svp", Toast.LENGTH_LONG).show();
                }

            }
        });




    }
}