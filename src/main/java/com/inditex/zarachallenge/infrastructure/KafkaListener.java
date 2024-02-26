package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.application.ProductService;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class KafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListener.class);

    private final ProductService productService;

    @Autowired
    public KafkaListener(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
        return message -> {
            try {
                ProductAvailabilityEvent event = message.getPayload();
                logger.info("Received product availability event: {}", event);

                // Process the event using ProductService
                productService.getProductById(event.getSizeId());
            } catch (Exception e) {
                logger.error("Error processing product availability event", e);
            }
        };
    }

    // Additional methods if needed
    public void processProductAvailabilityEvent(ProductAvailabilityEvent event) {
        // Additional logic for processing events outside Kafka consumer
    }

}
