package com.example.bibliothqueenligne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class connexion1 extends AppCompatActivity {
    TextInputEditText inputEditTextusername,inputEditTextpassword;
    Button valider;
    //Intent intent= getIntent();
    //String nom=intent.getStringExtra("nom");
    //int choix= intent.getIntExtra("choix",0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion2);

        inputEditTextusername=findViewById(R.id.username);
        inputEditTextpassword=findViewById(R.id.password);
        valider=findViewById(R.id.valider);
        Button clique=findViewById(R.id.clique);
        clique.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),inscription2.class);
                startActivity(intent);

            }}
        );

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                String username,password;

                username=String.valueOf(inputEditTextusername.getText());
                password=String.valueOf(inputEditTextpassword.getText());


                if(!username.equals("") &&  !password.equals("")){

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public  void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData= new PutData("http://192.168.0.109/loginandroid/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        //if(choix==1){
                                        Intent intent= new Intent(getApplicationContext(),choixprof.class);
                                        startActivity(intent);
                                        finish();
                                        //}else if(choix==2){
                                        //  Intent intent= new Intent(getApplicationContext(),choixetudiant.class);
                                        //startActivity(intent);
                                        //finish();
                                        //}

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