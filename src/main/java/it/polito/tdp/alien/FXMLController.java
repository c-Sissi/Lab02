/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Map<String,String> dizionario = new HashMap<String,String>();
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="lblAlien"
    private Label lblAlien; // Value injected by FXMLLoader

    @FXML // fx:id="txtDictionary"
    private TextArea txtDictionary; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {
    	txtParola.clear();
    	txtDictionary.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parola = txtParola.getText().toLowerCase();
    	
    	if(isValid(parola)) {
    		if(!parola.contains(" ") && dizionario.get(parola)!= null) {
    			txtDictionary.setText(dizionario.get(parola));
    		}
    		else if(parola.contains(" ")) {
	    		String arrParola[] = parola.split(" ");
	    		if(dizionario.get(arrParola[0])!= null) {
	    			txtDictionary.setText("La parola è già presente nel dizionario");
	    		}
	    		else {
	    			dizionario.put(arrParola[0], arrParola[1]);
	    			txtDictionary.setText("Parola aggiunta al dizionario!");
	    		}
    		}
    	}
    	else {
    		txtDictionary.setText("La parola deve contenere ESCLUSIVAMENTE lettere");
    		//throw new InvalidParameterException();
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblAlien != null : "fx:id=\"lblAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDictionary != null : "fx:id=\"txtDictionary\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public boolean isValid(String parola) {
    	if(parola.contains(" ")) {
    		String s = parola.replace(" ", "");
    		char arrS[]= s.toCharArray();
        	for(char c: arrS) {
        		if(!Character.isLetter(c)) {
        			return false;
        		}
        	}
    	}
        else {
	    	char arr[]= parola.toCharArray();
	    	for(char c: arr) {
	    		if(!Character.isLetter(c)) {
	    			return false;
	    		}
	    	}
        }
    	return true;
    }

}

