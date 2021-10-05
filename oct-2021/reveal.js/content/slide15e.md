Apply DTO Model Pattern

```java
// used in @Controller
public class UserDTO {
    // contains extra stuff for client-server communcation
}

// used in service and below
public class UserEntity {
    // contains stuff for server-db communication
}
```