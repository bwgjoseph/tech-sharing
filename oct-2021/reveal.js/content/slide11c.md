##### Profiles

```yaml
// allow for multiple active profile
spring.profiles.active=dev,production
```

```java
@Configuration
@Profiles("dev")
public class DevConfiguration { }

@Configuration
@Profiles("production")
public class ProductionConfiguration { }
```

<p align="left">Can override</p>

- via command line with <u>--spring.profiles.active=dev</u>
- via env var <u>SPRING_PROFILES_ACTIVE=dev</u>