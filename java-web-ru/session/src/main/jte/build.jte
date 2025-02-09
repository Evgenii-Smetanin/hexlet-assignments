@import org.example.hexlet.NamedRoutes

<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Name" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>