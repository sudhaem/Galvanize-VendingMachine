import model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineServiceTest {

    private VendingMachineService service;
    private Item item = new Item();
    @Before
    public void setup() {
        service = new VendingMachineService();
    }

    @Test
    public void isVendingMachineEmpty_ReturnsTrueIfItIsEmpty() {
        assertTrue(service.isVendingMachineEmpty());

    }
    @Test
    public void addItem() {
        service.addItem(item);
        assertFalse(service.isVendingMachineEmpty());
    }
    @Test
    public void getItems() {
        service.addItem(item);
        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item);
        List<Item> result = service.getItems();
        assertEquals(expectedItems, result);
    }



}
