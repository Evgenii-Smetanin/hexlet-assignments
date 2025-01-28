@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
    content = @`
        @for(User user : page.getUsers())
            <div>${user.getFirstName() + user.getLastName()}</div>
        @endfor
    `
)