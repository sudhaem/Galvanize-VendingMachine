import model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    @Test
    public void getBalance_ReturnsZeroBalance() {
        double result = service.getBalance();

        assertEquals(0.0, result, 0);

    }
    @Test
    public void withDraw() {
        service.balanceFromItemSales = 10;
        service.withdraw(3);
        double result = service.getBalance();
        assertEquals(7, result, 0);
    }
    @Test
    public void addFunds() {
        service.balanceFromItemSales = 15;
        service.addFunds(20);
        double result = service.getBalance();
        assertEquals(35, result, 0);
    }
    @Test
    public void getItems_ReturnsItemsWithProperties() {
         Item item1 = new Item();
         Item item2 = new Item();
         Item item3 = new Item();

         item1.setCode("AAA");
         item1.setName("Snickers");
         item1.setPrice(1.5);

        item2.setCode("BBB");
        item2.setName("Almond Joy");
        item2.setPrice(2.0);

        item3.setCode("CCC");
        item3.setName("Kit Kat");
        item3.setPrice(3.0);

        service.items = Arrays.asList(item1, item2, item3);
        List<Item> expectedItems = Arrays.asList(item1, item2, item3);
        assertEquals(expectedItems, service.getItems());

    }
    @Test
    public void insertMoneyFromCustomer() {

        service.insertMoneyFromCustomer(20);
        double result = service.getCustomerBalance();
        assertEquals(20, result, 0);
    }
    @Test(expected = Exception.class)
    public void purchaseItem_CustomerHadInSufficientFunds() throws Exception {

        Item item1 = new Item();

        item1.setCode("AAA");
        item1.setName("Snickers");
        item1.setPrice(1.5);
        service.items = Collections.singletonList(item1);
        service.purchaseItem("AAA");


    }
    @Test
    public void purchaseItem_AndRemovesItemFromList() throws Exception {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        item1.setCode("AAA");
        item1.setName("Snickers");
        item1.setPrice(1.5);

        item2.setCode("BBB");
        item2.setName("Almond Joy");
        item2.setPrice(2.0);

        item3.setCode("CCC");
        item3.setName("Kit Kat");
        item3.setPrice(3.0);

       List<Item> items = new ArrayList<>();
       items.add(item1);
        items.add(item2);
        items.add(item3);

        service.items = items;
        service.customerBalance = 2;
        service.purchaseItem("BBB");
        assertEquals(2, service.getBalance(), 0);
        List<Item> expectedItems = Arrays.asList(item1, item3);

        assertEquals(expectedItems, service.getItems());


    }







}
