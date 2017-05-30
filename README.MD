# 

## HATEOAS
Spring docs: [hateoas](http://docs.spring.io/spring-hateoas/docs/0.23.0.RELEASE/reference/html/)
### Resources
You can create Resources in multiple ways
#### With existing entity

Wrap the entity (a wrapper resource)
```java

public class BookResource extends ResourceSupport {
    
    private final Book book;
    
    public BookResource(Book book){
        this.book = book;
    }
    
    public Book getBook(){
        return book;
    }

}

```

Even a better wrapper method
```java
public class BookResource extends Resource<Book> {
    
    public BookResource(Book book){
        super(book);
    }

}
```
#### From scratch

```java

public class modelResource extends ResourceSupport {
    
    //fields of resource
    
    //Constructor with fields
    
    // getters and setters
}
```




### Filtering fields of entities (not Projection from Spring)
I do not know if the following two annotations can be used on the same entity

#### @JsonView (This is defined from the developers side)
Create a view class with possible views
```java
public class BoardgameView {

    public interface Summary{};

}
```
Add corresponding annotation on the fields of the resource that should be shown and add it on the controller method that should return that view
```java
public class BoardgameResource extends ResourceSupport {
    @JsonView(BoardgameView.Summary.class)
    private String bggId;
    
}

```

#### #JSONFilter (This is a way that the client can say wich fields it wants returned)

You need to create a SimpleFilterProvider to tell Jackson what should be parsed and returned (in a MappingJacksonValue).
Annotate the getter of the wrapped entity with the correct filter "@JsonFilter("boardgameFilter")"

```java
public class BoardgameController {
    @GetMapping(value = "/jacksonMapper", params = "fields")
    public MappingJacksonValue getAllFilteredByJackson(@RequestParam String fields){

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
                "boardgameFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

        MappingJacksonValue wrapper = new MappingJacksonValue(boardgameResourceAssembler.toResources(boardgameService.findAll()));
        wrapper.setFilters(filterProvider);
        return wrapper;
    }
}
```
