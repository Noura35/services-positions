package org.example.servicepositions.controller;


import org.example.servicepositions.model.Position;
import org.example.servicepositions.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    // Récupérer toutes les positions (équivalent à get_all.php)
    @GetMapping
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    // Ajouter une nouvelle position (équivalent à add_position.php)
    @GetMapping("/add")
    public ResponseEntity<Position> addPosition(@RequestParam Double longitude,
                                                @RequestParam Double latitude,
                                                @RequestParam String pseudo) {
        Position newPosition = new Position();
        newPosition.setLongitude(longitude);
        newPosition.setLatitude(latitude);
        newPosition.setPseudo(pseudo);
        positionRepository.save(newPosition);
        return ResponseEntity.ok(newPosition);
    }
}
