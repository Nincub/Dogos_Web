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
public class Dogo {
    private int idDogo;
    private int idSalchicha;
    private int idPan;
    private float precio;

    public Dogo() {
    }

    public Dogo(int idDogo, int idSalchicha, int idPan, float precio) {
        this.idDogo = idDogo;
        this.idSalchicha = idSalchicha;
        this.idPan = idPan;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdDogo() {
        return idDogo;
    }

    public void setIdDogo(int idDogo) {
        this.idDogo = idDogo;
    }

    public int getIdSalchicha() {
        return idSalchicha;
    }

    public void setIdSalchicha(int idSalchicha) {
        this.idSalchicha = idSalchicha;
    }

    public int getIdPan() {
        return idPan;
    }

    public void setIdPan(int idPan) {
        this.idPan = idPan;
    }
    
    
    
}
