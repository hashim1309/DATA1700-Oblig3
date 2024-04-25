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
        String sql = "INSERT INTO Kino (film, antall, fnavn, enavn, telfnr, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, billett.getFilm(), billett.getAntall(), billett.getFornavn(), billett.getEtternavn(), billett.getTelefon(), billett.getEpost());
    }

    public List<Kino> hentAlle() {
        String sql = "SELECT * FROM Kino ORDER BY enavn";
        List<Kino> billetter = db.query(sql, new BeanPropertyRowMapper(Kino.class));
        return billetter;
    }

    public void slettAlle() {
        String sql = "DELETE FROM Kino";
        db.update(sql);
    }
}