- Build standalone and production ready Spring application
- Mostly just auto-configuration
  - Detects if certain class is in the classpath, and autoconfigure the Beans required
- Bootstrap everything for you via @SpringBootApplication
  - @EnableAutoConfiguration
  - @ComponentScan
  - @Configuration

---

- Reduce boilerplate codes
  - Configure Datasource
  - Configure Message Broker
  - Configure Webserver
  - Configure Spring Security, ...
