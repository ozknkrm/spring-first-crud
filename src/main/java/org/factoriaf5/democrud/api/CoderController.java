package org.factoriaf5.democrud.api;


import org.factoriaf5.democrud.model.Coder;
import org.factoriaf5.democrud.payload.request.CoderRequest;
import org.factoriaf5.democrud.service.CoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coder")
public class CoderController {

    private final CoderService coderService;

    @Autowired
    public CoderController(CoderService coderService) {
        this.coderService = coderService;
    }

    @GetMapping("")
    public ResponseEntity<List<Coder>> index() {
        return ResponseEntity.ok().body(coderService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Coder> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(coderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(coderService.delete(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?>  create(@RequestBody CoderRequest coderRequest) {

        return ResponseEntity.ok().body(coderService.create(coderRequest));
    }

    @PutMapping("/")
    public ResponseEntity<?>  update(@RequestBody Coder coder) {

        return ResponseEntity.ok().body(coderService.update(coder));
    }


}
