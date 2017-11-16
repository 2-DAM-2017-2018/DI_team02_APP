/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela_1;

import Escuela.Aula;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agd19
 */
@XmlRootElement(name = "aula")
public class AulaListWrapper {
    private List<Aula> aula;

    @XmlElement(name = "person")
    public List<Aula> getPersons() {
        return aula;
    }

    public void setPersons(List<Aula> persons) {
        this.aula = persons;
    }
    
}
