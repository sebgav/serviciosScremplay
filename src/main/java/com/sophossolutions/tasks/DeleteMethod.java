package com.sophossolutions.tasks;

import com.sophossolutions.utilities.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteMethod implements Task {

    private String service;
    private String id;

    public DeleteMethod(String service, String id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(service.concat(id)).with(request -> request.auth().oauth2(Constant.ACCESS_TOKEN)));
    }

    public static DeleteMethod delete(String service, String id) {
        return Tasks.instrumented(DeleteMethod.class, service, id);
    }

}
