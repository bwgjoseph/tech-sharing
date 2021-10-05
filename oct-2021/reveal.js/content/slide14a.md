<span style="color:cadetblue">What is the main difference in the workings behind @Bean and @Component? It seems that @Bean is commonly used in @Configuration class</span>

---

Let's take a quick look at this [beans-scanning-autodetection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-scanning-autodetection) first

---

<p align="left">Remember that <u>@SpringBootApplication</u> is a consolidated annotation for <u>@EnableAutoConfiguration, @ComponentScan and @Configuration</u></p>

---

<p align="left"><u>@ComponentScan</u> scans for all classes registered below it by default (com.bwgjoseph.app.*)</p>

---

<p align="left">Then it scans for all sterotype annotation such as <u>@Configuration, @Component, @Controller, @Service, @Repository</u> to register the Beans (class) to application context</p>

---

<p align="left"><u>@Component</u> is a generic sterotype annotation, while the rest are specialize sterotype annotation</p>

---

<p align="left">Spring does a little bit more when you annotate a class with <u>@Respository</u> by turning the checked exception into runtime exception</p>

---

<p align="left">When define with <u>@Bean</u> annotation, you are instructing how you want the class to be created [meta-data]</p>

---

<p align="left">Spring picks up <u>@Bean</u> from <u>@Configuration</u> annotated class to register the <u>@Bean</u> to application context</p>
  - You can use XML to configure the beans too!