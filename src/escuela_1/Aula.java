/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela_1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author agd19
 */
public class Aula 
{
    private final StringProperty asignatura;
    private final StringProperty curso;
    private final StringProperty hora;
    private final StringProperty tutor;
    private final StringProperty mes;
    private final StringProperty dia;
    
    public Aula ()
    {
        this(null, null, null, null, null, null);
    }

    public Aula(String asignatura, String curso, String hora, String tutor, String mes, String dia) {
        this.asignatura = new SimpleStringProperty (asignatura);
        this.curso = new SimpleStringProperty (curso);
        this.hora = new SimpleStringProperty (hora);
        this.tutor = new SimpleStringProperty (tutor);
        this.mes = new SimpleStringProperty (mes);
        this.dia = new SimpleStringProperty (dia);
    }

    public StringProperty getAsignatura() {
        return asignatura;
    }

    public StringProperty getCurso() {
        return curso;
    }

    public StringProperty getHora() {
        return hora;
    }

    public StringProperty getTutor() {
        return tutor;
    }

    public StringProperty getMes() {
        return mes;
    }
    
    public void setAsignatura(String asignatura)
    {
        this.asignatura.set(asignatura);
    }
    
    public void setCurso(String curso)
    {
        this.curso.set(curso);
    }
    
    public void setHora(String hora)
    {
        this.hora.set(hora);
    }
    
    public void setTutor(String tutor)
    {
        this.tutor.set(tutor);
    }
    
    public void setMes(String mes)
    {
        this.mes.set(mes);
    }
    
    public StringProperty getDia()
    {
        return dia;
    }
    
    public void setDia(String dia)
    {
        this.dia.set(dia);
    }
    
}
