package com.am.telegram.aspect.action;

public enum MessageReceived {

    START,

    HELLO,

    NOT_FOUND

    ;

    public static final MessageReceived findAction(String message) {
        for (MessageReceived action : MessageReceived.values()) {
            String actionString = action.name();
            actionString = actionString.replace("_", " ");
            if(message.contains(actionString)) {
                return action;
            }
        }
        return MessageReceived.NOT_FOUND;
    }

}
