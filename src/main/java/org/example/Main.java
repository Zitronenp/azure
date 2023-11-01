package org.example;

import org.example.bot.TelegramBotStarter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static String getFromProperty(String t) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("file not found!");
        }

        return property.getProperty(t);
    }
    public static void main(String[] args) {
        TelegramBotStarter telegramBotStarter = new TelegramBotStarter();
        telegramBotStarter.start();
    }
}