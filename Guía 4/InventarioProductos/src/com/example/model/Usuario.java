package com.example.model;

public class Usuario {
    private int id;
    private String username;
    private String nombre;
    private String rol;
    private String password;

    public Usuario(int id, String username, String nombre, String rol) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}