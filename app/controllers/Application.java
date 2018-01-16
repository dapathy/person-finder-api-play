package controllers;

import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result onAuthDenied(final String providerKey) {
        return redirect(routes.Application.index());
    }
}
