package com.example.pmdm_2223.ut04.mvvm.sencillo;

public class RandomModel {
    private static final double MAX_DELAY = 1000;
    private static final double MAX_RAND = 100;
    private int random;

    public RandomModel() {
        random = 0;
    }

    public void newRandom() {
        RandomModel.performAction();
        random = (int) (Math.random()*MAX_RAND);
    }

    public int getLastRandom(){
        RandomModel.performAction();
        return random;
    }

    /***
     * Simula una tarea que lleva tiempo
     */
    private static void performAction(){
        try {
            Thread.sleep((int)(Math.random()*MAX_DELAY));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
