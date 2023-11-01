package org.example.bot;

import org.apache.log4j.Logger;
import org.example.Main;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotStarter implements BotStarter {
    private final static Logger logger = Logger.getLogger(TelegramBotStarter.class);
    public TelegramBotStarter() {}
    @Override
    public void start() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot(Main.getFromProperty("botName"), Main.getFromProperty("token")));
        } catch (TelegramApiException e) {
            logger.error("Bot startup error", e);
        }
    }
}