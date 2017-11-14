/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import Escuela.Aula;
import java.awt.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author agd19
 */
public class Crear_aulaController {
    
    @FXML
    private TextField NuevaAula;
    
    private Stage dialogStage;
    private Aula aula;
    private boolean okClicked = false;
            
     /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    };
    
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
     /**
     * Sets the person to be edited in the dialog.
     * 
     * @param aula
     */
    public void setAula(Aula aula) {
        this.aula = aula;
        
        NuevaAula.setText(aula.getNombreRecurso());
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            aula.setNombreRecurso(NuevaAula.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
     /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (NuevaAula.getText() == null || NuevaAula.getText().length()== 0)
        {
            errorMessage += "Nombre de RECURSO no valido, Introduce un nombre!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Field");
            alert.setHeaderText("Please correct invalid field");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

