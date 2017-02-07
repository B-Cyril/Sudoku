package com.example.cyril.sudoku;

public class Case {

    private Integer x;
    private Integer y;
    private Integer numeroCase;
    private char valeur;

    public Case(Integer unX, Integer unY, Integer unNumeroCase, char uneValeur) {
        x = unX;
        y = unY;
        numeroCase = unNumeroCase;
        valeur = uneValeur;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    public Integer getNumeroCase() {
        return numeroCase;
    }

    public char getValeur() {
        return valeur;
    }

    public void setValeur(char nouvelleValeur) {
        valeur = nouvelleValeur;
    }
}
