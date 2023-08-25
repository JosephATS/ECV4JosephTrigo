package com.joseph.ecv4josephtrigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.joseph.ecv4josephtrigo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;
    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";

    public static String SESSION_ACTIVATED = "SESSION_ACTIVATED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);
        boolean isSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED,false);
        if(isSessionActivated){
            Intent intent = new Intent(this , PrincipalActivity.class);
            startActivity(intent);
            finish();
        }
        binding.botonLogin.setOnClickListener(v -> {

            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();

            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED,true).apply();
            if (email.equals("ejemploe@idat.com.pe") && password.equals("Peru123.")) {
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            } else {
                //No se podra iniciar sesión
            }

        });




        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString();
                String password = binding.password.getEditText().getText().toString();
                boolean isOK = email.equals("ejemploe@idat.com.pe") && password.equals("Peru123.");
                binding.botonLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = binding.tilEmail.getEditText().getText().toString();
                String password = s.toString();
                boolean isOK = email.equals("ejemploe@idat.com.pe") && password.equals("Peru123.");
                binding.botonLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}