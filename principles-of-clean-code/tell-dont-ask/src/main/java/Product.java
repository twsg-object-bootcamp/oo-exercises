import java.math.BigDecimal;

public class Product {
    private final String name;
    private final Category category;
    private final BigDecimal price;

    public Product(String name, Category category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (category != product.category) return false;
        return price.equals(product.price);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + price.hashCode();
        return result;
    }
}
