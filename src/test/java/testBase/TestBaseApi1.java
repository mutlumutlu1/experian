package testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class TestBaseApi1 {

    protected RequestSpecification spec01;

    @Before
    public void setup(){

        spec01=new RequestSpecBuilder().
                setBaseUri("https://regres.in/api/users").
                build();

    }

}