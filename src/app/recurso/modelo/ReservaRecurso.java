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
public class ReservaRecurso {
    //private final StringProperty nombre;
    private Recurso recurso;
    private StringProperty dia;
    
    public ReservaRecurso()
    {
        this(null, null);
    }
    
    public ReservaRecurso(Recurso recurso, String dia) {
        this.recurso = recurso;
        this.dia = new SimpleStringProperty (dia);
    }
    
       public StringProperty DiaProperty() {
        return dia;
    }
    
     public String getDia() {
        return dia.get();
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    
    

    
    
}
