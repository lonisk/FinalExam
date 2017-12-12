package pkgCore;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;
public class Retirement {
	private int YearsToWork;
	private double WorkingAnnualReturn;
	private int YearsRetired;
	private double AnnualReturnRetired;
	private double ReqIncome;
	private double MonthSocSec;
	
	public Retirement(int YearsToWork, double WorkingAnnualReturn, int YearsRetired, double AnnualReturnRetired, double ReqIncome, double MonthSocSec) {

	this.setYearsToWork(YearsToWork);
	this.setAnnualReturnRetired(AnnualReturnRetired);
	this.setYearsRetired(YearsRetired);
	this.setAnnualReturnWorking(WorkingAnnualReturn);
	this.setReqIncome(ReqIncome);
	this.setMonthSocSec(MonthSocSec);
	}

	public int getYearsToWork() {
		return YearsToWork;
	}

	public void setYearsToWork(int YearsToWork) {
		this.YearsToWork = YearsToWork;
	}

	public double getAnnualReturnWorking() {
		return WorkingAnnualReturn;
	}
	
	//created to have all setters and getters. Future use?
	public void setAnnualReturnWorking(double AnnualReturnWorking) {
		this.WorkingAnnualReturn = WorkingAnnualReturn;
	}

	public int getYearsRetired() {
		return YearsRetired;
	}

	public void setYearsRetired(int YearsRetired) {
		this.YearsRetired = YearsRetired;
	}

	public double getAnnualReturnRetired() {
		return AnnualReturnRetired;
	}

	public void setAnnualReturnRetired(double AnnualReturnRetired) {
		this.AnnualReturnRetired = AnnualReturnRetired;
	}

	public double getReqIncome() {
		return ReqIncome;
	}

	public void setReqIncome(double ReqIncome) {
		this.ReqIncome = ReqIncome;
	}

	public double getMonthSocSec() {
		return MonthSocSec;
	}

	public void setMonthSocSec(double MonthSocSec) {
		this.MonthSocSec = MonthSocSec;
	}

	public double AmountToSave() {
		//value comes out neg, so inserting (-1)*value
		DecimalFormat decform = new DecimalFormat("0.0");
		return (-1)*Double.parseDouble(decform.format(FinanceLib.pmt((WorkingAnnualReturn)/(12),
				(YearsToWork)*(12), 0, this.TotalAmountSaved(), false)));
	}

	public double TotalAmountSaved() {
		//value comes out neg, so inserting (-1)*value
		DecimalFormat decform = new DecimalFormat("0.0");
		return (-1)*Double.parseDouble(decform.format(FinanceLib.pv((AnnualReturnRetired)/(12),
				(YearsRetired)*(12), (ReqIncome - MonthSocSec), 0.0, false)));
	}
}