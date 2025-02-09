@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getCurrentUser() != null)
    <p>${page.getName()}</p>
    <form action="${NamedRoutes.logoutPath()}" method="post">
        <input type="submit" value="Выйти"/>
    </form>
    @else
    <a href="${NamedRoutes.logoinPath()}">Войти</a>
    @endif
'