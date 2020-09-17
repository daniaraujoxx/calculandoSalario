package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String [] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o departamento do trabalhador");
		String departamentName = sc.nextLine();
		System.out.println("Insira os dados do trabalhador: ");
		System.out.println("Nome:: ");
		String workerName = sc.nextLine();
		System.out.println("Cargo: ");
		String workerLevel = sc.nextLine();
		System.out.println("salario base: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.println("Quantos contratos esse trabalhador tem? ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Digite o numero" + i + "contrato");
			System.out.println("Date {DD/MM/YYYY");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duracao em horas");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.println("Entre com o mês e ano para calcular o salário: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departamente: " + worker.getDeparment().getName());
		System.out.println("Renda: " + monthAndYear + ": " +String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}

}
