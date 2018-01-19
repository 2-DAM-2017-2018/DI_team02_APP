/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.vista;

import app.recurso.MainApp;
import app.recurso.modelo.Recurso;
import app.recurso.modelo.ReservaRecurso;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author agd19
 */
public class Menu_reservar_recursoController {
    
    
    @FXML
    private ComboBox dia;
    @FXML
    private ComboBox resource;
    private Stage dialogStage;
    private ReservaRecurso reserva;
    private Recurso recurso;
    private MainApp mainApp;
    private boolean okClicked = false;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        for (int i = 1; i <= 31; i++) {
            dia.getItems().add(i);
        }
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        for (int i = 0; i < mainApp.getRecursoData().size(); i++) 
        {
            resource.getItems().add(mainApp.getRecursoData().get(i).getNombre());
            
        }
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
     * @param reserva
     */
    public void setReserva(ReservaRecurso reserva) {
        this.reserva = reserva;

        //NameField.setText(reserva.);
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
            //reserva.setNombre(NameField.getText());
            reserva.setDia(dia.getSelectionModel().getSelectedItem().toString());
            recurso = new Recurso();
            recurso.setNombre(resource.getSelectionModel().getSelectedItem().toString());
            System.out.println("Elemento recurso a reservar ---> "+resource.getSelectionModel().getSelectedItem().toString());
            reserva.setRecurso(recurso);
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
