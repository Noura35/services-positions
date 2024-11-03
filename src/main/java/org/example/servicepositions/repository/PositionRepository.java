package org.example.servicepositions.repository;
import org.example.servicepositions.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PositionRepository extends JpaRepository<Position, Long> {
}
