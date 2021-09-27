package com.yuebaix.nezha.core;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Server {
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public void stats() {
        System.out.println(String.format("--- echo --- %s ---", df.format(LocalDateTime.now())));
    }
}
