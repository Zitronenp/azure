package org.example.handlers;

import org.example.dto.Request;

public record KeywordStopHandler(String stopCommand) implements StopHandler {
    @Override
    public boolean needStop(Request request) {
        return request.message().getText().equals(stopCommand());
    }
}