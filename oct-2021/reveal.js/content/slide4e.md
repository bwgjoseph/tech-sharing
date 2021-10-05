##### Dependency Injection (DI)

```java
// PricingService only indicates it needs a certain Bean
// But has no control over where it comes from
// Spring as the IoC Container will inject automatically
@Service
public class PricingService {
    private final ProductVerifier productVerifier;

    // via Constructor Injection (recommended)
    public PricingService(ProductVerifier productVerifier) {
        this.productVerifier = productVerifier;
    }

    // or setter injection (ok for optional dependency)
    public void setProductVerifier(ProductVerifier productVerifier) {
        this.productVerifier = productVerifier;
    }

    // via field injection (never do this!)
    @Autowired
    private ProductVerifier productVerifier;
}
```

<p align="left">DI means you request the object (bean) from IoC container</p>