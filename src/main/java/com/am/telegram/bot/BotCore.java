package com.am.telegram.bot;

import com.am.telegram.aspect.action.MessageReceived;
import com.am.telegram.aspect.invoker.MethodInvoker;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j

@Service
public class BotCore extends TelegramLongPollingBot {

    @Autowired
    private MethodInvoker invoker;

    @Autowired
    private BotMessageHandler handler;

    @Value("${telegram.bot.username}")
    public String username;
    @Value("${telegram.bot.token}")
    public String token;

    @Override
    public void onUpdateReceived(Update update) {
        this.invoke(handler, update);
        log.info("handle message, done.");
    }

    @SneakyThrows
    public void sendMessage(SendMessage message) {
        this.execute(message);
        log.info("send message, done.");
    }

    protected void invoke(BotMessageHandler handler, Update update) {
        org.telegram.telegrambots.meta.api.objects.Message message = update.getMessage();
        if(message == null) return;
        log.info(message.getText());
        MessageReceived action = MessageReceived.findAction(message.getText().toUpperCase());
        invoker.invoke(handler, action, update);
    }

    @Override
    public String getBotUsername() {
        return username;
    }
    @Override
    public String getBotToken() {
        return token;
    }

}
