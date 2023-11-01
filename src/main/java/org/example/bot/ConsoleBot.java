package org.example.bot;

import org.example.dto.Request;
import org.example.dto.Response;
import org.example.handlers.KeywordStopHandler;
import org.example.handlers.RequestHandler;
import org.example.handlers.SimpleRequestHandler;
import org.example.handlers.StopHandler;
import org.example.readers.ConsoleRequestReader;
import org.example.readers.RequestReader;
import org.example.repliers.ConsoleResponseReplier;
import org.example.repliers.ResponseReplier;

public class ConsoleBot implements BotStarter {
    private final RequestReader reader = new ConsoleRequestReader();
    private final ResponseReplier replier = new ConsoleResponseReplier();
    private final RequestHandler requestHandler = new SimpleRequestHandler();
    private final StopHandler stopHandler = new KeywordStopHandler("exit");

    @Override
    public void start() {
        while(true) {
            Request request = reader.read();
            if (stopHandler.needStop(request)) {
                break;
            }

            Response response = requestHandler.handle(request);
            replier.reply(response);
        }
    }
}