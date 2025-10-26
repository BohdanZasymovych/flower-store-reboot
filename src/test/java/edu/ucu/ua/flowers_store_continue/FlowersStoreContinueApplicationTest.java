package edu.ucu.ua.flowers_store_continue;

import edu.ucu.ua.flowers_store_continue.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlowersStoreContinueApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Order order;

    @BeforeEach
    void resetOrder() {
        // clear strategies and items so tests are isolated
        order.setDeliveryStrategy(null);
        order.setPaymentStrategy(null);
        if (order.getItems() != null) {
            order.getItems().clear();
        }
    }

    @Test
    public void deliveryStrategySwitching() {
        ResponseEntity<String> setResp = restTemplate.getForEntity("/delivery/dhl", String.class);
        assertEquals(HttpStatus.OK, setResp.getStatusCode());
    String setBody = setResp.getBody();
    assertNotNull(setBody);
    assertTrue(setBody.contains("Delivery strategy set to: dhl"));

    ResponseEntity<String> getResp = restTemplate.getForEntity("/delivery", String.class);
    assertEquals(HttpStatus.OK, getResp.getStatusCode());
    String getBody = getResp.getBody();
    assertNotNull(getBody);
    assertTrue(getBody.toLowerCase().contains("dhl"));

    assertEquals("DHL delivery", order.getDeliveryStrategy());
    }

    @Test
    public void paymentStrategySwitching() {
        ResponseEntity<String> setResp = restTemplate.getForEntity("/payment/paypal", String.class);
        assertEquals(HttpStatus.OK, setResp.getStatusCode());
    String setBody = setResp.getBody();
    assertNotNull(setBody);
    assertTrue(setBody.contains("Payment strategy set to: paypal"));

    ResponseEntity<String> getResp = restTemplate.getForEntity("/payment", String.class);
    assertEquals(HttpStatus.OK, getResp.getStatusCode());
    String getBody = getResp.getBody();
    assertNotNull(getBody);
    assertTrue(getBody.toLowerCase().contains("paypal"));

    assertEquals("PayPal payment", order.getPaymentStrategy());
    }

    @Test
    public void deliveryPostSwitching() {
        ResponseEntity<String> setResp = restTemplate.postForEntity("/delivery/dhl", null, String.class);
        assertEquals(HttpStatus.OK, setResp.getStatusCode());
        String setBody = setResp.getBody();
        assertNotNull(setBody);
        assertTrue(setBody.contains("Delivery strategy set to: dhl"));

        ResponseEntity<String> getResp = restTemplate.getForEntity("/delivery", String.class);
        assertEquals(HttpStatus.OK, getResp.getStatusCode());
        String getBody = getResp.getBody();
        assertNotNull(getBody);
        assertTrue(getBody.toLowerCase().contains("dhl"));
        assertEquals("DHL delivery", order.getDeliveryStrategy());
    }

    @Test
    public void paymentPostSwitching() {
        ResponseEntity<String> setResp = restTemplate.postForEntity("/payment/creditcard", null, String.class);
        assertEquals(HttpStatus.OK, setResp.getStatusCode());
        String setBody = setResp.getBody();
        assertNotNull(setBody);
        assertTrue(setBody.contains("Payment strategy set to: creditcard"));

        ResponseEntity<String> getResp = restTemplate.getForEntity("/payment", String.class);
        assertEquals(HttpStatus.OK, getResp.getStatusCode());
        String getBody = getResp.getBody();
        assertNotNull(getBody);
        assertTrue(getBody.toLowerCase().contains("creditcard") || getBody.toLowerCase().contains("credit card"));
        assertEquals("Credit card payment", order.getPaymentStrategy());
    }

    @Test
    public void deliveryInvalidNameReturns404() {
        ResponseEntity<String> resp = restTemplate.getForEntity("/delivery/unknown", String.class);
        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
        String body = resp.getBody();
        assertNotNull(body);
        assertTrue(body.toLowerCase().contains("not found") || body.toLowerCase().contains("strategy not found"));
    }

    @Test
    public void paymentInvalidNameReturns404() {
        ResponseEntity<String> resp = restTemplate.getForEntity("/payment/unknown", String.class);
        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
        String body = resp.getBody();
        assertNotNull(body);
        assertTrue(body.toLowerCase().contains("not found") || body.toLowerCase().contains("strategy not found"));
    }
}
