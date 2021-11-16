package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import testBase.TestBaseApi1;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-raporlar2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},

        features="src/test/resources/features",
        glue="dbStepdefinitions",

        tags="@rapor",

        dryRun=true


)




public class DbRunner1 extends TestBaseApi1 {
    @Test
    public void test1(){

        spec01.pathParams("parameter1","booking","parameter2",5);

        Response response=given().
                accept("application/json").
                spec(spec01).
                when().
                get("/{parameter1}/{parameter2}");

        response.prettyPrint();




        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


        JsonPath json=response.jsonPath();

        Assert.assertEquals(1,json.getInt("id"));
        Assert.assertEquals("george.bluth@reqres.in",json.getString("email"));
        Assert.assertEquals("George",json.getString("firstname"));
        Assert.assertEquals("Bluth",json.getString("lastname"));
        Assert.assertEquals("https://reqres.in/img/faces/1-image.jpg",json.getString("avatar"));

        Assert.assertEquals(2,json.getInt("id"));
        Assert.assertEquals("janet.weaver@reqres.in",json.getString("email"));
        Assert.assertEquals("Janet",json.getString("firstname"));
        Assert.assertEquals("Weaver",json.getString("lastname"));
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg",json.getString("avatar"));

        Assert.assertEquals(3,json.getInt("id"));
        Assert.assertEquals("emma.wong@reqres.in",json.getString("email"));
        Assert.assertEquals("Emma",json.getString("firstname"));
        Assert.assertEquals("Wong",json.getString("lastname"));
        Assert.assertEquals("https://reqres.in/img/faces/3-image.jpg",json.getString("avatar"));

        Assert.assertEquals(4,json.getInt("id"));
        Assert.assertEquals("eva.holt@reqres.in",json.getString("email"));
        Assert.assertEquals("Eva",json.getString("firstname"));
        Assert.assertEquals("Holt",json.getString("lastname"));
        Assert.assertEquals("https://reqres.in/img/faces/4-image.jpg",json.getString("avatar"));





    }



}