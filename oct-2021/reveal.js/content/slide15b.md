Prefer @ConfigurationProperties if injecting multiple @Value

```java
@ConfigurationProperties("my.app.service")
@Validated
public class MyProperties {

    private boolean enabled;
    private final Security security = new Security();

    public static class Security {
        @NotEmpty
        private String userName;
        @Size(min = 5)
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}
```

```log
my.app.service.enabled=true
my.app.service.security.user-name=joseph
my.app.service.security.password=pw
my.app.service.security.roles=user,admin
```