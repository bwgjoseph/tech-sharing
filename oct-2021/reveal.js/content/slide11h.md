##### Spring Data

- Supports a wide range of SQL and NoSQL databases
  - Wide range from either the core, or community supported
- [Derived Query](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.declared-queries)
- Providing familiar programming model for both type of database

```java
@Respository
public class UserRespository extends CrudRepository<User, Long> {}
public class UserRespository extends PagingAndSortingRepository<User, Long> {}
```