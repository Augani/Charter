package com.ganyobicodes.charter;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ganyobicodes.charter.Constants.ProjectsConstant;
import com.hbb20.CountryCodePicker;

public class Home extends AppCompatActivity {
    TextInputEditText phoneNumber;
    CountryCodePicker countryCodePicker;
    Button sendcode;
    ProjectsConstant constant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sendcode = findViewById(R.id.sendCode);
        constant = new ProjectsConstant();
        countryCodePicker = findViewById(R.id.ccp);
        phoneNumber = findViewById(R.id.phoneNumber);
        countryCodePicker.registerCarrierNumberEditText(phoneNumber);
        sendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countryCodePicker.isValidFullNumber()){
                    Intent intent = new Intent(getBaseContext(), VerifyPhone.class);
                    intent.putExtra(constant.USER_PHONENUMBER, countryCodePicker.getFormattedFullNumber());
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_slide_out_left, R.anim.anim_slide_in_left);
                }
            }
        });


    }
}
