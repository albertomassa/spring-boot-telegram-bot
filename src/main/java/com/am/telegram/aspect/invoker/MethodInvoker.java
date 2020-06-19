package com.am.telegram.aspect.invoker;

import com.am.telegram.aspect.action.MessageReceived;
import com.am.telegram.aspect.annotation.ActionReceived;
import com.am.telegram.bot.BotMessageHandler;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.lang.reflect.Method;

@Component
public class MethodInvoker {

    @SneakyThrows
    public Object invoke(BotMessageHandler handler, MessageReceived value, Update update) {
        for (Method method : handler.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(ActionReceived.class)) {
                ActionReceived annotation = method.getAnnotation(ActionReceived.class);
                if (annotation.value().equals(value)) {
                    return method.invoke(handler, update);
                }
            }
        }
        return this.invoke(handler, MessageReceived.NOT_FOUND, null);
    }

}
