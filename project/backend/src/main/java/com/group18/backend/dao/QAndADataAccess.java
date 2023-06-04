package com.group18.backend.dao;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.misc.DataToLocalDateTime;
import com.group18.backend.models.QAndA;
import com.group18.backend.models.Rental;
import com.group18.backend.models.User;

import lombok.RequiredArgsConstructor;

@Repository("QAndA") @Transactional
@RequiredArgsConstructor
public class QAndADataAccess implements QAndADAO {

    private final JdbcTemplate jdbcTemplate;
    private final RentalDataAccess rentalDataAccess;
    private final UserDataAccess userDataAccess;

    @Override
    public int insertQAndA(QAndA qAndA) {
        final String sql = "INSERT INTO QAndA VALUES(?, ?, ?, NULL, ?, NULL, ?, ?, ?)";

        Rental rental = rentalDataAccess.getRentalById(qAndA.getRentalId()).orElse(null);
        User traveler = userDataAccess.getUserById(qAndA.getAskId()).orElse(null);
        User homeowner = userDataAccess.getUserById(rental.getHomeownerId()).orElse(null);

        return jdbcTemplate.update(sql, new Object[] { traveler.getFullName(), homeowner.getFullName(), 
            LocalDateTime.now(), qAndA.getQuestion(), qAndA.getAskId(), homeowner.getUserId(), qAndA.getRentalId() });
    }

    @Override
    public List<QAndA> getQuestionsByRentalId(UUID id) {
        final String sql = "SELECT * FROM QAndA WHERE rental_id = ?";

        List<QAndA> questions = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID askId = UUID.fromString(resultSet.getString("ask_id"));
            UUID answerId = UUID.fromString(resultSet.getString("answer_id"));
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));

            String askName = resultSet.getString("ask_name");
            String answerName = resultSet.getString("answer_name");

            LocalDateTime askDate = DataToLocalDateTime.Convert(resultSet.getDate("ask_date"));

            Date sqlAnswerDate = resultSet.getDate("answer_date");
            LocalDateTime answerDate = null;

            if (sqlAnswerDate != null) {
                answerDate = DataToLocalDateTime.Convert(sqlAnswerDate);
            } 

            String question = resultSet.getString("question");
            String answer = resultSet.getString("answer");

            return new QAndA(
                askId,
                answerId,
                rentalId,
                askName,
                answerName,
                askDate,
                answerDate,
                question,
                answer
            );
        }, new Object[] { id });
        return questions;
    }
    
}
