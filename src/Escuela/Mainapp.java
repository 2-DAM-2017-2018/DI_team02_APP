/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mario
 */
public class Mainapp extends Application{
    
    private ArrayList<Aula> recursos = new ArrayList<>();
    private Stage primaryStage;
    private AnchorPane rootLayout;
    //private RootLayoutController rootLayout;
    
    /**
     * @param args the command line arguments
     */


    /**
     * The data as an observable list of recursos.
     */
    private ObservableList<Aula> aulaData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        // set the application icon
        //this.primaryStage.getIcons().add(new Image("file:resources/images/MailIcon.png"));

        initRootLayout();

        //showAulaOverview();
    }

    /**
     * Constructor
     */
    public Mainapp() {
        // Add some sample data
        aulaData.add(new Aula());
    }

    /**
     * Returns the data as an observable list of Persons.
     *
     * @return
     */
    public ObservableList<Aula> getAulaData() {
        return aulaData;
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainapp.class.getResource("Menu.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            MenuController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened person file.
        File file = getAulaFilePath();
        if (file != null) {
            loadAulaDataFromFile(file);
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showAulaOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainapp.class.getResource("Menu.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            
            // Give the controller access to the main app.
            MenuController controller = loader.getController();
            //controller.showAulaDetails(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean Crear_aula(Aula aula) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainapp.class.getResource("Crear_aula.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Aula");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the recurso into the controller.
            Aula controller = loader.getController();
            controller.AsignaturaProperty();
            controller.setAsignatura(aula.getAsignatura());

            // Set the dialog icon.
            //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getAulaFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Mainapp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setAulaFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Mainapp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param file
     */
    public void loadAulaDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AulaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            AulaListWrapper wrapper = (AulaListWrapper) um.unmarshal(file);

            aulaData.clear();
            aulaData.addAll(wrapper.getRecurso());

            // Save the file path to the registry.
            setAulaFilePath(file);

        } catch (Exception e) { // catches ANY exception
            //        Dialogs.create()
            //                .title("Error")
            //                .masthead("Could not load data from file:\n" + file.getPath())
            //                .showException(e);
        }
    }

    /**
     * Saves the current person data to the specified file.
     *
     * @param file
     */
    public void savePersonDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AulaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            AulaListWrapper wrapper = new AulaListWrapper();
            wrapper.setRecurso(aulaData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setAulaFilePath(file);
        } catch (Exception e) { // catches ANY exception
            //                Dialogs.create().title("Error")
            //                .masthead("Could not save data to file:\n" + file.getPath())
            //                .showException(e);
        }
    }

    /**
     * Opens a dialog to show birthday statistics.
     */


  

}
