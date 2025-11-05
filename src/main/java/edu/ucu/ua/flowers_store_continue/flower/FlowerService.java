package edu.ucu.ua.flowers_store_continue.flower;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }
}
