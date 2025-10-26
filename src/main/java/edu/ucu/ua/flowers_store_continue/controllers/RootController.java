package edu.ucu.ua.flowers_store_continue.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/")
@RestController
public class RootController {
    @GetMapping
    public String root() {
        return "<pre>" +
               "Available endpoints:\n" +
               "- GET  /flowers                         : List all flowers\n" +
               "- GET  /order                           : View the current order\n" +
               "- GET/POST /order/{post|dhl}            : Set delivery method to 'post' or 'dhl'\n" +
               "- GET  /payment                         : View the current payment method\n" +
               "- GET/POST /payment/{creditcard|paypal} : Set payment method to 'creditcard' or 'paypal'\n" +
               "</pre>";
    }
}
