Prefer builder pattern

```java
// take advantage of ide intellisense
User user = User.builder()
                .username('joseph')
                .password('helloworld')
                .roles(List.of('engineer'))
                .build();

// easily miss out fields to set
User user = new User();
user.setUsername('joseph');
user.setPassword('helloworld');
user.setRoles(List.of('engineer'));
```