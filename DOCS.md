# 📁 Spring Boot Project Structure Overview

```text
src/
├── main/
│   ├── java/com/froilan/twitter/
│   │   ├── config/        -> App-wide configurations (MongoDB, CORS, etc.)
│   │   ├── controller/    -> REST controllers (like Flask routes)
│   │   ├── dto/           -> Data Transfer Objects (request/response models)
│   │   ├── exception/     -> Custom exceptions and handlers
│   │   ├── model/         -> Domain models (MongoDB documents/schemas)
│   │   ├── repository/    -> MongoDB interfaces (equivalent to Flask DB access)
│   │   ├── service/       -> Business logic layer (equivalent to Flask's service.py)
│   │   └── util/          -> Helpers/utilities (token generation, etc.)
│   └── resources/
│       ├── static/        -> Static files (HTML, CSS, JS if needed)
│       ├── templates/     -> Thymeleaf templates (not often used in REST APIs)
│       └── application.properties / application.yml -> Config settings
```

---

## 🔍 Detailed Mapping (Spring Boot vs. Flask)

| Flask Component                | Spring Boot Equivalent                          | Directory Location |
| ------------------------------ | ----------------------------------------------- | ------------------ |
| `@app.route()` view functions  | `@RestController` classes + `@GetMapping`, etc. | `controller/`      |
| `models.py`                    | MongoDB model classes with `@Document`          | `model/`           |
| `db.session.query()`           | `MongoRepository` interfaces                    | `repository/`      |
| `service.py` or business logic | `@Service` classes for logic abstraction        | `service/`         |
| `schemas.py` or validation     | `@Validated` DTOs with `@NotNull`, etc.         | `dto/`             |
| `app.config[]`                 | `application.properties` or `application.yml`   | `resources/`       |
| `errorhandler()` decorators    | `@ControllerAdvice` with custom exceptions      | `exception/`       |
| Utilities (e.g., JWT, hashing) | Plain Java classes or `@Component` beans        | `util/`            |

---

## 🔧 What Goes Where: File-Level Clarification

### 🔹 `model/` – MongoDB Documents

```java
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private String authorId;
    private String content;
    private Date createdAt;

    // + Lombok @Getter, @Setter
}
```

> Like Flask’s `models.py`, these define your schema.

---

### 🔹 `repository/` – Spring Data Repositories

```java
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthorId(String authorId);
}
```

> Comparable to Flask's use of SQLAlchemy queries or direct PyMongo usage.

---

### 🔹 `controller/` – REST Endpoints

```java
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }
}
```

> Like Flask routes using `@app.route()`.

---

### 🔹 `service/` – Business Logic

```java
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(PostDTO dto) {
        Post post = new Post();
        post.setContent(dto.getContent());
        post.setAuthorId(dto.getAuthorId());
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }
}
```

> Similar to Flask functions that encapsulate reusable logic.

---

### 🔹 `dto/` – Data Transfer Objects

```java
public class PostDTO {
    @NotBlank
    private String content;

    @NotBlank
    private String authorId;
}
```

> Comparable to `pydantic` models or Marshmallow schemas for request validation.

---

### 🔹 `config/` – MongoDB Configuration (if needed)

```java
@Configuration
public class MongoConfig {
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {
        return new MongoTemplate(factory);
    }
}
```

> Optional, especially if using auto-config with `application.properties`.

---

### 🔹 `exception/` – Custom Errors

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}
```

> Equivalent to Flask's `abort(404, description="...")`.

---

## 🧪 Testing Structure

```text
src/test/java/com/froilan/twitter/
```

This is where you put your unit tests and integration tests using:

* **JUnit** (test framework)
* **Mockito** (mocking dependencies)
* **SpringBootTest** for context loading

---

## 📝 Configuration Example: `application.properties`

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/twitter
spring.data.mongodb.database=twitter

server.port=8080
spring.jackson.date-format=yyyy-MM-dd'T'HH:mm:ss.SSSZ
```

---

## 💭 Final Thoughts

Your directory structure is textbook-clean and mirrors **Domain-Driven Design (DDD)** principles. Spring Boot offers a rigorous separation of concerns, yet it's modular enough to let you scale it like a microservice. If you’re coming from Flask, think of this as Flask + Blueprints + SQLAlchemy + Marshmallow + Service Layer—all in one, with more rigidity.

Would you like me to generate a starter REST API with one sample `User` and `Post` feature wired from model to controller using MongoDB? That way you could scaffold from a working base.
