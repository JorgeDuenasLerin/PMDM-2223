package com.example.pmdm_2223.ut03.datos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimalDAO animalDao();
}