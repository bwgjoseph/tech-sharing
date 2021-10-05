<span style="color:cadetblue">Can talk a little about Spring Cloud Gateway and Spring Webflux?</span>

<span style="color:cadetblue">Spring cloud cannot be used with spring web because spring cloud gateway runs on top of Netty and requires webflux. Not really sure how Netty and Webflux come in for the case of Spring Cloud</span>

---

- Referring back to the [Spring Web diagram](http://localhost:8000/#/10/9)
- Basically, it's just how they design and wrote SCG
- Traditionally, SCG is deployed as standalone, and doesn't matter if it's built using netty and all
- See [scg-github](https://github.com/spring-cloud/spring-cloud-gateway/issues/1004)