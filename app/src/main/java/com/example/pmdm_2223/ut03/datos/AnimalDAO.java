package com.example.pmdm_2223.ut03.datos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDAO {
    @Query("SELECT * FROM animal")
    List<Animal> getAll();

    @Query("SELECT * FROM animal WHERE uid IN (:animalIds)")
    List<Animal> loadAllByIds(int[] animalIds);

    @Query("SELECT * FROM animal WHERE nombre LIKE :nombre LIMIT 1")
    Animal findByName(String nombre);

    @Insert
    void insertAll(Animal... users);

    @Delete
    void delete(Animal user);
}