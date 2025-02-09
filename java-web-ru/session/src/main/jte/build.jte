@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
<div>
    @if (!page.getError().isEmpty())
    <div>
        ${page.getError()}
    </div>
    @endif
</div>
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Name" name="name" value="${page.getName()}"/>
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>