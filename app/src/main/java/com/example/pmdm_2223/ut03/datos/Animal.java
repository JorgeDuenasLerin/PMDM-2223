package com.example.pmdm_2223.ut03.datos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity(tableName = "animal")
public class Animal {
    @PrimaryKey
    @NotNull
    public String uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "tipo")
    public String tipo;

    public Animal(){
        uid = UUID.randomUUID().toString();
    }
}