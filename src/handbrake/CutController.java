/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The Game
 */
public class CutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public Button cut_cancel_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void cutCancelButton(ActionEvent event) {        
        Stage stage = (Stage) cut_cancel_btn.getScene().getWindow();
        stage.close();
    }
    
}
