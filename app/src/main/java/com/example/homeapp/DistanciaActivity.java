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

public class DistanciaActivity extends AppCompatActivity {
    private TextView TexDistancia;
    private DatabaseReference mDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancia);
        TexDistancia = (TextView) findViewById(R.id.TexDistancia);
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("distancia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String temp = snapshot.child("August-09-2022-14-00").getValue().toString();
                    TexDistancia.setText("Distancia: "+ temp);
                }else{
                    Toast.makeText(DistanciaActivity.this, "No existe el dato", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}