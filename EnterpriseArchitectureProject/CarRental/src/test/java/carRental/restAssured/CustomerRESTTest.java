package carRental.restAssured;

import carRental.domain.Customer;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
//import static org.apache.commons.codec.digest.UnixCrypt.body;
import static org.hamcrest.CoreMatchers.*;
public class CustomerRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8082);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";

    }

    @Test
    public void testGetOneCustomer() {
        // add the book to be fetched
        Customer customer1  =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
       // Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(customer1)
                .when().post("/customers").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("customers/12")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("customerNumber",equalTo("12"))
                .body("fullName",equalTo("baba kaka"))
                .body("email",equalTo("b@gmail.com"))
                .body("points",equalTo(20))
                .body("status",equalTo("Gold"));


        //cleanup
        given()
                .when()
                .delete("customers/12");
    }

    @Test
    public void testDeleteCustomer() {
        // add the book to be deleted
        //Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        Customer customer1  =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");

        given()
                .contentType("application/json")
                .body(customer1)
                .when().post("/customers").then()
                .statusCode(200);

        given()
                .when()
                .delete("customers/12");

        given()
                .when()
                .get("customers/12")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Customer with customerNumber= 12 is not available"));
    }


}
