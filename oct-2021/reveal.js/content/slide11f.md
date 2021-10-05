##### Calling Rest Service

```java
@Service
public class MyService {
    // In maintenance mode, use WebClient instead
    private final RestTemplate restTemplate;

    // Always use RestTemplateBuilder
    public MyService(RestTemplateBuilder restTemplateBuilder) {
        // builder allows further customization such as Auth
        this.restTemplate = restTemplateBuilder.basicAuthentication("user", "password").build();
    }

    public Details someRestCall(String name) {
        return this.restTemplate.getForObject("/{name}/details", Details.class, name);
    }
}

// Configure once for application wide use
@Configuration(proxyBeanMethods = false)
public class MyRestTemplateBuilderConfiguration {

    @Bean
    public RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        return configurer.configure(new RestTemplateBuilder()).setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(2));
    }

}
```