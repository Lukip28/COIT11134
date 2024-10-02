package coit11134.staffphonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene sceneMain;
    private static Scene sceneAddNumber;
    private static Stage stage;
    private static DataHandler data;

    @Override
    public void start(Stage stage) throws IOException {
        // Instantiates the DataHandler object
        data = new DataHandler("staffphone.txt");
        
        // Creates the Main and AddNumber scene
        Parent rootMain = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Parent rootAddNum = FXMLLoader.load(getClass().getResource("addPhoneScene.fxml"));
        
        sceneMain = new Scene(rootMain);
        sceneAddNumber = new Scene(rootAddNum);
        
        this.stage = stage;
        // set the current scene to the main scene
        stage.setScene(sceneMain);
        stage.show();
    }
    
    // Method for passing a reference to the data object
    public static DataHandler getDataHandler() 
    {
        return data;
    }
    
    // Method for switching scenes
    public static void changeScene(int sc) 
    {
        switch(sc) 
        {
            case 0: stage.setScene(sceneMain); break;
            case 1: stage.setScene(sceneAddNumber); break;
        }
    }
    
    // Method for exiting the application
    public static void exit() 
    {
        stage.close();
    }

    //static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    //}

    //private static Parent loadFXML(String fxml) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        //return fxmlLoader.load();
    //}

    public static void main(String[] args) {
        launch();
    }

}