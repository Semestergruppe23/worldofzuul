/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolEscape.Ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class startMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnStartGame(ActionEvent event) throws IOException {
        
      
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/SchoolEscape/Ui/startRoom.fxml"));
        Parent startParent = loader.load(); 
        Scene startScene = new Scene(startParent);
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(startScene);
        startStage.show();
    }

    @FXML
    private void btnHighScore(ActionEvent event) {
    }

    @FXML
    private void btnSettings(ActionEvent event) {
    }

    @FXML
    private void btnExitGame(ActionEvent event) {
    }
    
}
