@import exercise.dto.posts.PostPage
@import exercise.model.Post
@param PostPage page

@template.layout.page(
content = @`
<h1>${page.getPost().getName()}</h1>
<div>${page.getPost().getBody()}</div>
`
)