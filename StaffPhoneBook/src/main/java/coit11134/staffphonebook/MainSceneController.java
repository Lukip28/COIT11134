/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit11134.staffphonebook;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author luke_
 */
public class MainSceneController implements Initializable {

    @FXML
    private TextArea txtOutput;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void displayAction(ActionEvent event) throws FileNotFoundException 
    {
        //readDataFileAndDisplay();
        System.out.println("You clicked on display");
        txtOutput.setText(App.getDataHandler().getDisplayOutput());
    }

    // Exits application whne the exit button is pressed
    @FXML
    private void exitAction(ActionEvent event) 
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to close?");
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK) 
            {
                Platform.exit();
            }
        });
    }
    
    // Part 1 method 
//    public void readDataFileAndDisplay() throws FileNotFoundException 
//    {
//        int count = 0; // counts number of entries
//        String allPhone = ""; // stores all names and phones as a single value
//        
//        try 
//        {
//            // Opens txt file
//            Scanner in = new Scanner(new FileReader("staffphone.txt")); 
//            String myEntry = "";
//            String name = "";
//            String phone = "";
//            
//            while(in.hasNextLine()) 
//            {
//                myEntry = in.nextLine();
//                StringTokenizer st = new StringTokenizer(myEntry, ",");
//                
//                while(st.hasMoreTokens()) 
//                {
//                    name = st.nextToken();
//                    phone = st.nextToken();
//                }
//                allPhone = allPhone + name + " " + phone + "\n";
//                count++;
//            }
//            
//            in.close();
//        }
//        catch (ArrayIndexOutOfBoundsException ex) 
//        {
//            
//        }
//        catch(IOException ex) 
//        {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "File reading exception");
//            alert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) 
//                {
//                    Platform.exit();
//                }
//                    
//            });
//        }
//        txtOutput.setText(allPhone + "\n" + "Total number of phone entry is: " + count);
//    }

    @FXML
    private void addAction(ActionEvent event) 
    {
        System.out.println("You clicked on Add!");
        //Switch to AddNumber scene
        App.changeScene(1);
    }

    @FXML
    private void clearAction(ActionEvent event) 
    {
        System.out.println("You clicked on Clear!");
        //Clears the text area
        txtOutput.setText("");
    }

    @FXML
    private void saveAction(ActionEvent event) 
    {
        System.out.println("You clicked on Save!");
        //All data saved to the test file
        App.getDataHandler().saveData();
    }
    
}
