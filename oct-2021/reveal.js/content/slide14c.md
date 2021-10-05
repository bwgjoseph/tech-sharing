<span style="color:cadetblue">What goes behind @Autowired</span>

- Maybe can also talk about bean lifecycle
- @Autowired and @Bean
    - Saw something on [stackoverflow](https://stackoverflow.com/questions/32078600/why-do-i-not-need-autowired-on-bean-methods-in-a-spring-configuration-class) and I am not very sure what distinguish the “outside” and “context” world:

> @Autowire lets you inject beans from context to "outside world" where outside world is your application. Since with @Configuration classes you are within "context world ", there is no need to explicitly autowire (lookup bean from context).

---

- Refer back to the [lifecycle diagram](http://localhost:8000/#/4/2)
- I believe what the author meant
  - **within** is the <u>Initialization</u> phase of the lifecycle, whereas,
  - **outside world** refers to the <u>Use</u> phase
- Why do you not need to explicitly call <u>@Autowired in B bean</u> then?
  - Spring resolve that automatically for you
  - See [docs](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-bean-annotation)