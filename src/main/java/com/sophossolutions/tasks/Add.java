package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.sophossolutions.userinterfaces.AudiPage.BUTTON_AGREGAR;
import static com.sophossolutions.userinterfaces.HomePage.BUTTON_VIEW_CAR;


public class Add implements Task {


    private static String audi;

    public Add(String audi) {
        this.audi = audi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        setAudi(audi);
        actor.attemptsTo(Click.on(BUTTON_AGREGAR));
        actor.attemptsTo(Click.on(BUTTON_VIEW_CAR));
    }

    public static Add toCart(String audi) {
        return Tasks.instrumented(Add.class, audi);
    }

    public static String getAudi() {
        return audi;
    }


    private static void setAudi(String articulo) {
        Add.audi = articulo;
    }

}
