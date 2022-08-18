package com.example.homeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TemperaturaActivity extends AppCompatActivity {
    private TextView TexTempera;
    private DatabaseReference mDataBase;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        btnSalir = (Button) findViewById(R.id.btnSalir3);
        ConstraintLayout layout = findViewById(R.id.temLy);
        AnimationDrawable animacion = (AnimationDrawable) layout.getBackground();
        animacion.setEnterFadeDuration(10);
        animacion.setExitFadeDuration(1000);
        animacion.start();
        TexTempera = (TextView) findViewById(R.id.TexTempera);
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("temperatura").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String temp = snapshot.child("August-09-2022-14-00").getValue().toString();
                    TexTempera.setText("Temperatura: "+ temp+ " ºC");
                }else{
                    Toast.makeText(TemperaturaActivity.this, "No existe el dato", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TemperaturaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}