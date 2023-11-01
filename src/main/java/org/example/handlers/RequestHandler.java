package org.example.handlers;

import org.example.dto.Request;
import org.example.dto.Response;

public interface RequestHandler {
    Response handle(Request request);
}