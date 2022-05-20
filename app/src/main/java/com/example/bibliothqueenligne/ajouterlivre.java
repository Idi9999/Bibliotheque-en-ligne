package com.example.bibliothqueenligne;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class ajouterlivre extends AppCompatActivity {
    TextInputEditText textInputEditTexttitre,textInputEditTextresume;
    Button ajouter;



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterlivre);

        textInputEditTexttitre=findViewById(R.id.titre);
        textInputEditTextresume=findViewById(R.id.Resumé);
        ajouter=findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                String resume,titre;
                resume=String.valueOf(textInputEditTextresume.getText()) ;
                titre=String.valueOf(textInputEditTexttitre.getText());


                if(!titre.equals("") && !resume.equals("") ){

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public  void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "titre";
                            field[1] = "resume";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = titre;
                            data[1] =resume;

                            PutData putData= new PutData("http://192.168.0.109/loginandroid/ajouterlivre.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Ajout")){
                                        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                                        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
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