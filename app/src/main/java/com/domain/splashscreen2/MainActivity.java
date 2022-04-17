package com.domain.splashscreen2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private int countItem = 1;
    int max;

    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            max = savedInstanceState.getInt("max");
        } else {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            max = sharedPreferences.getInt("count", 0);
            sharedPreferences.edit().putInt("count", max + countItem).apply(); //каждый раз, когда запускается активити - прибавляй к max единицу
            Toast.makeText(this, "Запуск №" + max, Toast.LENGTH_SHORT).show();
            if (max == 2) {
                Toast.makeText(this, "Холодный запуск №3", Toast.LENGTH_LONG).show();
            }


        }

        setTheme(R.style.Theme_SplashScreen2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

   @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putInt("max", max);

    }
}