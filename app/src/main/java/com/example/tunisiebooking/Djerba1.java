package com.example.tunisiebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tunisiebooking.R;
public class Djerba1 extends AppCompatActivity{
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText number;
    TextView prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hammamet);
        init();
        prix_total();

    }
    private void init()
    {
        textview1=(TextView) findViewById(R.id.hotel1);
        textview2=(TextView) findViewById(R.id.hotel2);
        textview3=(TextView) findViewById(R.id.hotel3);
        textview4=(TextView) findViewById(R.id.hotel4);
        button1=(Button)  findViewById(R.id.btnSignIn1);
        button2=(Button)  findViewById(R.id.btnSignIn2);

        button3=(Button)  findViewById(R.id.btnSignIn3);

        button4=(Button)  findViewById(R.id.btnSignIn4);
        number=(EditText) findViewById(R.id.number1);
        prix=(TextView) findViewById(R.id.total);
    }

    private void prix_total() {
        final double[] total_prix = new double[1];
        //listener pour le bouton 1
        button1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Double dinar = null;
                int entier = 0;
                try {
                    dinar = Double.parseDouble(textview1.getText().toString());
                    String text = number.getText().toString(); // récupérer le texte entré par l'utilisateur
                    entier = Integer.parseInt(text);
                } catch (Exception e) {
                } // Pour ne pas se planter
                if(dinar==0 || entier==0)
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.toastText), Toast.LENGTH_SHORT).show();
                else
                    total_prix[0] = (double) dinar * entier;
            }});
        //listener pour le bouton2
        button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Double dinar = null;
                int entier = 0;
                try {
                    dinar = Double.parseDouble(textview2.getText().toString());
                    String text = number.getText().toString(); // récupérer le texte entré par l'utilisateur
                    entier = Integer.parseInt(text);
                } catch (Exception e) {
                } // Pour ne pas se planter
                if(dinar==0 || entier==0)
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.toastText), Toast.LENGTH_SHORT).show();
                else
                    total_prix[0] = (double) dinar * entier;
            }});
        //listener pour le bouton3
        button3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Double dinar = null;
                int entier = 0;
                try {
                    dinar = Double.parseDouble(textview3.getText().toString());
                    String text = number.getText().toString(); // récupérer le texte entré par l'utilisateur
                    entier = Integer.parseInt(text);
                } catch (Exception e) {
                } // Pour ne pas se planter
                if(dinar==0 || entier==0)
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.toastText), Toast.LENGTH_SHORT).show();
                else
                    total_prix[0] = (double) dinar * entier;
            }});
        //listener pour le bouton 4
        button4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Double dinar = null;
                int entier = 0;
                try {
                    dinar = Double.parseDouble(textview4.getText().toString());
                    String text = number.getText().toString(); // récupérer le texte entré par l'utilisateur
                    entier = Integer.parseInt(text);
                } catch (Exception e) {
                } // Pour ne pas se planter
                if(dinar==0 || entier==0)
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.toastText), Toast.LENGTH_SHORT).show();
                else
                    total_prix[0] = (double) dinar * entier;
            }});

        prix.setText(Double.toString(total_prix[0]));

    }

}

