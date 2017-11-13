/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import javafx.fxml.FXML;
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
      
        HorasColumn.setCellValueFactory(cellData -> cellData.getValue());
        CursoColumn.setCellValueFactory(cellData -> cellData.getValue());
        AsignaturaColumn.setCellValueFactory(cellData -> cellData.getValue());
        TutorColumn.setCellValueFactory(cellData -> cellData.getValue());

        showAulaDetails(null);

        HorasColumn.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAulaDetails(newValue));

    }

    
        public void setMainApp(Menu mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //AulaTable.setItems(mainApp.());
    }
    
    private void showAulaDetails(Aula aula) {
        if (aula != null) {
           HorasColumn.setText();
        } else {
             HorasColumn.setText("");
             CursoColumn.setText("");
             AsignaturaColumn.setText("");
             TutorColumn.setText("");
        }

    }

}
