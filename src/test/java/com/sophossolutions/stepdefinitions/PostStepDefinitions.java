package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.models.User;
import com.sophossolutions.tasks.DeleteMethod;
import com.sophossolutions.tasks.PostMethod;
import com.sophossolutions.utilities.ConvertToJSon;
import com.sophossolutions.utilities.MsgError;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Before;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PostStepDefinitions {
    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^\"([^\"]*)\" create a user with the post method in \"([^\"]*)\"$")
    public void janCreateAUserWithThePostMethodIn(String actorName, String baseUrl) {
        theActorCalled(actorName).whoCan(CallAnApi.at(baseUrl));
    }

    @When("^provide information the post method with \"([^\"]*)\"$")
    public void candidateProvideInformationThePostMethodWith(String service, Map<String, String> dataTable) {
        theActorInTheSpotlight().attemptsTo(PostMethod.createUser(service, ConvertToJSon.convetToJson(dataTable)));

    }

    @Then("^visualize the status (\\d+) of service \"([^\"]*)\"$")
    public void visualizeTheStatusOfService(int code, String service) {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.statusCode(code))
                        .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));

        User user = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("data", User.class);
        theActorInTheSpotlight().attemptsTo(DeleteMethod.delete(service, user.getId()));
    }


}