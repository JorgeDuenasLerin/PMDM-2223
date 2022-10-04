package com.example.pmdm_2223.ut01;

public class Contador {
    int count;

    public Contador(){
        count = 0;
    }

    public void add(){
        count++;
    }

    public void reset(){
        count = 0;
    }

    public void resta(Contador c){
        count = count - c.count;
    }

    public String getCounter(){
        return "" + count;
    }
}
