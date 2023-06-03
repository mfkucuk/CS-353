package com.group18.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class QAndA 
{
    private UUID askId;
    private UUID answerId;
    private UUID rentalId;
    private LocalDateTime askDate;
    private LocalDateTime answerDate;
    private String question;
    private String answer;

    public QAndA(
        UUID askId,
        UUID answerId,
        UUID rentalId,
        LocalDateTime askDate,
        LocalDateTime answerDate,
        String question,
        String answer
    )
    {
        this.askId = askId;
        this.answerId = answerId;
        this.rentalId = rentalId;
        this.askDate = askDate;
        this.answerDate = answerDate;
        this.question = question;
        this.answer = answer;
    }
}
