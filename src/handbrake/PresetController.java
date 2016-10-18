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
public class PresetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Button preset_cancel_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void cutCancelButton(ActionEvent event) {        
        Stage stage = (Stage) preset_cancel_btn.getScene().getWindow();
        stage.close();
    }
    
}
