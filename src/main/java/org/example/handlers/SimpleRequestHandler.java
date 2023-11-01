package org.example.handlers;

import org.example.dto.Request;
import org.example.dto.Response;

public class SimpleRequestHandler implements RequestHandler {
    @Override
    public Response handle(Request request) {
        return new Response(request.message());
    }
}