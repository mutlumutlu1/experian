package dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Api {

    @Given("existing Server application https:\\/\\/reqres.in\\/api")
    public void existingServerApplicationHttpsReqresInApi() {

    }

    @Then("on GET request to\\/users it returns expected users list")
    public void onGETRequestToUsersItReturnsExpectedUsersList() {
    }

    @Then("on GET request to\\/users\\/{int} it returns expected welcome message")
    public void onGETRequestToUsersItReturnsExpectedWelcomeMessage(int arg0) {
    }

    @Then("on GET request to\\/users\\/{int} it returns {int} status code")
    public void onGETRequestToUsersItReturnsStatusCode(int arg0, int arg1) {
    }




}
