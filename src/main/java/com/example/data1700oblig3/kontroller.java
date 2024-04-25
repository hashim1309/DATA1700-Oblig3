package com.example.data1700oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class kontroller {

    @Autowired
    private final kundeRepository rep;

    public kontroller(kundeRepository rep) {
        this.rep = rep;
    }

    @PostMapping("/lagre")
    public void lagre(Kino kino){
        rep.lagre(kino);
    }

    @GetMapping("/hentAlle")
    public List<Kino> hentAlle(){
       return rep.hentAlle();
    }

    @GetMapping("/nullstill")
    public void nullstill(){
        rep.slettAlle();
    }
}