package com.example.tunisiebooking;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.example.tunisiebooking.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        getSupportActionBar().hide();
        mySpinner = findViewById(R.id.mySpinner);
        btnsearch = findViewById(R.id.btnsearch);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nothing to do here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do here
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCity = mySpinner.getSelectedItem().toString();
                Intent intent;

                switch (selectedCity) {
                    case "Hammamet":
                        Toast.makeText(AccueilActivity.this, "Vous avez sélectionné : " + selectedCity, Toast.LENGTH_SHORT).show();
                        intent = new Intent(AccueilActivity.this, Hammamet.class);
                        startActivity(intent);
                        break;
                    case "Sousse":
                        Toast.makeText(AccueilActivity.this, "Vous avez sélectionné : " + selectedCity, Toast.LENGTH_SHORT).show();
                        intent = new Intent(AccueilActivity.this, Sousse.class);
                        startActivity(intent);
                        break;
                    case "Kerkennah":
                        Toast.makeText(AccueilActivity.this, "Vous avez sélectionné : " + selectedCity, Toast.LENGTH_SHORT).show();
                        intent = new Intent(AccueilActivity.this, Kerkennah.class);
                        startActivity(intent);
                        break;
                    case "Sfax":
                        Toast.makeText(AccueilActivity.this, "Vous avez sélectionné : " + selectedCity, Toast.LENGTH_SHORT).show();
                        intent = new Intent(AccueilActivity.this, Sfax.class);
                        startActivity(intent);
                        break;
                    case "Djerba":
                        Toast.makeText(AccueilActivity.this, "Vous avez sélectionné : " + selectedCity, Toast.LENGTH_SHORT).show();
                        intent = new Intent(AccueilActivity.this, Djerba1.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Veuillez sélectionner une ville", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}









