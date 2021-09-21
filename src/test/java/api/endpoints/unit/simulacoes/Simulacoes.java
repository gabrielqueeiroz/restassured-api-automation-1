package api.endpoints.unit.simulacoes;

import java.util.HashMap;
import java.util.List;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Simulacoes {
    public static int myId;

    //[POST] Insere elemento Teste Sicredi
    @Test(priority = 1)
    public void novaSimulacao() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Sicredi");
        data.put("cpf", "97093999999");
        data.put("email", "email@email.com");
        data.put("valor", "1200");
        data.put("parcelas", "3");
        data.put("seguro", "true");

        String url = "http://localhost:8080/api/v1/simulacoes";

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post(url)
                .then()
                .statusCode(201)
                .body("nome", equalTo("Teste Sicredi"))
                .body("cpf", equalTo("97093999999"))
                .body("email", equalTo("email@email.com"))
                .body("valor", equalTo(1200))
                .body("parcelas", equalTo(3))
                .body("seguro", equalTo(true));
    }

    //[POST] Verifica inserção com o mesmo CPF
    @Test(priority = 2, dependsOnMethods = {"novaSimulacao"})
    public void novaSimulacaoRepetida() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Sicredi");
        data.put("cpf", "97093999999");
        data.put("email", "email@email.com");
        data.put("valor", "1200");
        data.put("parcelas", "3");
        data.put("seguro", "true");

        String url = "http://localhost:8080/api/v1/simulacoes";

        Response res =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .post(url)
                        .then()
                        .statusCode(409)
                        .extract().response();
        String jsonToString = res.asString();
        Assert.assertEquals(jsonToString.contains("CPF já existente"), true);
    }

    //[POST] Verifica e-mail invalido , dependsOnMethods = {"novaSimulacaoRepetida"}
    @Test(priority = 3)
    public void informaEmailInvalido() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Teste");
        data.put("cpf", "97093999");
        data.put("email", "emailemailcom");
        data.put("valor", "1200");
        data.put("parcelas", "3");
        data.put("seguro", "true");

        String url = "http://localhost:8080/api/v1/simulacoes";

        Response res =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .post(url)
                        .then()
                        .statusCode(400)
                        .extract().response();
        String jsonToString = res.asString();
        Assert.assertEquals(jsonToString.contains("E-mail deve ser um e-mail válido"), true);
    }

    //[POST] Verifica numero de parcelas maior que o possível
    @Test(priority = 4)
    public void verificaParcelaMaior() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Sicredi");
        data.put("cpf", "9709399");
        data.put("email", "email@email.com");
        data.put("valor", "1200");
        data.put("parcelas", "300");
        data.put("seguro", "true");

        String url = "http://localhost:8080/api/v1/simulacoes";

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post(url)
                .then()
                .statusCode(400);
    }

    //[PUT] Altera elemento previamente inserido
    @Test(priority = 5, dependsOnMethods = {"novaSimulacao"})
    public void alteraSimulacao() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Sicredi Alterado");
        data.put("cpf", "10101010");
        data.put("email", "alterou@alterou.com");
        data.put("valor", "1800");
        data.put("parcelas", "10");
        data.put("seguro", "false");

        String url = "http://localhost:8080/api/v1/simulacoes/97093999999";

        Response res =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .put(url)
                        .then()
                        .statusCode(200)
                        .extract().response();
        String jsonToString = res.asString();
        Assert.assertEquals(jsonToString.contains("Teste Sicredi Alterado"), true);
    }

    //[PUT] Altera simulacao com dados fora do formato
    @Test(priority = 6)
    public void alteraSimulacaoForaDoFormato() {
        HashMap data = new HashMap();
        data.put("nome", "Claudia123");
        data.put("cpf", "10101010");
        data.put("email", "alteroualterou.com");
        data.put("valor", "string");
        data.put("parcelas", "string");
        data.put("seguro", "verdadeiro");

        String url = "http://localhost:8080/api/v1/simulacoes/10101010";

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put(url)
                .then()
                .statusCode(400);
    }

    //[PUT] Tenta alterar elemento que nao existe na base de dados
    @Test(priority = 7)
    public void alteraSimulacaoNaoExistente() {
        HashMap data = new HashMap();
        data.put("nome", "Teste Sicredi Alterado");
        data.put("cpf", "12345");
        data.put("email", "oioi@oioi.com");
        data.put("valor", "3000");
        data.put("parcelas", "10");
        data.put("seguro", "true");

        String url = "http://localhost:8080/api/v1/simulacoes/12345";
        Response res =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .put(url)
                        .then()
                        .statusCode(404)
                        .log().body()
                        .extract().response();
        String jsonToString = res.asString();
        Assert.assertEquals(jsonToString.contains("CPF " + data.get("cpf") + " não encontrado"), true);
    }

    //[GET] Consulta todas as simulações
    @Test(priority = 8)
    public void consultaTodasSimulacoes() {
        String url = "http://localhost:8080/api/v1/simulacoes";
        Response res =
                given()
                .when()
                    .get(url)
                .then()
                        .log().body()
                    .extract().response();

        int statusCode = res.getStatusCode();
        List jsonToList = res.jsonPath().getList("nome");
        if (statusCode == 200) {
            Assert.assertEquals(jsonToList.contains("Fulano"), true);
        }else{
        Assert.assertEquals(statusCode, equalTo(204));
    }
}

    //[GET] Consulta uma simulação pelo CPF
    @Test(priority = 9)
    public void consultaSimulacaoCPF(){
        String url = "http://localhost:8080/api/v1/simulacoes/10101010";

        myId =
                given()
                .when()
                    .get(url)
                .then()
                    .log().body()
                    .statusCode(200)
                    .body("nome", equalTo("Teste Sicredi Alterado"))
                    .body("cpf", equalTo("10101010"))
                    .body("email", equalTo("alterou@alterou.com"))
                    .body("valor", equalTo(1200.0f))
                    .body("parcelas", equalTo(10))
                    .body("seguro", equalTo(false))
                    .extract().path("id");
//        myId = res.then().contentType("application/json").extract().path("id");
    }
    //[DELETE] Remove elemento previamente adicionado
    @Test(priority = 10, dependsOnMethods = {"consultaSimulacaoCPF"})
    public void removeSimulacaoCPF(){
        String url = "http://localhost:8080/api/v1/simulacoes/"+myId;

        Response res =
                given()
                .when()
                    .delete(url)
                .then()
                    .extract().response();

        int statusCode = res.getStatusCode();
        String jsonToString = res.toString();

        if(statusCode == 404) {
            Assert.assertEquals(jsonToString.contains("Simulação não encontrada"), true);
        }else {
            Assert.assertEquals(statusCode, equalTo(204));
        }
    }
}
