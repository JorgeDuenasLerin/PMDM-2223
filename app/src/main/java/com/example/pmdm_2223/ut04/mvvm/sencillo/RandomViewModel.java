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
    private MutableLiveData<RandomModel> dato;

    // Envoltorio para Thread, ejecución de tareas segundo plano
    private ExecutorService executor;

    public RandomViewModel(){
        randomModel = new RandomModel();
        executor = Executors.newSingleThreadExecutor();
    }

    public LiveData<RandomModel> getDato() {
        if (dato == null) {
            dato = new MutableLiveData<RandomModel>();
            dato.setValue(randomModel);
        }
        return dato;
    }

    public void generarRandom() {
        executor.execute(() -> {
            // Petición que tarda
            randomModel.generateRandom();
            // No se establece en el acto. Actualiza el Thread de la UI
            dato.postValue(randomModel);
        });
    }
}