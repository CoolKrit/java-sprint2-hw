public class Transaction {
    String item_name;
    int quantity;
    int unit_price;
    boolean is_expense;

    Transaction(String item_name, boolean is_expense, int quantity, int unit_price) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    double getTotal() {
        return quantity * unit_price;
    }
}