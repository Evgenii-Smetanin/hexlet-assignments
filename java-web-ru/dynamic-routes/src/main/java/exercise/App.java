package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            Map<String, String> comp = null;

            for (var c : COMPANIES) {
                if (c.get("id").equals(String.valueOf(id))) {
                    comp = c;
                    break;
                }
            }

            if (comp == null) {
                throw new NotFoundResponse("Company not found");
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
