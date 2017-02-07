package com.example.cyril.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

public class DessinGrille extends View implements View.OnTouchListener {

    LinkedList<Case> cases = new LinkedList<Case>();
    int chiffreStocke = 0;
    int positionGlobaleX = 0;
    int positionGlobaleY = 0;
    String infoPasse;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //récupération de la position du doigt et passage en variables globales
        int x = (int)event.getX();
        int y = (int)event.getY();
        positionGlobaleX = x;
        positionGlobaleY = y;


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //récupération du chiffre qui sert à remplir la grille
                int position1 = 50;
                int position2 = 150;

                for(int i=1; i<=9; i++) {
                    if (x > position1 && x < position2 && y > 1050 && y < 1150) {
                        chiffreStocke = i;
                    }
                    position1 = position1 + 100;
                    position2 = position2 + 100;
                }

                //fonctions pour gommer
                if (positionGlobaleX > (50) && positionGlobaleX < (950) && positionGlobaleY > (1250) && positionGlobaleY < (1450)){

                    chiffreStocke = 0;
                }
                if (positionGlobaleX > (50) && positionGlobaleX < (950) && positionGlobaleY > (50) && positionGlobaleY < (950)){
                    String valeur = String.valueOf(chiffreStocke);
                    char[] valeurChar;
                    valeurChar = valeur.toCharArray();
                    cases.get(9*((positionGlobaleY-50)/100)+((positionGlobaleX-50)/100)).setValeur(valeurChar[0]);
                }

                break;
        }
        this.invalidate();
        return true;
    }

    public DessinGrille(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setOnTouchListener(this);

    }
    @Override
    public void onDraw(Canvas canvas){
        Paint monPaint = new Paint();
        monPaint.setColor(Color.BLACK);

        //lignes
        monPaint.setStrokeWidth(5);
        canvas.drawLine(50, 50, 950, 50, monPaint);
        canvas.drawLine(50, 150, 950, 150, monPaint);
        canvas.drawLine(50, 250, 950, 250, monPaint);
        monPaint.setStrokeWidth(10);
        canvas.drawLine(50, 350, 950, 350, monPaint);
        monPaint.setStrokeWidth(5);
        canvas.drawLine(50, 450, 950, 450, monPaint);
        canvas.drawLine(50, 550, 950, 550, monPaint);
        monPaint.setStrokeWidth(10);
        canvas.drawLine(50, 650, 950, 650, monPaint);
        monPaint.setStrokeWidth(5);
        canvas.drawLine(50, 750, 950, 750, monPaint);
        canvas.drawLine(50, 850, 950, 850, monPaint);
        canvas.drawLine(50, 950, 950, 950, monPaint);

        //colonnes
        canvas.drawLine(50, 50, 50, 950, monPaint);
        canvas.drawLine(150, 50, 150, 950, monPaint);
        canvas.drawLine(250, 50, 250, 950, monPaint);
        monPaint.setStrokeWidth(10);
        canvas.drawLine(350, 50, 350, 950, monPaint);
        monPaint.setStrokeWidth(5);
        canvas.drawLine(450, 50, 450, 950, monPaint);
        canvas.drawLine(550, 50, 550, 950, monPaint);
        monPaint.setStrokeWidth(10);
        canvas.drawLine(650, 50, 650, 950, monPaint);
        monPaint.setStrokeWidth(5);
        canvas.drawLine(750, 50, 750, 950, monPaint);
        canvas.drawLine(850, 50, 850, 950, monPaint);
        canvas.drawLine(950, 50, 950, 950, monPaint);

        monPaint.setTextSize(60);

        //récupération de la chaîne qui construit le niveau
        String chaine = infoPasse;
        char chiffre;
        int positionX = 85;
        int positionY = 120;

        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++) {
                int cpt;
                cpt = 9*i + j;
                chiffre = (char)chaine.charAt(cpt);

                //Ne dessine pas les 0
                if (chaine.charAt(cpt)!='0' ) {
                    canvas.drawText(chiffre + "", positionX, positionY, monPaint);
                }

                //Ajout des informations dans la classe Case
                cases.add(new Case(positionX, positionY, cpt, chiffre));

                //Vérifie la classe Case et dessine en bleu les nouveaux chiffres ajoutés
                if (chaine.charAt(cpt)=='0' && cases.get(cpt).getValeur()!='0' )
                {
                    monPaint.setColor(Color.BLUE);
                    canvas.drawText(cases.get(cpt).getValeur() + "", positionX, positionY, monPaint);
                    monPaint.setColor(Color.BLACK);
                }
                positionX = positionX + 100;
            }
            positionY = positionY + 100;
            positionX = 85;
        }

        //chiffres pour remplir la grille

        //lignes
        canvas.drawLine(50, 1050, 950, 1050, monPaint);
        canvas.drawLine(50, 1150, 950, 1150, monPaint);

        //colonne +  dessin 1,2,3,4,5,6,7,8,9
        int boutonRemplir = 50;
        positionX = 85;
        positionY = 1120;
        for(int i=1; i<=10; i++){
            canvas.drawLine(boutonRemplir, 1150, boutonRemplir, 1050, monPaint);
            boutonRemplir = boutonRemplir + 100;
            canvas.drawText(i + "", positionX, positionY, monPaint);
            positionX = positionX +100;
        }
        canvas.drawText("1", positionX, positionY, monPaint);

        //récuperation de la position des cases et création
        // des chiffres si la classe case contient des valeurs autre que 0
        for(int i=0; i<=80; i++) {

                int X = cases.get(i).getX();
                int Y = cases.get(i).getY();

                if (chiffreStocke != 0 && positionGlobaleX > (X-35) && positionGlobaleX < (X+65) && positionGlobaleY > (Y-70) && positionGlobaleY < (Y+30) && cases.get(i).getValeur()=='0')
                {
                    canvas.drawText(chiffreStocke + "", X, Y, monPaint);

                    String valeur = String.valueOf(chiffreStocke);
                    char[] valeurChar;
                    valeurChar = valeur.toCharArray();
                    cases.get(i).setValeur(valeurChar[0]);
                }
        }

        //bouton gomme

        //ligne
        canvas.drawLine(50, 1250, 950, 1250, monPaint);
        canvas.drawLine(50, 1450, 950, 1450, monPaint);

        //colonne
        canvas.drawLine(50, 1250, 50, 1450, monPaint);
        canvas.drawLine(950, 1250, 950, 1450, monPaint);

        canvas.drawText("GOMME", 380, 1370, monPaint);
    }

    public void setInfoPasse( String uneInfoPasse){
        infoPasse = uneInfoPasse;
    }
}