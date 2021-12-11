package TestesAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class LoginTest {
    String url;

    @BeforeEach
    public void setUp(){
        url = "https://serverest.dev/";
    }

    @Test
    public void testLoginSucesso(){

        given().
                contentType("application/json")
                .log().all()
                .body("{\n" +
                        "  \"email\": \"fulano@qa.com\",\n" +
                        "  \"password\": \"teste\"\n" +
                        "}")
        .when()
                .post(url+"login")
        .then()
                .statusCode(200)
                .body("message",is("Login realizado com sucesso"));
    }

    @Test
    public void testLoginTokenExpirou(){
        given().
                contentType("application/json")
                .log().all()
                .body("{\n" +
                        "  \"email\": \"lucas@qa.com\",\n" +
                        "  \"password\": \"teste321\"\n" +
                        "}")
        .when()
                .post(url+"login")
        .then()
            .statusCode(401);
            //.body("message",is("Email e/ou senha inválidos"));
    }

}
