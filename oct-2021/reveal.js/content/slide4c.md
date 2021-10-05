It is a collection of Beans (classes), instantiated, assembled and managed by Spring IoC Container

```java
public class PricingService {
    private final ProductVerifier productVerifier;

    public PricingService(ProductVerifier productVerifier) {
        this.productVerifier = productVerifier;
    }

    public BigDecimal calculatePrice(String productName) {
        if (productVerifier.isCurrentlyInStockOfCompetitor(productName)) {
        return new BigDecimal("99.99");
    }

        return new BigDecimal("149.99");
    }
}

public class ProductVerifier {
    public boolean isCurrentlyInStockOfCompetitor(String productName) {
        return false;
    }
}

// Also known as the Configuration Metadata
@Configuration
class ApplicationConfig {
    // instruction on how this bean should be setup
    @Bean
    public ProductVerifier pv() {
        return new ProductVerifier();
    }

    @Bean
    public PricingService ps() {
        return new PricingService(pv());
    }
}
```
