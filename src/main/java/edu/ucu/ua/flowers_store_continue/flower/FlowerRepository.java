package edu.ucu.ua.flowers_store_continue.flower;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    
}
