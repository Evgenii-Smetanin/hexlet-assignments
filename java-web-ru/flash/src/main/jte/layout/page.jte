<!-- BEGIN -->
@import exercise.util.NamedRoutes
@import exercise.dto.BasePage // Импортируем базовый класс
@import gg.jte.Content
@param Content content
@param BasePage page = null // Если не передали, то игнорируем

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        @if(page != null && page.getFlash() != null)
        <p>${page.getFlash()}</p>
        @endif
        ${content}
    </body>
</html>
<!-- END -->
