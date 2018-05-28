package ru.bagautdinov.beans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.bagautdinov.beans.base.controllers.Controller;
import ru.bagautdinov.beans.components.MathComponent;
import ru.bagautdinov.beans.model.MathOperation;
import ru.bagautdinov.utils.AlertHelper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;

import java.util.List;

@Component
public class AppController implements Controller {
	
	@FXML
	private TextField calcInput;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private ToggleGroup toggleGroup;
	
	@Autowired
	public MathComponent math;
	
	@FXML
	private Label history;
	
	public String chosenFunction = "+";

	private Node view;

	@Override
	public Node getView() {
		return view;
	}

	@Override
	public void setView(Node view) {
		this.view = view;
	}
	
	@FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
		Window owner = submitButton.getScene().getWindow();
		String input = calcInput.getText();
		MathOperation mo = new MathOperation();
		mo.setNumber(input);
		mo.setFunction(chosenFunction);
		try {
			math.proceed(mo);
		} catch (Exception e) {
			AlertHelper.showAlert(AlertType.ERROR, owner, "Invalid math operation unit.", "Current math operation unit: " + mo.toString());
			e.printStackTrace();
		}
		if (math.getHistory() != null && math.getHistory().size() != 0) {
			List<Double> histArr = math.getHistory();
			history.setText("Last Result: " + histArr.get(histArr.size()-1));
		}
		else {
			history.setText("");
		}
	}
	
	public void initialize() {
		toggleGroup.selectedToggleProperty().addListener((ov, oldToggle, newToggle) -> {
			 if (toggleGroup.getSelectedToggle() != null) {
                 RadioButton button = (RadioButton) toggleGroup.getSelectedToggle();
                 chosenFunction = button.getText();
             }
		});
	}

}
