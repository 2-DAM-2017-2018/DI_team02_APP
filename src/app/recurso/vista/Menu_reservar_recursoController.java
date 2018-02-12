/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso.vista;

import app.recurso.MainApp;
import app.recurso.modelo.Recurso;
import app.recurso.modelo.ReservaRecurso;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField nombre_p;
    @FXML
    private ComboBox horas;
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
        nombre_p.setText(" ");
        for (int i = 1; i <= 31; i++) {
            dia.getItems().add(i);

        }
        for (int i = 8; i < 15; i++) {
            horas.getItems().add(i + ":00");
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        for (int i = 0; i < mainApp.getRecursoData().size(); i++) {
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
        int selectedIndex = dia.getSelectionModel().getSelectedIndex();
        int selectedIndex1 = horas.getSelectionModel().getSelectedIndex();
        int selectedIndex2 = resource.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex1 >= 0 && selectedIndex2 >= 0 && !" ".equals(nombre_p.getText())) {
            reserva.setDia(dia.getSelectionModel().getSelectedItem().toString());
            recurso = new Recurso();
            recurso.setNombre(resource.getSelectionModel().getSelectedItem().toString());
            System.out.println("Elemento recurso a reservar ---> " + resource.getSelectionModel().getSelectedItem().toString());
            reserva.setRecurso(recurso);
            okClicked = true;
            System.out.println("Recurso creado -> " + recurso.getNombre());
            StringProperty v = null;
            v = new SimpleStringProperty(nombre_p.getText());
            reserva.setNombre_p(v);
            System.out.println("Nombre profesor" + v);
            StringProperty v1 = null;
            v1 = new SimpleStringProperty(horas.getSelectionModel().getSelectedItem().toString());
            System.out.println("Hora que se está reservando ------->" + v1);
            reserva.setHoras(v1);

            dialogStage.close();
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Reservation incompleted!");
            alert.setContentText("Please complete all fields ");

            alert.showAndWait();
        }

    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

}
