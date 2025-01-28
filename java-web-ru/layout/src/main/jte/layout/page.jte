@import org.example.Page
@import gg.jte.Content

@param Page page
@param Content content

<head>
    @if(page.getDescription() != null)
    <meta name="description" content="${page.getDescription()}">
    @endif
    <title>${page.getTitle()}</title>
    <a href="/">На главную</a>
    <a href="/users">Пользователи</a>
</head>
<body>
    <h1>${page.getTitle()}</h1>
    <div class="content">
        ${content}
    </div>
    <div class="footer">
        <p>Хекслет</p>
    </div>
</body>