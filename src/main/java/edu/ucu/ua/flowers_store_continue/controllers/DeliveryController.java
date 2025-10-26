package edu.ucu.ua.flowers_store_continue.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucu.ua.flowers_store_continue.delivery.DHLDeliveryStrategy;
import edu.ucu.ua.flowers_store_continue.delivery.PostDeliveryStrategy;
import edu.ucu.ua.flowers_store_continue.order.Order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final Order order;

    public DeliveryController(Order order) {
        this.order = order;
    }

    @GetMapping
    public String delivery() {
        return "delivery strategy: " + order.getDeliveryStrategy();
    }

    @RequestMapping(value="/{name}", method={RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> setDeliveryStrategy(@PathVariable String name) {
        if (name.equals("post")) {
            order.setDeliveryStrategy(new PostDeliveryStrategy());
        } else if (name.equals("dhl")) {
            order.setDeliveryStrategy(new DHLDeliveryStrategy());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Delivery strategy not found: " + name);
        }

        return ResponseEntity.ok("Delivery strategy set to: " + name);
    }
}
