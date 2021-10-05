Trigger validation at @Controller via @Valid and @Validated

```java
public class User {
    // multiple assertion per field
    @NotNull
    // custom message
    @Size(min = 5, message = "username to be at least 5 characters")
    public String username;
    @Positive(message = "age cannot be lesser than 0")
    public int age;
    @Email
    public String email;
    @Past
    public Date dateOfBirth;
    @FutureOrPresent
    public Date lastUpdated;
}

@RestController
public class UserController {
    @PostMapping("/user")
    public User createUser(@Valid User user) {
        // omitted
    }
}
```