package testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class TestBaseApi2 {

    protected RequestSpecification spec02;

    @Before
    public void setup(){

        spec02=new RequestSpecBuilder().
                setBaseUri("https://regres.in/api/users/2").
                build();

    }

}