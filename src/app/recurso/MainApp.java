/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso;

import app.recurso.vista.MenuController;
import app.recurso.modelo.Recurso;
import app.recurso.modelo.ReservaRecurso;
import app.recurso.vista.Crear_aulaController;
import app.recurso.vista.Menu_reservar_recursoController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author agd19
 */
public class MainApp extends Application{

    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    private ObservableList<Recurso> RecursoData = FXCollections.observableArrayList();
    private ObservableList<ReservaRecurso> ReservaData = FXCollections.observableArrayList();
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ResourceApp");

        CargarMenu();

    }
    
    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        RecursoData.add(new Recurso("patio"));
        RecursoData.add(new Recurso("aula musica"));
        RecursoData.add(new Recurso("biblioteca"));
        
        Recurso r1 = new Recurso("patio");
        Recurso r2 = new Recurso("aula musica");
        Recurso r3 = new Recurso("biblioteca");
        
        ReservaRecurso rr1 = new ReservaRecurso(r1,"12","","");
        ReservaRecurso rr2 = new ReservaRecurso(r2,"23","","");
        ReservaRecurso rr3 = new ReservaRecurso(r3,"30","","");
        
        ReservaData.add(rr1);
        ReservaData.add(rr2);
        ReservaData.add(rr3);
        
    }
     /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Recurso> getRecursoData() {
        return RecursoData;
    }
    
    public ObservableList<ReservaRecurso> getReservaData() {
        return ReservaData;
    }
    
    
    public void CargarMenu() {
        try {
             // Load Menu layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("vista/Menu.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the Menu layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            MenuController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showResourceEditDialog(Recurso recurso) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vista/Crear_aula.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Resource");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            Crear_aulaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setResource(recurso);
            System.out.println("Recurso creado ---> "+recurso.getNombre());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showReservaEditDialog(ReservaRecurso reserva) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vista/Menu_reservar_recurso.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Reserva");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            Menu_reservar_recursoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setReserva(reserva);
            
            //ReservaData.add(reserva);
            //System.out.println("dia creado ---> "+reserva.getDia());
            //System.out.println("recurso creado --->"+reserva.getRecurso().getNombre());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hola mundo");
    }
    
}
