package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		double salaryIncome;
		double servicesIncome;
		double capitalIncome;
		double healthSpending;
		double educationSpanding;
		
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		System.out.print("Quantos contribuintes voce quer? ");
		int n=sc.nextInt();
		
		List<TaxPayer>list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			System.out.println("Digite os dados do "+(i+1)+"o contribuinte: ");
			System.out.print("Renda anual com salário: ");
			salaryIncome=sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço :");
			servicesIncome=sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			capitalIncome=sc.nextDouble();
			System.out.print("Gastos médicos: ");
			healthSpending=sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			educationSpanding=sc.nextDouble();
			
			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpanding));
			
		}
		
		System.out.println();
		
		int i=1; /* fiz essa gambiarra
		         porque nao soube como usar no laço each*/ 
		
		for(TaxPayer t: list) {
			System.out.println("Resumo do "+i+"o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f\n",t.grossTax());
			System.out.printf("Abatimento: %.2f\n",t.taxRebate());
			System.out.printf("Imposto devido: %.2f\n",t.netTax());
			System.out.println("**-----------------------**");
			System.out.println();
			i++;
		}
		
		
		sc.close();

	}

}
