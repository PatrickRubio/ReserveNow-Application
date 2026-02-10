# Copilot / AI Agent Instructions for ReserveNow 🧭

Quick overview
- Small Spring Boot backend (Spring Boot 3.3.3, Java 21).
- Single-module Maven project: see `pom.xml` (core dependencies: web, data-jpa, validation, actuator).
- Runtime DB: PostgreSQL configured in `src/main/resources/application.properties`.

Essential commands
- Build (wrapper): `./mvnw clean package` (Windows: `mvnw.cmd`)
- Run (dev): `./mvnw spring-boot:run`
- Run packaged JAR: `java -jar target/reservenow-*.jar`
- Tests: `./mvnw test`
- Build OCI image: `./mvnw spring-boot:build-image` (see `HELP.md` links)

Project layout & important files
- `src/main/java/com/reservenow` — application sources and main Spring Boot entry (`ReserveNowApplication.java`).
- `src/main/resources/application.properties` — DB and JPA configuration (Postgres host/creds, `spring.jpa.hibernate.ddl-auto=update`).
- `pom.xml` — Java 21, Spring Boot starters, runtime Postgres dependency, Lombok optional, and `spring-boot-maven-plugin`.
- `src/test/java` — test location; current template test (`com.example.demo.DemoApplicationTests`) is from scaffold **and does not match** the app package (`com.reservenow`). Prefer placing tests under `com.reservenow`.
- `HELP.md` — contains reference links for build/image/migrations/actuator.

Project-specific guidance for code generation
- Package root: use `package com.reservenow` for new classes (controllers, services, repositories, DTOs). Keep package hierarchy under this root.
- Persistence: project uses Spring Data JPA. Add `@Entity` classes and `JpaRepository` interfaces under `src/main/java/com/reservenow/*`.
- Schema: currently `spring.jpa.hibernate.ddl-auto=update` (development usage). For production-grade changes prefer adding explicit migrations (Flyway or Liquibase) rather than relying on `update`.
- Controllers: add REST controllers (`@RestController`) under `com.reservenow.web` (suggested). Use `@Validated` for request validation and `@ResponseStatus` or `@ExceptionHandler` for mapping errors consistently.

Testing & conventions
- Use `@SpringBootTest` for integration tests and `MockMvc` or `@WebMvcTest` for controller unit tests.
- Place tests under `src/test/java/com/reservenow` to match component scanning and package visibility.
- Use the existing test dependency (`spring-boot-starter-test`) and JUnit 5 (`jupiter`).

Environment & local DB usage
- `application.properties` points to `jdbc:postgresql://localhost:5432/reservenow` with user `postgres` and password `Olowalu`. Override credentials via environment variables or externalized `application-*.properties` for local development.
- Typical local Postgres (docker) example (adapt creds, do NOT commit secrets):
  `docker run --name reservetest -e POSTGRES_PASSWORD=Olowalu -e POSTGRES_DB=reservenow -p 5432:5432 -d postgres:15`

Actuator & debugging
- Actuator is included; use `/actuator/health` and `/actuator/info` endpoints for readiness/health checks.
- Enable additional actuator endpoints or secure them when adding security.

Notable issues & suggestions for agents
- There is a package mismatch in tests (`com.example.demo` != `com.reservenow`). If you add or modify tests, move or create tests under `com.reservenow`.
- Security starter is currently commented out — if adding authentication/authorization, enable and follow Spring Security best practices.
- Lombok is present as an optional dependency; generated code should avoid depending on Lombok in public APIs unless the team uses it consistently.

When making Pull Requests
- Keep changes scoped and include unit/integration tests for new behavior.
- Update `HELP.md` when you add new developer-facing tasks or commands.

Examples (short)
- Add a controller:
```java
package com.reservenow.web;
@RestController
@RequestMapping("/api/bookings")
public class BookingController { /* endpoints here */ }
```
- Add a JPA repository:
```java
package com.reservenow.repo;
public interface BookingRepository extends JpaRepository<Booking, Long> {}
```

If anything in this file is unclear or you'd like more examples (tests, controller templates, migration setup), say so and I will iterate. ✅