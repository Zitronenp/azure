package org.example.bot;

import org.apache.log4j.Logger;
import org.example.command.Command;
import org.example.command.CommandList;
import org.example.command.CommandManager;
import org.example.dto.Request;
import org.example.dto.Response;
import org.example.handlers.MessageConverter;
import org.example.handlers.RequestHandler;
import org.example.handlers.SimpleRequestHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private final static Logger logger = Logger.getLogger(Bot.class);
    private final String botName;
    private final String botToken;
    private final RequestHandler requestHandler = new SimpleRequestHandler();
    private final MessageConverter messageConverter = new MessageConverter();
    private final Command commandManager = new CommandManager(new CommandList().getCommands());

    public Bot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Request request = messageConverter.convertMessageToRequest(update.getMessage());
        Response response = commandManager.handle(request);
        if (response == null)
            response = requestHandler.handle(request);
        SendMessage sendMessage = messageConverter.convertResponseToMessage(response);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            logger.error("Error sending message", e);
        }
    }
}