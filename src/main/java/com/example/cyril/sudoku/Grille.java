package com.example.cyril.sudoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Grille extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille);

        Bundle objetbunble = this.getIntent().getExtras();
        String InfoPasse= objetbunble.getString("passInfo");

        DessinGrille dessinGrille = (DessinGrille) findViewById(R.id.dessin);
        dessinGrille.setInfoPasse(InfoPasse);
    }
}