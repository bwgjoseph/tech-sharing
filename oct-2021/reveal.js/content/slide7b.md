```java
// Specify Bean
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

public class UserService {
    public boolean valid() {
        // setup
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // init User bean (new User())

        // validate
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // get errors
        for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
    }
}
```