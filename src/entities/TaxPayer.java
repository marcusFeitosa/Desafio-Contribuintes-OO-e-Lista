package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpanding;
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpanding) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpanding = educationSpanding;
	}
	
	public TaxPayer() {
		
	}
	
	public double salaryTax() {
		double monthySalary=salaryIncome/12;
		if(monthySalary<3000.0)
			return 0;
		else if (monthySalary<=5000.0) 
			return salaryIncome*0.1;
		else 
			return salaryIncome*0.2;
	}
	
	public double servicesTax() {
		return servicesIncome*0.15;
	}
	
	public double capitalTax() {
		return capitalIncome*0.2;
	}
	
	public double grossTax() {
		return capitalTax()+servicesTax()+salaryTax();
	}
	
	public double taxRebate() {
		double deductibleExpenses=healthSpending+educationSpanding;  // gastos dedutiveis
		
		if(deductibleExpenses<grossTax()*0.3)
			return deductibleExpenses;
		else
			return grossTax()*0.3;
	}
	
	public double netTax() {
		return grossTax()-taxRebate();
	}
}
