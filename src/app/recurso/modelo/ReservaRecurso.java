/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * clase reservar recurso
 *
 * @author agd19
 */
public class ReservaRecurso {

    private Recurso recurso;
    private StringProperty dia;
    private StringProperty nombre_p;
    private StringProperty horas;

    public ReservaRecurso() {
        this(null, null, null, null);
    }

    public ReservaRecurso(Recurso recurso, String dia, String nombre, String horas) {
        this.recurso = recurso;
        this.dia = new SimpleStringProperty(dia);
        this.nombre_p = new SimpleStringProperty(nombre);
        this.horas = new SimpleStringProperty(horas);

    }

    public StringProperty getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(StringProperty nombre_p) {
        this.nombre_p = nombre_p;
    }

    public StringProperty NombreProperty() {
        return dia;
    }

    public StringProperty getHoras() {
        return horas;
    }

    public void setHoras(StringProperty horas) {
        this.horas = horas;
    }

    public StringProperty HoraProperty() {
        return dia;
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

    public StringProperty HorasProperty() {
        return horas;
    }

}
