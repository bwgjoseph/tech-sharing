<span style="color:cadetblue">We cannot inject values from application.properties into static fields. Should we use setter method to initialise the value, or should this not be a static field (assuming it is a component which is singleton).</span>

---

- In short, do not use static field
- Need use case of when you think you will need it