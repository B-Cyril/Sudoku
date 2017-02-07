package com.example.cyril.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSudoku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sudoku);

        final MainSudoku context = this;
        context.setTitle("Menu principal");

        final Button butfacile = (Button) findViewById(R.id.ButtonNiveauFacile);
        final Button butmoyen = (Button) findViewById(R.id.ButtonNiveauMoyen);
        final Button butdifficile = (Button) findViewById(R.id.ButtonNiveauDifficile);

        butfacile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, ChoixGrille.class);
                intent.putExtra("passInfo", butfacile.getText().toString());
                startActivity(intent);
            }
        });

        butmoyen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, ChoixGrille.class);
                intent.putExtra("passInfo", butmoyen.getText().toString());
                startActivity(intent);
            }
        });

        butdifficile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, ChoixGrille.class);
                intent.putExtra("passInfo", butdifficile.getText().toString());
                startActivity(intent);
            }
        });
    }
}