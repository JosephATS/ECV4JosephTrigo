package com.joseph.ecv4josephtrigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.joseph.ecv4josephtrigo.databinding.ActivityPrincipalBinding;
import com.joseph.ecv4josephtrigo.fragment.HomeFragment;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.donca);

        addHomeFragment();


    }

    private void addHomeFragment(){
        getSupportFragmentManager().beginTransaction().add(binding.fcvMain.getId(), new HomeFragment()).commit();

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.donca_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            // Mostrar cuadro de diálogo de confirmación
            new AlertDialog.Builder(this)
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Deseas Salir?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sharedPreferences.edit().clear().apply();
                            Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();

            return true;
        }
        return false;
    }
}