import model.Item;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineService {

    List<Item> items = new ArrayList<>();

    public boolean isVendingMachineEmpty() {

        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
