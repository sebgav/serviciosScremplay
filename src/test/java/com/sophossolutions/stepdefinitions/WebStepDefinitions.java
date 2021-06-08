package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.questions.ElTexto;
import com.sophossolutions.tasks.Add;
import com.sophossolutions.tasks.BuyProduct;
import com.sophossolutions.utilities.MsgError;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.containsString;

public class WebStepDefinitions {

    private Actor Ham = Actor.named("Ham");
    WebDriver driver;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        Ham.can(BrowseTheWeb.with(driver));
    }

    @Given("^Candidate select the category tecnology")
    public void candidateSelectTheCategoryTecnology() {
        theActorCalled("Ham").attemptsTo(BuyProduct.buy());
    }


    @When("^Add to shopping cart the (.*)$")
    public void addToShoppingCartThe(String audi) {
        theActorCalled("Ham").attemptsTo(Add.toCart(audi));
    }

    @Then("^Check if the product was added to the cart (.*)$")
    public void checkIfTheProductWasAddedToTheCart(String mensaje) {
        theActorInTheSpotlight().should(seeThat(ElTexto.deConfirmacion(), containsString(mensaje))
                .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }
}


