package org.example.dto;

import org.telegram.telegrambots.meta.api.objects.Message;

public record Request(Message message) {
}