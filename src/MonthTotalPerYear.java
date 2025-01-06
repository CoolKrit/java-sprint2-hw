public class MonthTotalPerYear {
    double totalIncome;
    double totalExpense;

    void addIncome(double income) {
        totalIncome += income;
    }

    void addExpense(double expense) {
        totalExpense += expense;
    }

    double getProfit() {
        return totalIncome - totalExpense;
    }

    double getTotalIncome() {
        return totalIncome;
    }

    double getTotalExpense() {
        return totalExpense;
    }
}