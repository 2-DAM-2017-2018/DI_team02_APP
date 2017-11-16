/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author agd19
 */
public class Aula 
{
    private final StringProperty nombreRecurso;
    private final StringProperty asignatura;
    private final StringProperty curso;
    private final StringProperty hora;
    private final StringProperty tutor;
    private final StringProperty mes;
    private final StringProperty dia;
    
    public Aula ()
    {
        this(null, null, null, null, null, null, null);
    }

    public Aula(String nombreRecurso, String asignatura, String curso, String hora, String tutor, String mes, String dia) {
        this.nombreRecurso = new SimpleStringProperty(nombreRecurso);
        this.asignatura = new SimpleStringProperty (asignatura);
        this.curso = new SimpleStringProperty (curso);
        this.hora = new SimpleStringProperty (hora);
        this.tutor = new SimpleStringProperty (tutor);
        this.mes = new SimpleStringProperty (mes);
        this.dia = new SimpleStringProperty (dia);
    }
    
    public String getNombreRecurso() {
        return nombreRecurso.get();
    }
    
    public StringProperty NombreRecursoProperty(){
        return nombreRecurso;
    }
    
    public void setNombreRecurso(String nombreRecurso){
        this.nombreRecurso.set(nombreRecurso);
    }
    public String getAsignatura(){
        return asignatura.get();
    }
    
    public StringProperty AsignaturaProperty() {
        return asignatura;
    }
    
    public String getCurso(){
        return curso.get();
    }
    
    public StringProperty CursoProperty() {
        return curso;
    }
    
    public String getHora(){
        return hora.get();
    }
    
    public StringProperty HoraProperty() {
        return hora;
    }
    
    public String getTutor(){
        return tutor.get();
    }
    
    public StringProperty TutorProperty() {
        return tutor;
    }
    
    public String getMes(){
        return mes.get();
    }
    
    public StringProperty MesProperty() {
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
    
    public String getDia(){
        return dia.get();
    }
    
    public StringProperty DiaProperty()
    {
        return dia;
    }
    
    public void setDia(String dia)
    {
        this.dia.set(dia);
    }
    
}
