package com.example.tunisiebooking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
        numberPicker.setMinValue(1);
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
                calcule();
            }
        });
    }
    public void calcule()
    {
        NumberPicker numberPicker = findViewById(R.id.numberPicker1);
        int number = numberPicker.getValue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Create a socket connection to the server
                    Socket socket = new Socket("10.0.2.15", 8080);
                    // Send the login credentials to the server
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println(number);
                    pw.println(prix);

                    // Get the response from the server
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    final String prix_finale = in.readLine();


                    // Close the socket connection
                    socket.close();

                    // Update the UI on the main thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView affichage =(TextView) findViewById(R.id.affichage_prix);
                            affichage.setText(prix_finale);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}


