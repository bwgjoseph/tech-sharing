```java
@Service
public class PricingService implements InitializingBean {
    private final ProductVerifier productVerifier;

    public PricingService(ProductVerifier productVerifier) {
        this.productVerifier = productVerifier;
    }

    @PostConstruct
    public void postConstruct() {
        // triggered first
        // do some initialization work
    }

    @Override
    public void afterPropertiesSet() {
        // triggered second
        // do some initialization work
    }

    public void init() {
        // Have to declare via `@Bean(initMethod = "init")`
        // triggered third
        // do some initialization work
    }

    @PreDestroy
    public void beforeBeanDestroy() {
        // triggered fourth
        // think as a intercepter before Bean gets destroyed
    }

    public void destroy() {
        // Have to declare via `@Bean(destroyMethod = "destroy")`
        // triggered last
        // do some destruction work
    }
}
```

<p align="left"><u>@PostConstruct</u> and <u>@PreDestroy</u> are more commonly used compared to <u>init</u> and <u>destroy</u> method</p>