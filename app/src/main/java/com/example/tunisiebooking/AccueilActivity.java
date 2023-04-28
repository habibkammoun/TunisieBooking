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
public class AccueilActivity extends AppCompatActivity  {
       Spinner mySpinner;//pour selectionner votre destination
    CalendarView calendarView ;
    //variable pour initialiser le nombre de personnes
    int count = 0;
    TextView countText;
    Button incrementButton;
    Button decrementButton;
    EditText number;
    ArrayAdapter<CharSequence> adapter;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        init();

    }
    private void init(){
        mySpinner = findViewById(R.id.mySpinner);//initialisation du spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);
        //la date
        calendarView = findViewById(R.id.calendarView);
        number =(EditText) findViewById(R.id.number1);
        searchButton = findViewById(R.id.btnsearch); //Ajout de cette ligne

        signIn(); //Ajout de cette ligne


    }

    // Méthode pour mettre à jour l'affichage de la variable count
    private void updateCount() {
        countText.setText(String.valueOf(count));
    }
    //donner les resultats de recherche
    private void signIn() {
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                        // Gérer la date sélectionnée par l'utilisateur
                    }
                });
                // définir la date de départ du calendrier à afficher
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, 2021);
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                long minDate = calendar.getTimeInMillis();
                calendarView.setMinDate(minDate);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mySpinner.setAdapter(adapter);
                //condition pour verifier les données
                if ("Hammamet".equals(mySpinner)) {
                    Intent intent1 = new Intent(AccueilActivity.this, Hammamet.class);
                    startActivity(intent1);
                } else if ("Sousse".equals(mySpinner)) {
                    Intent intent2 = new Intent(AccueilActivity.this, Sousse.class);
                    startActivity(intent2);
                } else if ("Djerba".equals(mySpinner)) {
                    Intent intent3 = new Intent(AccueilActivity.this, Djerba1.class);
                    startActivity(intent3);
                } else if ("Sfax".equals(mySpinner)) {
                    Intent intent4 = new Intent(AccueilActivity.this, Sfax.class);
                    startActivity(intent4);
                } else if ("Kerkennah".equals(mySpinner)) {
                    Intent intent5 = new Intent(AccueilActivity.this, Kerkennah.class);
                    startActivity(intent5);
                } else {
                    throw new IllegalStateException("Unexpected value: " + mySpinner);
                }
            }
        });


    }


}







