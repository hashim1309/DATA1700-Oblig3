package com.example.data1700oblig3;

public class Kino {
    private String film;
    private String antall;
    private String fornavn;
    private String etternavn;
    private String telefon;
    private String epost;

    public Kino(String film, String antall, String fornavn, String etternavn, String telefon, String epost) {
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefon = telefon;
        this.epost = epost;
    }

    public Kino() { }

    public String getFilm() { return film; }
    public String getAntall() { return antall; }
    public String getFornavn() { return fornavn; }
    public String getEtternavn() { return etternavn; }
    public String getTelefon() { return telefon; }
    public String getEpost() { return epost; }

    public void setFilm(String film) { this.film = film; }
    public void setAntall(String antall) { this.antall = antall; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public void setEpost(String epost) { this.epost = epost; }
}
