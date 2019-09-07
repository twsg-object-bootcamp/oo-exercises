import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertThat;

public class DiscountServiceTest {

    private DiscountService discountService = new DiscountService();

    @Test
    public void shouldApplyDiscountOnTotalValueOfTheShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN), 1);
        shoppingCart.addItem(new Product("Nintendo Switch", Category.GAMING_CONSOLE, BigDecimal.ONE), 5);
        PromoCode promoCode = new PromoCode(BigDecimal.valueOf(0.1), emptyList());

        BigDecimal discount = discountService.calculateDiscount(shoppingCart, promoCode);

        assertThat(BigDecimal.valueOf(1.5), Matchers.comparesEqualTo(discount));
    }

    @Test
    public void shouldIgnoreProductsBelongToExcludedCategoriesInTheShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("iPhone", Category.MOBILE_PHONE, BigDecimal.TEN), 1);
        shoppingCart.addItem(new Product("Grab Car $3 OFF", Category.VOUCHER, BigDecimal.ONE), 5);
        PromoCode promoCode = new PromoCode(BigDecimal.valueOf(0.1), singletonList(Category.VOUCHER));

        BigDecimal discount = discountService.calculateDiscount(shoppingCart, promoCode);

        assertThat(BigDecimal.valueOf(1), Matchers.comparesEqualTo(discount));
    }
}