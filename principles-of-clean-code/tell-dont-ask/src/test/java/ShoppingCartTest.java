import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ShoppingCartTest {
    @Test
    public void addItem_shouldAddNewProductWithTheGivenQuantity() {
        Product product = new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(product, 1000);

        assertEquals(1000, (int) shoppingCart.getItems().get(product));
    }

    @Test
    public void addItem_shouldUpdateQuantityForTheExistingProduct() {
        Product product = new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.getItems().put(product, 1000);

        shoppingCart.addItem(product, 500);

        assertEquals(1500, (int) shoppingCart.getItems().get(product));
    }

    @Test
    public void removeItem_shouldRemoveExistingProduct() {
        Product product = new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.getItems().put(product, 1000);

        shoppingCart.removeItem(product);

        assertFalse(shoppingCart.getItems().containsKey(product));
    }

    @Test
    public void removeItem_shouldDoNothingWithNotExistingProduct() {
        Product product = new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.removeItem(product);

        assertFalse(shoppingCart.getItems().containsKey(product));
    }
}