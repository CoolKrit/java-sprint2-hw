import java.util.ArrayList;

public class MonthlyReport {
    String[] monthsNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    ArrayList<Transaction> transactions = new ArrayList<>();

    void loadFromFile(ArrayList<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String[] lineContents = lines.get(i).split(",");
            String item_name = lineContents[0];
            boolean is_expense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            int unit_price = Integer.parseInt(lineContents[3]);
            transactions.add(new Transaction(item_name, is_expense, quantity, unit_price));
        }
    }

    double calculateTotalExpense() {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.is_expense) {
                total += transaction.getTotal();
            }
        }
        return total;
    }

    double calculateTotalIncome() {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (!transaction.is_expense) {
                total += transaction.getTotal();
            }
        }
        return total;
    }

    String[] getMostProfitableProduct() {
        String[] product = {"", "0"};

        for (Transaction transaction : transactions) {
            if (!transaction.is_expense) {
                if (Double.parseDouble(product[1]) < transaction.unit_price * transaction.quantity) {
                    product[0] = transaction.item_name;
                    product[1] = String.valueOf(transaction.unit_price * transaction.quantity);
                }
            }
        }
        return product;
    }

    String[] getBiggestWaste() {
        String[] product = {"", "0"};

        for (Transaction transaction : transactions) {
            if (transaction.is_expense) {
                if (Double.parseDouble(product[1]) < transaction.unit_price * transaction.quantity) {
                    product[0] = transaction.item_name;
                    product[1] = String.valueOf(transaction.unit_price * transaction.quantity);
                }
            }
        }
        return product;
    }
}