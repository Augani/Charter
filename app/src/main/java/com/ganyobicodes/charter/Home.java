package com.ganyobicodes.charter;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.hbb20.CountryCodePicker;

public class Home extends AppCompatActivity {
    TextInputEditText phoneNumber;
    CountryCodePicker countryCodePicker;
    Button sendcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sendcode = findViewById(R.id.sendCode);
        countryCodePicker = findViewById(R.id.ccp);
        phoneNumber = findViewById(R.id.phoneNumber);
        countryCodePicker.registerCarrierNumberEditText(phoneNumber);


    }
}
