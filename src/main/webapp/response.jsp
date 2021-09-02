<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Sentiment</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="headerbox">
    <a class="header" href="index.html">
        <h1>Innovatec's Sentimentanalyse</h1>
    </a>
</div>
<div class="wrapper">
    <h3>Du har valgt en modell med ${kategorien} kategorier.</h3>
    <br/>
    <h3>Teksten du skrev: ${teksten}</h3>
    <h3>Predikasjonen til modellen er: ${predikeringen}</h3>
    <br/>
    Vi ønsker gjerne å vite om dette var en korrekt predikasjon, slik at vi kan lagre rett label på teksten din. Hva var den riktige kategorien?
    <br>
    <br>
    <form name="responseForm" method="post" action="response-servlet">
        <input type="radio" id="pos3" name="correct" value="positive" checked>
        <label for="pos3">Positiv</label>
        <input type="radio" id="neu3" name="correct" value="neutral">
        <label for="neu3">Nøytral</label>
        <input type="radio" id="neg3" name="correct" value="negative">
        <label for="neg3">Negativ</label>
        <br>
        <br>
        <div>
            <input type="submit" value="send" name="user_response" />
        </div>
    </form>
    <a class="header" href="predict.jsp"><h3>Prøv en ny tekst</h3></a>
</div>
</body>
</html>
