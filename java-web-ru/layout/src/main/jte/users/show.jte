@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
<div>${user.getFirstName() + user.getLastName()}</div>
<div>${user.getEmail()}</div>
`
)