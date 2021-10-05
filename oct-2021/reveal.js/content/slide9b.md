Advice (Think like a hook of sort)

- Before advice
- Around advice
- After returning advice
- After throwing advice
- After (finally) advice

---

Format of execution expression:

- execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)

Example

```java
execution(public * *(..)) // execution of any public method
execution(* set*(..)) // execution of any method with a name that begins with set
execution(* com.xyz.service.*.*(..)) // execution of any method defined in the service package
```