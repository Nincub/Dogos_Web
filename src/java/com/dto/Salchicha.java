/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

/**
 *
 * @author root
 */
public class Salchicha {
    private int idSalchicha;
    private float precio;
    private String nombre;

    public Salchicha() {
    }

    public Salchicha(int idSalchicha, float precio, String nombre) {
        this.idSalchicha = idSalchicha;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSalchicha() {
        return idSalchicha;
    }

    public void setIdSalchicha(int idSalchicha) {
        this.idSalchicha = idSalchicha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
