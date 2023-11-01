package org.example.handlers;

import org.example.dto.Request;

public interface StopHandler {
    boolean needStop(Request request);
}