import java.math.BigDecimal;

public class DiscountService {
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart, PromoCode promoCode) {
        BigDecimal totalDiscountableValue = BigDecimal.ZERO;
        for (Product product : shoppingCart.getItems().keySet()) {
            if (!promoCode.getExcludedCategories().contains(product.getCategory())) {
                BigDecimal quantity = BigDecimal.valueOf(shoppingCart.getItems().get(product));
                BigDecimal productValue = product.getPrice().multiply(quantity);
                totalDiscountableValue = totalDiscountableValue.add(productValue);
            }
        }

        return promoCode.getDiscountRate().multiply(totalDiscountableValue);
    }
}
