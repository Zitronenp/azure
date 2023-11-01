package org.example.command;

import org.example.parsing.Parsing;

public enum CommandName {
    START("/start") {
        @Override
        public String getAnswer() {
            return "Enter /weather";
        }
    },
    HELP("/help") {
        @Override
        public String getAnswer() {
            return  "Command /start to get started\n" +
                    "Command /help for help (no one will help you anymore)\n" +
                    "Command /weather get information about weather in Ekaterinburg";
        }
    },
    WEATHER("/weather" ) {
        @Override
        public String getAnswer() {
            return "В Екатеринбурге сейчас " + Parsing.parsing();
        }
    },
    UNKNOWN("") {
        @Override
        public String getAnswer() {
            return "Sorry, I don't know this command ¯\\_(ツ)_/¯";
        }
    };

    private String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getAnswer();
}
