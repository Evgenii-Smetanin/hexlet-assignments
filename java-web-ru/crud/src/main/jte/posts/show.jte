@import exercise.dto.posts.PostPage
@import exercise.model.Post
@param PostPage page

@template.layout.page(
content = @`
<h1>${post.getName()}</h1>
<div>${post.getBody()}</div>
`
)