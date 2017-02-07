package com.example.cyril.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChoixGrille extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ChoixGrille lecontext = this;
    String InfoPasse;

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        int itemPosition = position;
        Intent intent = new Intent(lecontext, Grille.class);

        // grille facile
        if ( position == 0 && InfoPasse.equals("Facile"))
        {
            intent.putExtra("passInfo", "001700509573024106800501002700295018009400305652800007465080071000159004908007053");
        }
        if ( position == 1 && InfoPasse.equals("Facile"))
        {
            intent.putExtra("passInfo", "029650178705180600100900500257800309600219005900007046573400021800020453010395000");
        }
        if ( position == 2 && InfoPasse.equals("Facile"))
        {
            intent.putExtra("passInfo", "008203500009670408346050702430010059967005001000496203280034067703500904004107020");
        }

        //grille moyen
        if ( position == 0 && InfoPasse.equals("Moyen"))
        {
            intent.putExtra("passInfo", "096040001100060004504810390007950043030080000405023018010630059059070830003590007");
        }
        if ( position == 1 && InfoPasse.equals("Moyen"))
        {
            intent.putExtra("passInfo", "105802000090076405200400819019007306762083090000061050007600030430020501600308900");
        }
        if ( position == 2 && InfoPasse.equals("Moyen"))
        {
            intent.putExtra("passInfo", "005030081902850060600004050007402830349760005008300490150087002090000600026049503");
        }
        if ( position == 3 && InfoPasse.equals("Moyen"))
        {
            intent.putExtra("passInfo", "340910020096080041008020070060057039102060700970030064450208006080090050603001890");
        }

        //grille difficile
        if ( position == 0 && InfoPasse.equals("Difficile"))
        {
            intent.putExtra("passInfo", "290500007700000400004738012902003064800050070500067200309004005000080700087005109");
        }
        if ( position == 1 && InfoPasse.equals("Difficile"))
        {
            intent.putExtra("passInfo", "080020000040500320020309046600090004000640501134050700360004002407230600000700450");
        }
        if ( position == 2 && InfoPasse.equals("Difficile"))
        {
            intent.putExtra("passInfo", "608730000200000460000064820080005701900618004031000080860200039050000100100456200");
        }
        if ( position == 3 && InfoPasse.equals("Difficile"))
        {
            intent.putExtra("passInfo", "902040560000009000061250470040030102600480090003070080500008000306500947100360005");
        }
        if ( position == 4 && InfoPasse.equals("Difficile"))
        {
            intent.putExtra("passInfo", "020001630090500400806049002900005701000900300352076800009004506080050000045600018");
        }

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_grille);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ChoixGrille lecontext = this;
        lecontext.setTitle("Sudoku");

        Bundle objetbunble = this.getIntent().getExtras();
        InfoPasse= objetbunble.getString("passInfo");
        final TextView getNiveau = (TextView) findViewById(R.id.niveauChoisi);
        getNiveau.setText("Grilles " + InfoPasse +"s");

        if ( InfoPasse.equals("Facile"))
        {
            ListView liste = (ListView) findViewById(R.id.maliste);
            String[] values = new String[] { "Niveau 1", "Niveau 2", "Niveau 3" };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,android.R.id.text1,values);
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(this);
        }
        else if ( InfoPasse.equals("Moyen"))
        {
            ListView liste = (ListView) findViewById(R.id.maliste);
            String[] values = new String[] { "Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4" };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,android.R.id.text1,values);
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(this);
        }
        else if ( InfoPasse.equals("Difficile"))
        {
            ListView liste = (ListView) findViewById(R.id.maliste);
            String[] values = new String[] { "Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4", "Niveau 5" };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,android.R.id.text1,values);
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(this);
        }
    }

}
