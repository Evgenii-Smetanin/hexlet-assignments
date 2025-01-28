@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
content = @`
<form action="/courses" method="get">
    <input type="search" name="term" value="${page.getTerm()}" />
    <input type="submit" value="Search" />
</form>
@for(User user : page.getUsers())
<div>${user.getFirstName() + user.getLastName()}</div>
@endfor
`
)