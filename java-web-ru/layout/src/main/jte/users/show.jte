@import org.example.hexlet.dto.UserPage
@param UserPage page

@template.layout.page(
content = @`
<div>${user.getFirstName() + user.getLastName()}</div>
<div>${user.getEmail()}</div>
`
)