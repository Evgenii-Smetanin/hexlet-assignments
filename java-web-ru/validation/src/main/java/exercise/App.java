package exercise;

import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import exercise.model.Article;
import exercise.repository.ArticleRepository;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("index.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            var rawTitle = ctx.formParam("title");
            var rawContent = ctx.formParam("content");

            try {
                var title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() > 1, "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.findByTitle(value).isEmpty(),
                                "Статья с таким названием уже существует")
                        .get();
                var content = ctx.formParamAsClass("content", String.class)
                        .check(value -> value.length() > 9, "Статья должна быть не короче 10 символов")
                        .get();
                var article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var page = new BuildArticlePage(rawTitle, rawContent, e.getErrors());
                ctx.render("articles/build.jte", model("page", page)).status(422);
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
