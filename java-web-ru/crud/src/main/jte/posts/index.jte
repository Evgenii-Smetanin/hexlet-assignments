@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage page
@param Integer pageNum

@template.layout.page(
content = @`
@for(Post post : page.getPosts())
<a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
@endfor
<a href="${NamedRoutes.postsPagePath(pageNum - 1)}">назад</a>
<a href="${NamedRoutes.postsPagePath(pageNum + 1)}">вперед</a>
`
)