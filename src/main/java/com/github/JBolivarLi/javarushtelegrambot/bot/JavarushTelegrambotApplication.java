package com.github.JBolivarLi.javarushtelegrambot.bot;

import com.github.JBolivarLi.javarushtelegrambot.bot.bot.JavarushTelegramBot;
import com.github.JBolivarLi.javarushtelegrambot.bot.repository.entity.TelegramUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class JavarushTelegrambotApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavarushTelegrambotApplication.class, args);
    }




}
