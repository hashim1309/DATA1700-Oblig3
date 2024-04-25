package com.example.data1700oblig3;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class kundeRepository {
    @Autowired
    private JdbcTemplate db;

    public void lagre(Kino billett) {
        String sql = "INSERT INTO Kino (antall, telefon, film, fornavn, etternavn, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, billett.getAntall(), billett.getTelefon(), billett.getFilm(), billett.getFornavn(), billett.getEtternavn(), billett.getEpost());
    }

    public List<Kino> hentAlle() {
        String sql = "SELECT * FROM Kino ORDER BY etternavn";
        List<Kino> biletter = db.query(sql, new BeanPropertyRowMapper(Kino.class));
        return biletter;
    }

    public void slettAlle() {
        String sql = "DELETE FROM Kino";
        db.update(sql);
    }
}