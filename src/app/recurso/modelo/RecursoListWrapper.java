/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of resources. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "recursos")
public class RecursoListWrapper {

    private List<Recurso> recurso;

    @XmlElement(name = "recurso")
    public List<Recurso> getRecursos() {
        return recurso;
    }

    public void setRecursos(List<Recurso> recurso) {
        this.recurso = recurso;
    }
}