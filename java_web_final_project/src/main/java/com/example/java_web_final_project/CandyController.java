package com.example.java_web_final_project;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/candy")
public class CandyController {

   final public CandyService candyService;

    public CandyController(CandyService candyService) {
        this.candyService = candyService;
    }

    @PostMapping
    public Candy createnewCandy(@RequestBody Candy candy) {
        return candyService.createCandy(candy);
    }

    @GetMapping("/{id}")
    public Optional<Candy> CandyById(@PathVariable Long id) {
        return Optional.ofNullable(candyService.getCandyById(id));
    }


    @PutMapping("/{id}")
    public void updateCandy( @RequestBody Candy updatedCandy) {

                candyService.updateCandy(updatedCandy);

    }

    @DeleteMapping("/{id}")
    public void deleteCandy(@PathVariable Long id) {
        candyService.deleteCandy(id);
    }
}
