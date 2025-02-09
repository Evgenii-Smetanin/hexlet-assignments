package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = new User(name, password);
        UsersRepository.save(user);

        ctx.sessionAttribute("currentUser", name);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
