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

public class retirerreservation extends AppCompatActivity {
    TextInputEditText textInputEditTextnumero,textInputEditTexttitrelivre;
    Button ajouter;



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterreservation);

        textInputEditTextnumero=findViewById(R.id.numero);
        textInputEditTexttitrelivre=findViewById(R.id.titrelivre);

        ajouter=findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                String numero,titrelivre,nom,prenom,date,dateretour;
                numero=String.valueOf(textInputEditTextnumero.getText()) ;
                titrelivre=String.valueOf(textInputEditTexttitrelivre.getText());


                if(!numero.equals("") && !titrelivre.equals("")){





                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public  void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "numero";
                            field[1] = "titrelivre";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = numero;
                            data[1] =titrelivre;

                            PutData putData= new PutData("http://192.168.0.109/loginandroid/retirerreservation.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Suppression réussi")){
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