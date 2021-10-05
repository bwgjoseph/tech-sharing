<span style="color:cadetblue">Mostly only encountered beans with default scope of singleton. What are some examples of using other scopes e.g. Prototype? How does the spring container handle such scopes (since singleton is just caching such the beans?)</span>

---

- The different type of bean scope are
  - Singleton, Prototype, Request, Session, Websocket, Application
  - See [guide](https://www.baeldung.com/spring-bean-scopes) for detailed explanation
- Most people (I think) don't use prototype because you can simply call `new User()`
- Using `prototype` scope means allowing Spring to manage the lifecycle for you but unsure of the actual benefit
- See [docs](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-prototype)