/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class MenuController {

    @FXML
    private TableView<Aula> AulaTable;
    @FXML
    private TableColumn<Aula, String> HorasColumn;
    @FXML
    private TableColumn<Aula, String> CursoColumn;
    @FXML
    private TableColumn<Aula, String> AsignaturaColumn;
    @FXML
    private TableColumn<Aula, String> TutorColumn;

    @FXML
    private Button Nuevobutton;
    @FXML
    private Button Eliminarbutton;
    @FXML
    private Button Aniadirrecursobutton;
    @FXML
    private Button Eliminarrecusobutton;

    private Mainapp mainapp;
    private Menu mainApp;
    private Aula aula;
    private boolean NuevoClicked = false;
    private Stage dialogStage;

    public MenuController() {
        
        
        
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    

    @FXML
    private void initialize() {

        HorasColumn.setCellValueFactory(cellData -> cellData.getValue().HoraProperty());
        CursoColumn.setCellValueFactory(cellData -> cellData.getValue().CursoProperty());
        AsignaturaColumn.setCellValueFactory(cellData -> cellData.getValue().AsignaturaProperty());
        TutorColumn.setCellValueFactory(cellData -> cellData.getValue().TutorProperty());

        showAulaDetails(null);

        AulaTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAulaDetails(newValue));

    }

    public void setMainApp(Menu mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //AulaTable.setItems(mainApp.());
    }

    private void showAulaDetails(Aula aula) {
        if (aula != null) {
            HorasColumn.setText(aula.getHora());
            CursoColumn.setText(aula.getCurso());
            AsignaturaColumn.setText(aula.getAsignatura());
            TutorColumn.setText(aula.getTutor());

        } else {
            HorasColumn.setText("");
            CursoColumn.setText("");
            AsignaturaColumn.setText("");
            TutorColumn.setText("");
        }

    }

    @FXML
    private void handleDeleteRecurso() {
        int selectedIndex = AulaTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            AulaTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //   alert.initOwner(mainApp.get());
            alert.setTitle("No Selection");
            alert.setHeaderText("No resource Selected");
            alert.setContentText("Please select a resource in the table.");

            alert.showAndWait();
        }
    }
    
    public boolean isNuevoClicked() {
        return NuevoClicked;
    }
    
    @FXML
    private void handleNuevo() {
       
                 try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainapp.class.getResource("Menu_reservar_recurso.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reserva Recurso");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the dialog icon.
            //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            NuevoClicked = true;
            dialogStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
    
    @FXML
    private void handleAniadir() {
       
                 try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainapp.class.getResource("Crear_aulaController.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Crear Nuevo Recurso");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            

            // Set the dialog icon.
            //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            NuevoClicked = true;
            dialogStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}
