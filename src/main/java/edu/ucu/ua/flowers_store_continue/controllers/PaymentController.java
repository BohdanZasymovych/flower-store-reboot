package edu.ucu.ua.flowers_store_continue.controllers;

import org.springframework.web.bind.annotation.RestController;
import edu.ucu.ua.flowers_store_continue.order.Order;
import edu.ucu.ua.flowers_store_continue.payment.CreditCardPaymentStrategy;
import edu.ucu.ua.flowers_store_continue.payment.PayPalPaymentStrategy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final Order order;

    public PaymentController(Order order) {
        this.order = order;
    }

    @GetMapping
    public String payment() {
        return "payment strategy: " + order.getPaymentStrategy();
    }

    @RequestMapping(value="/{name}", method={RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> setPaymentStrategy(@PathVariable String name) {
        if (name.equals("creditcard")) {
            order.setPaymentStrategy(new CreditCardPaymentStrategy());
        } else if (name.equals("paypal")) {
            order.setPaymentStrategy(new PayPalPaymentStrategy());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Payment strategy not found: " + name);
        }

        return ResponseEntity.ok("Payment strategy set to: " + name);
    }
}
