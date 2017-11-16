/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    private Escuela_1 mainapp;
    private Menu mainApp;
    private Aula aula;

    public MenuController() {
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
    private void handleDeletePerson() {
        int selectedIndex = AulaTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            AulaTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
         //   alert.initOwner(mainApp.get());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
