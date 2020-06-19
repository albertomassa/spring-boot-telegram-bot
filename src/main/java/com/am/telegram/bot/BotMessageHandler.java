package com.am.telegram.bot;

import com.am.telegram.aspect.action.MessageReceived;
import com.am.telegram.aspect.annotation.ActionReceived;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j

@Component
public class BotMessageHandler {

    @Autowired
    private BotCore core;

    @ActionReceived(value = MessageReceived.START)
    public void start(Update update) {
        log.info("handle: start");
    }

    @ActionReceived(value = MessageReceived.HELLO)
    public void hello(Update update) {
        log.info("handle: hello");
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("hello sir :)");
        core.sendMessage(message);
    }

    @ActionReceived(value = MessageReceived.NOT_FOUND)
    public void notFound(Update update) {
        log.warn("error: action not found");
    }

}
