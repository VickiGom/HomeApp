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

public class HumedadActivity extends AppCompatActivity {
    private TextView TexHumedad;
    private DatabaseReference mDataBase;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humedad);
        ConstraintLayout layout = findViewById(R.id.humedadLy);
        btnSalir = (Button) findViewById(R.id.btnSalir2);
        AnimationDrawable animacion = (AnimationDrawable) layout.getBackground();
        animacion.setEnterFadeDuration(10);
        animacion.setExitFadeDuration(1000);
        animacion.start();
        TexHumedad = (TextView) findViewById(R.id.TexHumedad);
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("humedad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String temp = snapshot.child("August-09-2022-14-00").getValue().toString();
                    TexHumedad.setText("Humedad: "+ temp);
                }else{
                    Toast.makeText(HumedadActivity.this, "No existe el dato", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HumedadActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}