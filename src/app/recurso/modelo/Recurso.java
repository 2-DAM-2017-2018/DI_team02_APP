/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author agd19
 */
public class Recurso 
{
    private final StringProperty nombre;
    
    public Recurso() {
        this(null);
    }

    public Recurso(String nombre) {
        this.nombre = new SimpleStringProperty (nombre);
    }

    public StringProperty NombreProperty() {
        return nombre;
    }
    
     public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
}
