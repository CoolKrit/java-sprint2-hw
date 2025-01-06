import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, MonthTotalPerYear> monthData = new HashMap<>();

    void loadFromFile(ArrayList<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String[] lineContents = lines.get(i).split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean is_expense = Boolean.parseBoolean(lineContents[2]);

            if (!monthData.containsKey(month)) {
                monthData.put(month, new MonthTotalPerYear());
            }

            if (is_expense) {
                monthData.get(month).addExpense(amount);
            } else {
                monthData.get(month).addIncome(amount);
            }
        }
    }

    double getAvgExpense() {
        int countMonthsWithExpense = 0;
        double totalExpense = 0;

        for (MonthTotalPerYear month : monthData.values()) {
            if (month.getTotalExpense() > 0) {
                totalExpense += month.getTotalExpense();
                countMonthsWithExpense++;
            }
        }

        return countMonthsWithExpense > 0 ? totalExpense / countMonthsWithExpense : 0;
    }

    double getAvgIncome() {
        int countMonthsWithIncome = 0;
        double totalIncome = 0;

        for (MonthTotalPerYear month : monthData.values()) {
            if (month.getTotalIncome() > 0) {
                totalIncome += month.getTotalIncome();
                countMonthsWithIncome++;
            }
        }

        return countMonthsWithIncome > 0 ? totalIncome / countMonthsWithIncome : 0;
    }

    double getProfit(int month) {
        if (!monthData.containsKey(month)) return 0;
        return monthData.get(month).getProfit();
    }
}