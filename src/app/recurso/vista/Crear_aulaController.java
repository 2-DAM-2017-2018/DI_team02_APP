/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.vista;

import app.recurso.modelo.Recurso;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author agd19
 */
public class Crear_aulaController {
    @FXML
    private TextField NameField;
    
    private Stage dialogStage;
    private Recurso recurso;
    private boolean okClicked = false;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }
    
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
     * @param recurso
     */
    public void setResource(Recurso recurso) {
        this.recurso = recurso;

        NameField.setText(recurso.getNombre());
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
        //if (isInputValid()) {
            recurso.setNombre(NameField.getText());
            okClicked = true;
            System.out.println("Recurso creado -> "+recurso.getNombre());
            dialogStage.close();
        //}
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
