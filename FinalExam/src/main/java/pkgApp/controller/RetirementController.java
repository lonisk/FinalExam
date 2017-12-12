package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.util.NumberUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {
	@FXML
	private RetirementApp mainApp = null;
	@FXML 
	private TextField YearsToWork;
	@FXML 
	private TextField WorkingAnnualReturn;
	@FXML
	private TextField YearsRetired;
	@FXML
	private TextField AnnualReturnRetired;
	@FXML
	private TextField ReqIncome;
	@FXML
	private TextField MonthSocSec;
	@FXML
	private TextField TotalAmountSaved;
	@FXML
	private TextField AmountToSave;
	@FXML
	private Button Clear;
	@FXML
	private Button Calc;
	@FXML
	public RetirementApp getMainApp() {
		return mainApp;
	}
	
	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void btnClear(ActionEvent event) {
		System.out.println("Clear All"); //clear all fields
		YearsToWork.clear();
		WorkingAnnualReturn.clear();
		YearsRetired.clear();
		AnnualReturnRetired.clear();
		ReqIncome.clear();
		MonthSocSec.clear();
		TotalAmountSaved.clear();
		AmountToSave.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {

		if(isInputValid())
		{Retirement r = new Retirement((int) Integer.valueOf(YearsToWork.getText()),(double) Double.valueOf(WorkingAnnualReturn.getText()), (int) Integer.valueOf(YearsRetired.getText()),(double) Double.valueOf(AnnualReturnRetired.getText()),(double) Double.valueOf(ReqIncome.getText()), (double) Double.valueOf(MonthSocSec.getText()));
		TotalAmountSaved.setText(Double.toString(r.TotalAmountSaved()));
		AmountToSave.setText(Double.toString(r.AmountToSave()));
		}
	}
	
	//exceptions thrown
    private boolean isInputValid() {
        String OutputError = "";

        try {
            Integer.parseInt(YearsToWork.getText());
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "Years To Work must be valid integer:error"; 
        }
        
        try {
            Integer.parseInt(YearsRetired.getText());
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "Years Retired must be valid integer:error"; 
        }
        
        try {
            if(Double.parseDouble(WorkingAnnualReturn.getText())<0 || Double.parseDouble(WorkingAnnualReturn.getText())>.2) {
            	OutputError = OutputError + "Annual Return Working must be between 0-0.20:error";
            }
            
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "Working Annual Return must be a number:error"; 
        }
        
        try {
        	if(Double.parseDouble(AnnualReturnRetired.getText())<0 || Double.parseDouble(AnnualReturnRetired.getText())>.03) {
        		OutputError = OutputError + "Working Annual Return must be between 0-0.03:error";
            }
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "AnnualReturnRetired must be a number:error"; 
        }
        
        try {
            Double.parseDouble(ReqIncome.getText());
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "Required Income must be valid number:error"; 
        }

        try {
            Double.parseDouble(MonthSocSec.getText());
        } 
        catch (NumberFormatException e) {
        	OutputError = OutputError + "MonthSocSec must be valid number:error"; 
        }
        
        //length of string output ==0
        if (OutputError.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Entry");
            alert.setHeaderText("Correct invalid entires");
            alert.setContentText(OutputError);
            return false;
        }
    }
}