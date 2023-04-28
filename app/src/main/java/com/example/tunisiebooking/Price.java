package com.example.tunisiebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.tunisiebooking.R;
public class Price extends AppCompatActivity {
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        init();
    }
    void init()
    {
        total=(TextView) findViewById(R.id.total);
    }
}