package com.example.tunisiebooking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.NumberPicker;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.tunisiebooking.R;
public class Price extends AppCompatActivity   {

    private int prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        prix = intent.getIntExtra("prix", 0);
        NumberPicker numberPicker = findViewById(R.id.numberPicker1);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Faire quelque chose lorsque la valeur du NumberPicker est changée
            }
        });

        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer la valeur de NumberPicker
                NumberPicker numberPicker = findViewById(R.id.numberPicker1);
                int number = numberPicker.getValue();

                // Calculer le prix total
                int prixTotal = prix * number;

                // Afficher le résultat dans l'EditText
                EditText affichagePrix = findViewById(R.id.affichage_prix);
                affichagePrix.setText(String.valueOf(prixTotal));
            }
        });
    }
}


