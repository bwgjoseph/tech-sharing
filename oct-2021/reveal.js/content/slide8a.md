```java
// https://www.baeldung.com/spring-expression-language

// support Arithmetic Operators
@Value("#{19 + 1}") // 20
private double add;

// support Relational and Logical Operators
@Value("#{1 == 1}") // true
private boolean equal;

// support Logical Operators
@Value("#{400 > 300 || 150 < 100}") // true
private boolean or;

// support Conditional Operators
@Value("#{2 > 1 ? 'a' : 'b'}") // "a"
private String ternary;

// support Regex
@Value("#{'100' matches '\\d+' }") // true
private boolean validNumericStringResult;

// support accessing List and Map Objects
@Value("#{workersHolder.salaryByWorkers['John']}") // 35000
private Integer johnSalary;
```

Supports querying and manipulating object at runtime
