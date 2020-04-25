package com.codermonkeys.appcompattextfield;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user;
    AppCompatEditText password;
    LinearLayout linearLayout;
    TextInputLayout inputLayout;
    TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username_TextField);
        password = findViewById(R.id.password_TextField);
        linearLayout = findViewById(R.id.activity_main);
        inputLayout = findViewById(R.id.username_TextInputLayout);
        passLayout = findViewById(R.id.password_TextInputLayout);

        linearLayout.setOnClickListener(null);

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(user.getText().toString().isEmpty()) {

                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("Username Required");
                } else {
                    inputLayout.setErrorEnabled(false);
                }
            }
        });

       user.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

               if(user.getText().toString().isEmpty()) {

                   inputLayout.setErrorEnabled(true);
                   inputLayout.setError("Username Required");
               } else {
                   inputLayout.setErrorEnabled(false);
               }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       passLayout.setCounterEnabled(true);
       passLayout.setCounterMaxLength(10);
    }
}
