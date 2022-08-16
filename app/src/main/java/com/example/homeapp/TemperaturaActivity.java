package com.example.homeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        TexTempera = (TextView) findViewById(R.id.TexTempera);
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("temperatura").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String temp = snapshot.child("August-09-2022-14-00").getValue().toString();
                    TexTempera.setText("Temperatura: "+ temp);
                }else{
                    Toast.makeText(TemperaturaActivity.this, "No existe el dato", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}