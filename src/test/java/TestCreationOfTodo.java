import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreationOfTodo {
    @Test
    public void shouldCreateTodoWithoutProvidingStatus(){
        CreateTodoResponse response = given()
                .baseUri("http://localhost:8080/v1")
                .contentType(ContentType.JSON)
                .body(new CreateTodoRequest("Bring Milk",null))
        .when()
                .post("/todo")
        .then()
                .statusCode(201)
                .extract()
                .body()
                .as(CreateTodoResponse.class);

        assertEquals(response.title(),"Bring Milk");
    }
}
