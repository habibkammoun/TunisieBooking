package com.example.tunisiebooking;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import com.example.tunisiebooking.R;
public class Djerba1 extends AppCompatActivity implements View.OnClickListener {
    List<TextView> hotelprix = new ArrayList<>();
    List<Button> hotelButton = new ArrayList<>();
    public void init()
    {
        hotelprix.add(findViewById(R.id.hotel1));
        hotelprix.add(findViewById(R.id.hotel2));
        hotelprix.add(findViewById(R.id.hotel3));
        hotelprix.add(findViewById(R.id.hotel4));
        hotelButton.add(findViewById(R.id.btnSignIn1));
        hotelButton.add(findViewById(R.id.btnSignIn2));
        hotelButton.add(findViewById(R.id.btnSignIn3));
        hotelButton.add(findViewById(R.id.btnSignIn4));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_djerba1);
        getSupportActionBar().hide();
        init();
        ecouteClick();
    }
    private void navigateToActivity(int prixHotel){
        Intent intent = new Intent(Djerba1.this,Price.class);
        intent.putExtra("prix",prixHotel);
        startActivity(intent);
        //finish();
    }
    private void ecouteClick(){
        for (Button button : hotelButton)
            button.setOnClickListener((View.OnClickListener)this);
    }

    // Gestion des clics sur les ImageView
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnSignIn1 :
                navigateToActivity(Integer.parseInt(hotelprix.get(0).getText().toString()));
                break;
            case R.id.btnSignIn2 :
                navigateToActivity(Integer.parseInt(hotelprix.get(1).getText().toString()));
                break;
            case R.id.btnSignIn3 :
                navigateToActivity(Integer.parseInt(hotelprix.get(2).getText().toString()));
                break;
            case R.id.btnSignIn4 :
                navigateToActivity(Integer.parseInt(hotelprix.get(3).getText().toString()));
                break;
        }
    }
}

