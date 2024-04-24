package com.example.data1700oblig3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class kontroller {

    private final List<Kino> billetter = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreBillett(Kino innBillett){
        billetter.add(innBillett);
    }

    @GetMapping("/hentAlle")
    public List<Kino> hentAlle(){
        return billetter;
    }

    @GetMapping("/nullstill")
    public void nullstill(){
        billetter.clear();
    }
}