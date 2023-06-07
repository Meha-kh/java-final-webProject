package com.example.java_web_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/candy")
public class CandyController {

    private final CandyRepository candyRepository;

    @Autowired
    public CandyController(CandyRepository candyRepository) {
        this.candyRepository = candyRepository;
    }

    @GetMapping("/{id}")
    public Candy getCandyById(@PathVariable Long id) {
        return candyRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Candy createCandy(@RequestBody Candy candy) {
        return candyRepository.save(candy);
    }

    @PutMapping("/{id}")
    public Candy updateCandy(@PathVariable Long id, @RequestBody Candy updatedCandy) {
        return candyRepository.findById(id)
                .map(candy -> {
                    candy.setName(updatedCandy.getName());
                    candy.setFlavor(updatedCandy.getFlavor());
                    candy.setPrice(updatedCandy.getPrice());
                    return candyRepository.save(candy);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCandy(@PathVariable Long id) {
        candyRepository.deleteById(id);
    }
}
