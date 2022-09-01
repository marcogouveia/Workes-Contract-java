import com.sun.jdi.IntegerType;
import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departamentName = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        Double workerBaseSalary = sc.nextDouble();


        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));

        System.out.print("How many contracts to this worker? ");
        int contractsNumber = sc.nextInt();


        for (int i = 1; i <= contractsNumber; i++){
            System.out.println("Enter contract number " + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = dateFormat.parse(sc.next());

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            worker.addContract(contract);
        }

        System.out.println();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getName());
        System.out.println("Income for : " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)) );


        sc.close();


    }



}
