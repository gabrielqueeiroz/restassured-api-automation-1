package api.endpoints.unit.restricoes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import java.util.List;

public class Restricoes {
    @Test
    public void consultaRestricao(){
        String url = "http://localhost:8080/api/v1/restricoes/";
        List<String> values = new ArrayList<String>();
        values.add("97093236014");
        values.add("26276298085");
        values.add("01317496094");
        values.add("55856777050");
        values.add("19626829001");
        values.add("24094592008");
        values.add("58063164083");
        values.add("62648716050");
        values.add("84809766080");
        values.add("60094146012");

        //Primeiro elemento
        given()
        .when()
                .get(url+values.get(0))
        .then()
                .statusCode(200)
                .assertThat()
                .body("mensagem", equalTo("O CPF "+values.get(0)+" tem problema"));

        //Segundo elemento
        given()
        .when()
            .get(url+values.get(1))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(1)+" tem problema"));
        //Terceiro elemento
        given()
        .when()
            .get(url+values.get(2))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(2)+" tem problema"));
        //Quarto elemento
        given()
        .when()
            .get(url+values.get(3))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(3)+" tem problema"));
        //Quinto elemento
        given()
        .when()
            .get(url+values.get(4))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(4)+" tem problema"));
        //Sexto elemento
        given()
        .when()
            .get(url+values.get(5))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(5)+" tem problema"));
        //Sétimo elemento
        given()
        .when()
            .get(url+values.get(6))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(6)+" tem problema"));
        //Oitavo elemento
        given()
        .when()
            .get(url+values.get(7))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(7)+" tem problema"));
        //Nono elemento
        given()
        .when()
            .get(url+values.get(8))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(8)+" tem problema"));
        //Décimo elemento
        given()
        .when()
            .get(url+values.get(9))
        .then()
            .statusCode(200)
            .assertThat()
            .body("mensagem", equalTo("O CPF "+values.get(9)+" tem problema"));
    }

    @Test
    public void consultaNaoRestricao(){
        String url = "http://localhost:8080/api/v1/restricoes/";
        given()
        .when()
            .get(url+"99999999999")
        .then()
            .assertThat()
            .statusCode(204);

    }

    // Extract
//    List<Map<String, Object>> products = get("/products").as(new TypeRef<List<Map<String, Object>>>() {});

    // Now you can do validations on the extracted objects:
//    assertThat(products, hasSize(2));
//    assertThat(products.get(0).get("id"), equalTo(2));
//    assertThat(products.get(0).get("name"), equalTo("An ice sculpture"));
//    assertThat(products.get(0).get("price"), equalTo(12.5));
//    assertThat(products.get(1).get("id"), equalTo(3));
//    assertThat(products.get(1).get("name"), equalTo("A blue mouse"));
//    assertThat(products.get(1).get("price"), equalTo(25.5));```

//
//    @Test
//    public void teste_post(){
//        HashMap data = new HashMap();
//        data.put("nome": "Fulano de Tal");
//        data.put("cpf": "97093236014");
//        data.put("email": "email@email.com");
//        data.put("valor": "1200");
//        data.put("parcelas": "3");
//        data.put("seguro": "true");
//
//        String url = "http://localhost:8080/api/v1/simulacoes";
//
//        Response res =
//                given()
//                    .contentType("application/json")
//                    .body(data)
//                .when()
//                    .post(url)
//                .then()
//                    .statusCode(200)
//                        .log().body()
//                        .extract().response();
//        String jsonString = res.asString();
//
//        Assert.assertEquals(jsonString.contains("mensagem"), true);
//    }
}
