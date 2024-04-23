function regBillett() {
    let velgfilm = $("#velgFilm").val();
    let antall = $("#antall").val();
    let fornavn = $("#fornavn").val();
    let etternavn = $("#etternavn").val();
    let telefon = $("#telefon").val();
    let epost = $("#epost").val();

    if (velgfilm !== 'Ikke valgt') { $("#errorFilm").text("");}
    if (antall !== '') { $("#errorAntall").text(""); }
    if (fornavn !== '') { $("#errorFornavn").text(""); }
    if (etternavn !== '') { $("#errorEtternavn").text(""); }
    if (telefon !== '') { $("#errorTelefon").text(""); }
    if (epost !== '') { $("#errorEpost").text(""); }

    if (velgfilm === 'Ikke valgt') {$("#errorFilm").html("Velg en film: ");}
    if (antall <= 0) {$("#errorAntall").html("Skriv inn hvor mange du vil bestille: ");}
    if (fornavn === '') {$("#errorFornavn").html("Skriv inn fornavnet ditt: ");}
    if (etternavn === '') {$("#errorEtternavn").html("Skriv inn etternavnet ditt: ");}
    if (telefon === '') {$("#errorTelefon").html("Skriv inn telefon-nummeret ditt: ");}
    if (epost === '') {$("#errorEpost").html("Skriv inn Epost-adressen din: ");}

    else if (velgfilm === 'Ikke valgt' || antall <= 0 || fornavn === '' || etternavn === '' || telefon === '' || epost === '') {
        $("#error").val("");
    }

    else {
        const billett = {
            film : $("#velgFilm").val(),
            antall : $("#antall").val(),
            fornavn : $("#fornavn").val(),
            etternavn : $("#etternavn").val(),
            telefon : $("#telefon").val(),
            epost : $("#epost").val()
        }

        $.post('/lagre', billett, function() {
            hentAlle();
        });

        $("#velgFilm").val("Ikke valgt");
        $("#antall").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#telefon").val("");
        $("#epost").val("");

        $("#errorFilm").text("");
        $("#errorAntall").text("");
        $("#errorFornavn").text("");
        $("#errorEtternavn").text("");
        $("#errorTelefon").text("");
        $("#errorEpost").text("");
    }
}

function hentAlle() {
    $.get("/hentAlle", function(data) {
        formaterData(data);
    });
}

function formaterData(liste){
    let print = '';
    for (billett of liste) {
        print += "<tr>" +
            "<td>" +billett.fornavn+ "</td>" +
            "<td>" +billett.etternavn+ "</td>" +
            "<td>" +billett.telefon+ "</td>" +
            "<td>" +billett.epost+ "</td>" +
            "<td>" +billett.film+ "</td>" +
            "<td>" +billett.antall+ "</td>" +
            "</tr>";
    }

    $("#tabell").html(print);
}

function nullstill() {
    $.get( "/nullstill", function() {
        hentAlle();
    });
}