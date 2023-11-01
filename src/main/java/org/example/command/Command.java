package org.example.command;

import org.example.dto.Request;
import org.example.dto.Response;

public interface Command {
    String getName();
    Response handle(Request request);
}