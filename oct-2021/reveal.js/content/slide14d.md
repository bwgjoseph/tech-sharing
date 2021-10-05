<span style="color:cadetblue">Typically what is the right convention to run logic at startup, and what are the considerations (e.g. dependencies, nature of initialisation logic etc): @PostConstruct for specific components, @AfterPropertiesSet ,EventListeners, initMethod, CommandLineRunner/ ApplicationRunner?</span>

---

- I think there's no right convention, it depends on when you want the logic to run
- There is a order to these and also happens at different stage of the lifecycle

See [startup](https://www.baeldung.com/running-setup-logic-on-startup-in-spring)