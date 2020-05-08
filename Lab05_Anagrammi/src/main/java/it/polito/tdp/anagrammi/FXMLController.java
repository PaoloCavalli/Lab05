package it.polito.tdp.anagrammi;




import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

     Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtErrori;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    String parola;
    
    txtResult.clear();
    txtErrori.clear();
    
    parola = txtParola.getText();
    
    if(parola.length()<2) {
    	txtResult.appendText("Parola troppo breve !");
    	txtErrori.appendText("Parola troppo breve !");
    	return;
    }
    if(parola.length()>8) {
    	txtResult.appendText("Parola troppo lunga !");
    	txtErrori.appendText("Parola troppo lunga !");
    	return;
    }
    
    Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    
    for(String anagramma: anagrammi) {
    	if(this.model.isCorrect(anagramma))
    		txtResult.appendText(anagramma + "\n");
    	else 
    		txtErrori.appendText(anagramma + "\n");
      }
    }

    @FXML
    void doReset(ActionEvent event) {
    txtParola.clear();
    txtResult.clear();
    txtErrori.clear();
    
    }
    public void setModel(Model model) {
    	this.model= model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
  
}
