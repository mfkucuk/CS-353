package com.group18.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        @JsonProperty("askId")UUID askId,
        @JsonProperty("answerId")UUID answerId,
        @JsonProperty("rentalId")UUID rentalId,
        @JsonProperty("askDate")LocalDateTime askDate,
        @JsonProperty("answerDate")LocalDateTime answerDate,
        @JsonProperty("question")String question,
        @JsonProperty("answer")String answer
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
