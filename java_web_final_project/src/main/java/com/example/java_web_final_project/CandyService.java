package com.example.java_web_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandyService {
    private CandyRepository candyRepository;

    public CandyService(CandyRepository candyRepository) {
        this.candyRepository = candyRepository;
    }

    public Candy createCandy(Candy candy) {
        return candyRepository.save(candy);
    }

    public List<Candy> getAllCandies() {
        return candyRepository.findAll();
    }

    public Candy getCandyById(Long id) {
        Optional<Candy> candy = candyRepository.findById(id);
        return candy.orElse(null);
    }

    public Candy updateCandy(Candy candy) {
        return candyRepository.save(candy);
    }

    public void deleteCandy(Long id) {
        candyRepository.deleteById(id);
    }
}

