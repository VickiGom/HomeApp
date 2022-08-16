package com.example.homeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnHumedad;
    private Button btnTemperatura;
    private Button btnDistancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHumedad = (Button) findViewById(R.id.btnHumedad);
        btnTemperatura = (Button) findViewById(R.id.btnTemperatura);
        btnDistancia = (Button) findViewById(R.id.btnDistancia);


        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TemperaturaActivity.class);
                startActivity(intent);
            }
        });
        btnHumedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HumedadActivity.class);
                startActivity(intent);
            }
        });
        btnDistancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DistanciaActivity.class);
                startActivity(intent);
            }
        });

    }
}