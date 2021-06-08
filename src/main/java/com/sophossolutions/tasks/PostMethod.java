package com.sophossolutions.tasks;

import com.sophossolutions.interactions.Post;
import com.sophossolutions.models.User;
import com.sophossolutions.utilities.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpHeaders;

public class PostMethod implements Task {

    private String service;
    private String body;
    public PostMethod(String service, String body) {
        this.service = service;
        this.body = body;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        User user = new User();
        actor.attemptsTo(Post.to(service).with(request -> request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON).auth()
                .oauth2(Constant.ACCESS_TOKEN).body(body)));


    }


    public static PostMethod createUser(String service, String body) {
        return Tasks.instrumented(PostMethod.class, service, body);
    }



}
