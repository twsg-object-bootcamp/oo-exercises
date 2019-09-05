import java.math.BigDecimal;
import java.util.List;

public class PromoCode {
    private final BigDecimal discountRate;
    private final List<Category> excludedCategories;

    public PromoCode(BigDecimal discountRate, List<Category> excludedCategories) {
        this.discountRate = discountRate;
        this.excludedCategories = excludedCategories;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public List<Category> getExcludedCategories() {
        return excludedCategories;
    }
}
