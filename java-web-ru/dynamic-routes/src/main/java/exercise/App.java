package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id").get();
            Map<String, String> comp = null;

            if (id > COMPANIES.size() - 1) {
                throw new NotFoundResponse("Entity with id = " + id + " not found");
            }

            for (var c : COMPANIES) {
                if (c.get("id").equals(id)) {
                    comp = c;
                    break;
                }
            }

            if (comp == null) {
                throw new NotFoundResponse("Entity with id = " + id + " not found");
            } else {
                ctx.json(comp);
            }
        });

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
