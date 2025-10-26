package edu.ucu.ua.flowers_store_continue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucu.ua.flowers_store_continue.flower.flower.Flower;
import edu.ucu.ua.flowers_store_continue.flower.flower.FlowerColor;
import edu.ucu.ua.flowers_store_continue.flower.flower.FlowerType;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @GetMapping
	public List<Flower> listOfFlowers() {
		List<Flower> lst = new ArrayList<>();
		lst.add(new Flower(100, FlowerColor.RED, 100, FlowerType.ROSE));
		lst.add(new Flower(100, FlowerColor.GREEN, 100, FlowerType.CHAMOMILE));
		lst.add(new Flower(100, FlowerColor.BLUE, 100, FlowerType.TULIP));
		return lst;
	}
}
