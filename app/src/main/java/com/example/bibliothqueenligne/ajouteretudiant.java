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

public class ajouteretudiant extends AppCompatActivity {
    TextInputEditText textInputEditTextnom,textInputEditTextprenom,textInputEditTextid,textInputEditTextclasse;
    Button ajouter;



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouteretudiant);

        textInputEditTextclasse=findViewById(R.id.nom);
        textInputEditTextid=findViewById(R.id.prenom);
        textInputEditTextnom=findViewById(R.id.id);
        textInputEditTextprenom=findViewById(R.id.classe);

        ajouter=findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                String classe,id,nom,prenom,date;
                classe=String.valueOf(textInputEditTextclasse.getText()) ;
                id=String.valueOf(textInputEditTextid.getText());
                nom=String.valueOf(textInputEditTextnom.getText());
                prenom=String.valueOf(textInputEditTextprenom.getText());


                if(!classe.equals("") && !id.equals("") && !nom.equals("") && !prenom.equals("") ){





                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public  void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "nom";
                            field[1] = "prenom";
                            field[2] = "id";
                            field[3] = "classe";

                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = nom;
                            data[1] =prenom;
                            data[2] = id;
                            data[3] = classe;

                            PutData putData= new PutData("http://192.168.0.109/loginandroid/ajouteretudiant.php", "POST", field, data);
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