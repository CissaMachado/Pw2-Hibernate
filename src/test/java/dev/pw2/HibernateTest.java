package dev.pw2;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class HibernateTest {

    @Test
    @Order(1)
    public void addUser() {
        given().when().get("/user/save/Fulano").then().statusCode(200);
    }

    @Test
    @Order(2)
    public void addChannel() {
        given().when().get("/channel/save/abc").then().statusCode(200);
    }

    @Test
    @Order(3)
    public void addMessage() {
        given().when().get("/message/save/my message/1").then().statusCode(200);
    }

    @Test
    @Order(4)
    public void addMessageError() {
        given().when().get("/message/save/my message/0").then().statusCode(400);
    }

    @Test
    @Order(5)
    public void addCHannelError() {
        given().when().get("/channel/add/0/0").then().statusCode(400);
    }

}