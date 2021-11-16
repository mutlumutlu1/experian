package testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class TestBaseApi3 {

    protected RequestSpecification spec03;

    @Before
    public void setup(){

        spec03=new RequestSpecBuilder().
                setBaseUri("https://regres.in/api/users/23").
                build();

    }

}