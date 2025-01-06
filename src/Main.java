import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportEngine reportEngine = new ReportEngine();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                reportEngine.readMonthlyReports();
            } else if (userInput == 2) {
                reportEngine.readYearlyReport();
            } else if (userInput == 3) {
                reportEngine.compareReports();
            } else if (userInput == 4) {
                reportEngine.printMonthlyReports();
            } else if (userInput == 5) {
                reportEngine.printYearlyReport();
            } else if (userInput == 0) {
                System.out.println("Завершение работы.");
                return;
            } else {
                System.out.println("Неверная команда!");
            }
        }
    }

    static void printMenu() {
        System.out.println("1. - Считать все месячные отчёты.");
        System.out.println("2. - Считать годовой отчёт.");
        System.out.println("3. - Сверить отчёты.");
        System.out.println("4. - Вывести информацию обо всех месячных отчётах.");
        System.out.println("5. - Вывести информацию о годовом отчёте.");
        System.out.println("0. - Завершить работу");
    }
}