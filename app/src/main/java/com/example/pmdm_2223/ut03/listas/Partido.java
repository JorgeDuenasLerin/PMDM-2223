package com.example.pmdm_2223.ut03.listas;

public class Partido {
    public String local;
    public String visitante;
    public String resultado;

    public static final int PARTIDOS_INICIALES = 10;

    public static Partido[] generateData(int i) {
        return new Partido[i];
    }
}
