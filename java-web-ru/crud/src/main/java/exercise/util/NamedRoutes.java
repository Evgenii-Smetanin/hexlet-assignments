package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPagePath(Integer pageNum) {
        return postsPagePath(String.valueOf(pageNum));
    }

    public static String postsPagePath(String pageNum) {
        return "/posts?page=" + pageNum;
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }
    // END
}
