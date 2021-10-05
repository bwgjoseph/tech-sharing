Drop ResponseEntity response type unless full control is required

```java
// instead of
@RestController
public class UserController {
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return new ResponseEntity.ok(user);
    }
}

// use this
@RestController
public class UserController {
    @PostMapping("/user")
    public User createUser(@RequestBody @Valid User user) {
        return user;
    }
}

// or this
@RestController
public class UserController {
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) { }
}
```