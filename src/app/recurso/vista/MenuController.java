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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author agd19
 */
public class MenuController {
    @FXML
    private TableView<ReservaRecurso> ReservaTable;
    @FXML
    private TableColumn<ReservaRecurso, String> NameColumn;
    @FXML
    private TableColumn<ReservaRecurso, String> DiaColumn;
    @FXML
    private ComboBox comboRecursos;
    
    private MainApp mainApp;
    
    public MenuController() 
    {
        
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getRecurso().NombreProperty());
        DiaColumn.setCellValueFactory(cellData -> cellData.getValue().DiaProperty());
        
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        ReservaTable.setItems(mainApp.getReservaData());
        
        for (int i = 0; i < mainApp.getRecursoData().size(); i++) 
        {
            comboRecursos.getItems().add(mainApp.getRecursoData().get(i).getNombre());
            
        }
    }
    
    @FXML
    private void handleDeleteReserva() {
        int selectedIndex = ReservaTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ReservaTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No reservation Selected");
            alert.setContentText("Please select a reservation in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewResource() {
        Recurso tempRecurso = new Recurso();
        boolean okClicked = mainApp.showResourceEditDialog(tempRecurso);
        if (okClicked) {
            mainApp.getRecursoData().add(tempRecurso);
            //comboRecursos.getItems().add(tempRecurso.getNombre().toString());
            comboRecursos.getItems().clear();
            for (int i = 0; i < mainApp.getRecursoData().size(); i++) 
        {
            
            comboRecursos.getItems().add(mainApp.getRecursoData().get(i).getNombre());
            
        }
        }
    }
    
    @FXML
    private void handleDeleteResource(){
        int selectedIndex = comboRecursos.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            for (int i = 0; i < mainApp.getRecursoData().size(); i++) {
                if(mainApp.getRecursoData().get(i).getNombre().equals(comboRecursos.getSelectionModel().getSelectedItem().toString()))
                {
                    mainApp.getRecursoData().remove(i);
                }
            }
            comboRecursos.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Resource Selected");
            alert.setContentText("Please select a Resource in the comboBox.");

            alert.showAndWait();
        }
        
    }
    
    @FXML
    private void handleNewReserva(){
        ReservaRecurso reserva = new ReservaRecurso();
        //Recurso r5 = new Recurso();
        //r5.setNombre(comboRecursos.getSelectionModel().getSelectedItem().toString());
        //reserva.setRecurso(r5);
        //reserva.setDia("1");
        boolean okClicked = mainApp.showReservaEditDialog(reserva);
        
        if (okClicked) {
            mainApp.getReservaData().add(reserva);
            ReservaTable.setItems(mainApp.getReservaData());
            
        }
    }
    
   
    
    
    
}
