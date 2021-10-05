<span style="color:cadetblue">What are some use-cases of @Lazy Loading & when to use it?</span>

---

- TLDR; don't unless you know what you are doing

---

- Use when you want the application to startup faster
- Remember that when application starts, Spring will scans for all beans and initialize it
- With `@Lazy`, it will skip during startup, and init only when it's first called
- But, I think the savings in slightly faster startup does not gives alot of benefit as compared to the disadvantage it brings
  - you won't know if the bean creation/init has problem until it is first called during runtime
  - the time saving in application startup defers to the initial request
- See [lazy-initialization](https://springhow.com/lazy-initialization-in-spring-boot/)

---

There's [spring-native](https://spring.io/blog/2021/03/11/announcing-spring-native-beta) anyway, if you want really fast startup

![spring-native](/content/spring-native-startup.png)