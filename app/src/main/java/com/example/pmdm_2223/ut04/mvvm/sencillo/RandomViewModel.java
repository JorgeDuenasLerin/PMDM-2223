package com.example.pmdm_2223.ut04.mvvm.sencillo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomViewModel extends ViewModel {

    // Modelo real con datos y transformaciones
    private RandomModel randomModel;

    // Información observable
    private MutableLiveData<Integer> dato;

    // Envoltorio para Thread, ejecución de tareas segundo plano
    private ExecutorService executor;

    public RandomViewModel(){
        randomModel = new RandomModel();
        executor = Executors.newSingleThreadExecutor();
    }

    public LiveData<Integer> getDato() {
        if (dato == null) {
            dato = new MutableLiveData<Integer>();
        }
        return dato;
    }

    public void generarRandom() {
        executor.execute(() -> {
            randomModel.newRandom();
        });
    }

    public void getRandom() {
        executor.execute(() -> {
            int r = randomModel.getLastRandom();
            dato.postValue(r);
        });
    }
}