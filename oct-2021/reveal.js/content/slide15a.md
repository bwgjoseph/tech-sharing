Prefer [Constructor Injection](https://stackoverflow.com/questions/19381846/why-use-constructor-over-setter-injection-in-cdi) over field and setter

```java
@Service
public class UserService {
    // set to final
    // @Autowired not required
    private final UserRepository userRepository;

    // @Autowired not required
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

Use setter based injection for optional dependency
Never use field based injection!