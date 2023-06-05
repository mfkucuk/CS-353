package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QAndA 
{
    private UUID askId;
    private UUID answerId;
    private UUID rentalId;
    private String askName;
    private String answerName;
    private LocalDate askDate;
    private LocalDate answerDate;
    private String question;
    private String answer;

    public QAndA(
        @JsonProperty("askId")UUID askId,
        @JsonProperty("answerId")UUID answerId,
        @JsonProperty("rentalId")UUID rentalId,
        @JsonProperty("askName") String askName,
        @JsonProperty("answerName") String answerName,
        @JsonProperty("askDate")LocalDate askDate,
        @JsonProperty("answerDate")LocalDate answerDate,
        @JsonProperty("question")String question,
        @JsonProperty("answer")String answer
    )
    {
        this.askId = askId;
        this.answerId = answerId;
        this.rentalId = rentalId;
        this.askName = askName;
        this.answerName = answerName;
        this.askDate = askDate;
        this.answerDate = answerDate;
        this.question = question;
        this.answer = answer;
    }
}
