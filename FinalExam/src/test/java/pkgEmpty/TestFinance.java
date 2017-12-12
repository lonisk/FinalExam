package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.poi.ss.formula.functions.*;
public class TestFinance {

	@Test 
	public void TestAmounts()
	{
		double MonthsToWork = (65-23) * (12); //retire at 65, 23 now
		double WorkingAnnualReturn = (0.07) / (12); //7% return average times 12 months
		double MonthsRetired = (20) * (12); //live till 85
		double AnnualReturnRetired = 0.025 / 12; //2.5% return after retirement
		double RequiredIncome = 15000;
		double MonthSocSec = 2642;
		double PV = FinanceLib.pv(AnnualReturnRetired, MonthsRetired, RequiredIncome - MonthSocSec, 0, false);
		double PMT = FinanceLib.pmt(WorkingAnnualReturn, MonthsToWork, 0, PV, false);
			System.out.println(PV);
			System.out.println(PMT);
	}
	
	@Test
	public void PVtest()
	{
		double rate = (0.025)/(12);
		double numPayPeriods = (20)*(12);
		double paymentAm = (12000)-(2642);
		double futVal = 0;
		boolean PayPeriodTF = false;
		double PV = FinanceLib.pv(rate, numPayPeriods, paymentAm, futVal, PayPeriodTF);
	}
	
	@Test
	public void PVtest1()
	{
		double rate = (0.05)/(12);
		double numPayPeriods = (25)*(12);
		double paymentAm = (15000)-(2642);
		double futVal = 0;
		boolean PayPeriodTF = false;
		double PV = FinanceLib.pv(rate, numPayPeriods, paymentAm, futVal, PayPeriodTF);
	}
	
	@Test
	public void PMTtest() {
		double rate = (0.025)/(12);
		double numPayPeriods = 72;
		double presValue = 25000;
		double futVal = 0;
		boolean PayPeriodTF = false;
		double PMT = FinanceLib.pmt(rate, numPayPeriods, presValue, futVal, PayPeriodTF);	
	}
	
	@Test
	public void PMTtest2() {
		double rate = (0.075)/(12);
		double numPayPeriods = 48;
		double presValue = 20000;
		double futVal = 0;
		boolean PayPeriodTF = false;
		double PMT = FinanceLib.pmt(rate, numPayPeriods, presValue, futVal, PayPeriodTF);	
	}
}