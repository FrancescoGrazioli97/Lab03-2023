/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearText;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private ComboBox<String> cmbLingua;

    @FXML
    private Label lblError;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTesto;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	
    	txtResult.clear();
    	
    	String lingua = cmbLingua.getValue();
    	
    	dictionary.loadDictionary(lingua);
    	
    	String testo = txtTesto.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	// Controllo sull'input
		if (testo == null || testo.length() == 0) {
			txtResult.setText("Inserire almeno una parola");
			return;
		}

		List<String> inputTextList = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(testo, " ");
		while (st.hasMoreTokens()) {
			inputTextList.add(st.nextToken());
		}
		
		
		List<RichWord> outputTextList;
		
		outputTextList=dictionary.spellCheckText(inputTextList);
		
		
		int numErrori = 0;
		StringBuilder richText = new StringBuilder();

		for (RichWord r : outputTextList) {
			if (!r.isCorrect()) {
				numErrori++;
				richText.append(r.getParola() + "\n");
			}
		}
		this.txtResult.setText(richText.toString());
		//this.lblTime.setText("Spell check completed in " + (end - start) / 1E9 + " seconds");
		this.lblError.setText("The text contains " + numErrori + " errors");
    	
    	
		
		
		
		
		
		
		
		
		//txtResult.setText(""+testo);
    	
    	
    	

    }

    @FXML
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbLingua.getItems().addAll("English", "Italian");
        
        dictionary = new Dictionary();
       
        
    }

}


