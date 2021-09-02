<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Sentiment</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="headerbox">
        <a class=header href="index.html">
            <h1>Innovatec's Sentimentanalyse</h1>
        </a>
    </div>
    <div class="wrapper">
        <p style="margin: 50px 450px;">
            Vær obs på at vi lagrer data som sendes inn til modellene for analyse. Dette da vi ønsker mer datagrunnlag til trening.
            <br>
            <br>
            Nøyaktigheten på predikeringene er større for modellen med kun 2 kategorier, enn den med 3. Grunnen til det er at oppgaven blir mer kompleks jo flere kategorier modellen kan velge mellom. Dette må du gjerne teste ut og erfare selv:)
            <br>
            <br>
            <br>
            <br>
            Skriv inn en tekst:
        </p>
    </div>
    <form name="sentimentForm" method="post" action="predict-servlet">
        <label>
            <textarea rows="10" cols="50" name="text"></textarea>
        </label>
        <div>
            <div class="wrapper">
                <p>
                    Velg antall kategorier du ønsker å predikere:
                </p>
            </div>
            <input type="radio" id="cat2" name="cat" value="2" checked>
            <label for="cat2">2 kategorier</label>
            <input type="radio" id="cat3" name="cat" value="3">
            <label for="cat3">3 kategorier</label>
        </div>
        <br>
        <div>
            <input type="submit" value="send" name="user_text" />
        </div>
    </form>
</body>
</html>