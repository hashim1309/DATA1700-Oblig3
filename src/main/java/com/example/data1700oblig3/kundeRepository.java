package com.example.data1700oblig3;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class kundeRepository {
    @Autowired
    private JdbcTemplate db;

    public void lagre(kino billett) {
        String sql = "INSERT INTO kino (film, antall, fnavn, enavn, telfnr, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, billett.getFilm(), billett.getAntall(), billett.getFornavn(), billett.getEtternavn(), billett.getTelefon(), billett.getEpost());
    }

    public List<kino> hentAlle() {
        String sql = "SELECT * FROM kino ORDER BY ename;";
        List<kino> billetter = db.query(sql, new BeanPropertyRowMapper(kino.class));
        return billetter;
    }

    public void slettAlle() {
        String sql = "DELETE FROM kino";
        db.update(sql);
    }
}