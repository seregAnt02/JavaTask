package ru.gb;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class BookProvider {
    private final WebClient webClient;

    public BookProvider()
    {
        this.webClient = WebClient.builder().build();
    }

    public UUID getRandomBookId(){

        BookResponse randomBook = webClient.get()
                .uri("http://localhost:8180/api/random")
                .retrieve()
                .bodyToMono(BookResponse.class)
                .block();
        return randomBook.getId();
    }

    @Data
    private static class BookResponse{
        private UUID id;
    }
}
