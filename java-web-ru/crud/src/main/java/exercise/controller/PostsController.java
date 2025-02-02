package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var pageNum = ctx.pathParamAsClass("page", Long.class).get();
        pageNum = pageNum == null ? 1 : pageNum;
        var posts = PostRepository.findAll(pageNum, 5);
        var page = new PostsPage(posts);
        ctx.render("posts/index.jte", model("page", page, "pageNum", pageNum));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
