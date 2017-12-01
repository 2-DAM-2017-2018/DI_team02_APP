/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.awt.TextField;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author agd19
 */
public class Menu_reservar_recurso_Controller {
    
    @FXML
    private ComboBox<String> AulaCombo;
    @FXML
    private ComboBox<Integer> diaCombo;
    @FXML
    private ComboBox<String> mesCombo;
    @FXML
    private ComboBox<Integer> anioCombo;
    
    private AulaListWrapper recurso;

    private Mainapp mainApp;
    private Aula aula;
    private boolean okClicked = false;
    private ArrayList<Integer> dia;
    private ArrayList<String> mes;
    private ArrayList<Integer> anio;
    
    @FXML
    private TextField curso;
    
    @FXML
    private TextField asignatura;
    
    @FXML
    private TextField tutor;
    
    private Stage dialogStage;
    
    public Menu_reservar_recurso_Controller()
    {
        
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void initialize() 
    {
        this.AulaCombo = new ComboBox<String>();
        
        mes = new ArrayList<>();
        mes.add("Enero");
        mes.add("Febrero");
        mes.add("Marzo");
        mes.add("Abril");
        mes.add("Mayo");
        mes.add("Junio");
        mes.add("Julio");
        mes.add("Agosto");
        mes.add("Septiembre");
        mes.add("Octubre");
        mes.add("Noviembre");
        mes.add("Diciembre");
        
        /**
         * cargamos en el combo box los recursos a compartir
         */
        for (int i = 0; i < recurso.getRecurso().size(); i++) {
            AulaCombo.getItems().add(recurso.getRecurso().get(i).NombreRecursoProperty().toString());
        }
        
        /**
         * cargamos cargar en el combo box los dias
         */
        for (int i = 1; i <= 31; i++) {
            dia.add(i);
            diaCombo.getItems().add(dia.get(i));
        }
        
        /**
         * for para cargar los meses en el combo box los meses
         */
        for (int i = 1; i <= 12; i++) {
            mesCombo.getItems().add(mes.get(i));
        }
        
        /**
         * cargamos en el combo box los años
         */
        for (int i = 2017; i < 2050; i++) {
            anio.add(i);
            anioCombo.getItems().add(dia.get(i));
            
        }
               

    }
    
    public void setMainApp(Mainapp mainApp) {
        this.mainApp = mainApp;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
        
    
  
        
    @FXML
    private void handleOk() {
        
        
            aula.setCurso(curso.getText());
            aula.setAsignatura(asignatura.getText());
            aula.setTutor(tutor.getText());

            okClicked = true;
            dialogStage.close();
        
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    
    
}
