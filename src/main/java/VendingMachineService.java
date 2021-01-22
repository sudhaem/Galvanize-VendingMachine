import model.Item;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineService {

    public double customerBalance;
    List<Item> items = new ArrayList<>();
    double balanceFromItemSales;

    public boolean isVendingMachineEmpty() {

        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getBalance() {

        return balanceFromItemSales;

    }

    public void withdraw(double amountToWithdraw) {
        balanceFromItemSales-= amountToWithdraw;
    }

    public void addFunds(double amountToAdd) {
        balanceFromItemSales+= amountToAdd;

    }

    public void insertMoneyFromCustomer(double amountInserted) {
        customerBalance+= amountInserted;
    }

    public double getCustomerBalance() {

        return customerBalance;
    }

    public void purchaseItem(String itemCode) throws Exception {
        Item itemToPurchase = items.stream().filter(item ->
                item.getCode().equals(itemCode)).findFirst().get();

        if(customerBalance < itemToPurchase.getPrice()) {
            throw new Exception();
        }
        balanceFromItemSales+= itemToPurchase.getPrice();
        items.remove(itemToPurchase);

    }
}
