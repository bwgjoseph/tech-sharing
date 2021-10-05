```java
@Configuration
public class PriceConfiguration {
    @Bean(initMethods = "init", destroyMethod = "destroy")
    public PricingService ps() {
        return new PricingService(pv());
    }
}
```
