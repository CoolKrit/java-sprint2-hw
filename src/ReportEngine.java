import java.util.ArrayList;

public class ReportEngine {
    MonthlyReport[] monthlyReports = new MonthlyReport[12];
    YearlyReport yearlyReport;
    FileReader fileReader = new FileReader();

    void readMonthlyReports() {
        for (int i = 0; i < 3; i++) {
            ArrayList<String> lines = fileReader.readFileContents("m.20210" + (i + 1) + ".csv");
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.loadFromFile(lines);
            monthlyReports[i] = monthlyReport;
        }
        System.out.println("Месячные отчеты успешно считаны.");
    }

    void readYearlyReport() {
        yearlyReport = new YearlyReport();
        yearlyReport.loadFromFile(fileReader.readFileContents("y.2021.csv"));
        System.out.println("Годовой отчёт успешно считан.");
    }

    void compareReports() {
        if (monthlyReports[0] == null || yearlyReport == null) {
            System.out.println("Отчёты не были считаны. Сначала загрузите данные.");
            return;
        }

        for (int i = 0; i < monthlyReports.length; i++) {
            if (monthlyReports[i] == null) {
                return;
            }

            double monthlyIncome = monthlyReports[i].calculateTotalIncome();
            double monthlyExpense = monthlyReports[i].calculateTotalExpense();
            double[] yearlyData = new double[]{yearlyReport.monthData.get(i + 1).getTotalIncome(), yearlyReport.monthData.get(i + 1).getTotalExpense()};

            if (monthlyIncome != yearlyData[0] || monthlyExpense != yearlyData[1]) {
                System.out.println("Несоответствие в месяце " + monthlyReports[i].monthsNames[i]);
            } else {
                System.out.println("Данные за месяц " + monthlyReports[i].monthsNames[i] + " совпадают.");
            }
        }
    }

    void printMonthlyReports() {
        if (monthlyReports[0] == null) {
            System.out.println("Месячные отчёты не были считаны. Сначала загрузите данные.");
            return;
        }

        for (int i = 0; i < monthlyReports.length; i++) {
            if (monthlyReports[i] == null) {
                return;
            }

            System.out.println("Месяц: " + monthlyReports[i].monthsNames[i]);
            System.out.println("Самый прибыльный товар: " + monthlyReports[i].getMostProfitableProduct()[0] + " - " + monthlyReports[i].getMostProfitableProduct()[1]);
            System.out.println("Самая большая трата: " + monthlyReports[i].getBiggestWaste()[0] + " - " + monthlyReports[i].getBiggestWaste()[1]);
        }
    }

    void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не был считан. Сначала загрузите данные.");
            return;
        }

        System.out.println("Год: 2021");
        System.out.println(yearlyReport.monthData.keySet());
        for (int i = 0; i < monthlyReports.length; i++) {
            if (monthlyReports[i] == null) break;
            System.out.println("Прибыль за " + monthlyReports[i].monthsNames[i] + ": " + (int) yearlyReport.getProfit(i + 1));
        }
        System.out.println("Cредний расход за все имеющиеся операции в году: " + (int) yearlyReport.getAvgExpense());
        System.out.println("Cредний доход за все имеющиеся операции в году: " + (int) yearlyReport.getAvgIncome());
    }
}