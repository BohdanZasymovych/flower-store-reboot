package edu.ucu.ua.flowers_store_continue.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucu.ua.flowers_store_continue.flower.FlowerService;
import edu.ucu.ua.flowers_store_continue.flower.Flower;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
	private final FlowerService flowerService;

	public FlowerController(FlowerService flowerService) {
		this.flowerService = flowerService;
	}

    @GetMapping
	public List<Flower> getFlowers() {
		return flowerService.getFlowers();
	}

	@PostMapping
	public ResponseEntity<Flower> addFlower(@org.springframework.web.bind.annotation.RequestBody Flower flower) {
		Flower saved = flowerService.addFlower(flower);
		return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(saved);
	}
}
