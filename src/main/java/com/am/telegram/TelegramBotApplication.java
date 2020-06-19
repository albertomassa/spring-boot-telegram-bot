package com.am.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication

@PropertySource(value = {
	"classpath:application.properties",
	"classpath:application-bot.properties"
})
public class TelegramBotApplication {

	static {
		//init-telegram-context
		ApiContextInitializer.init();
	}

	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);
	}

}
