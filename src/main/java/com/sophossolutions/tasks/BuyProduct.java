package com.sophossolutions.tasks;

import com.sophossolutions.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static com.sophossolutions.userinterfaces.HomePage.*;

public class BuyProduct implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Open.browserOn(new HomePage()));
        if (TEXTBOX_ALERT.resolveFor(actor).isVisible()) {
            actor.attemptsTo(Click.on(TEXTBOX_ALERT));
        }
        actor.attemptsTo(
                Click.on(FIELD_AUDIO),
                Click.on(FIELD_AUDIFONOS));
    }

    public static BuyProduct buy() {
        return Tasks.instrumented(BuyProduct.class);
    }

}
