package com.nicholasTropea.game.net;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Risposta ad una richiesta di login di un giocatore.
 * 
 * JSON atteso:
 * {
 *    "success" : BOOLEAN,
 *    "error" : STRING,
 *    "gameId" : INT,
 *    "words" : LIST<STRING>,
 *    "correctGroups" : LIST<LIST<STRING>>,
 *    "timeLeft" : LONG,
 *    "errors" : INT,
 *    "score" : INT
 * }
 */
public class LoginResponse {
    @SerializedName("success")
    private final boolean success;

    @SerializedName("error")
    private final String error; // null se success = true

    @SerializedName("gameId")
    private final Integer gameId;

    @SerializedName("words")
    private final List<String> words;

    @SerializedName("correctGroups")
    private final List<List<String>> correctGroups; // Gruppi già indovinati

    @SerializedName("timeLeft")
    private final Long timeLeft; // ms

    @SerializedName("errors")
    private final Integer errors;

    @SerializedName("score")
    private final Integer score;

    /** Costruttore privato */
    private LoginResponse(
        boolean success,
        String error,
        Integer gameId,
        List<String> words,
        List<List<String>> correctGroups,
        Long timeLeft,
        Integer errors,
        Integer  score
    ) {
        this.success = success;
        this.error = error;
        this.gameId = gameId;
        this.words = words != null ? List.copyOf(words) : null;
        this.correctGroups = correctGroups != null ? List.copyOf(correctGroups) : null;
        this.timeLeft = timeLeft;
        this.errors = errors;
        this.score = score;
    }

    public static LoginResponse success(
        Integer gameId,
        List<String> words,
        List<List<String>> correctGroups,
        Long timeLeft,
        Integer errors,
        Integer score
    ) {
        if (
            gameId == null ||
            words == null ||
            correctGroups == null ||
            timeLeft == null ||
            errors == null ||
            score == null
        ) {
            throw new IllegalArgumentException("Parameters can't be null");
        }

        // TO-DO

        /*final int MIN_ID = 0;
        final int MAX_ID = 911;
        if (gameId ==)*/

        return new LoginResponse(true, null, gameId, words, correctGroups, timeLeft, errors, score);
    }

    public static LoginResponse error(String errorMsg) {
        if (errorMsg == null || errorMsg.trim().isEmpty()) {
            throw new IllegalArgumentException("Error message must be provided");
        }

        return new LoginResponse(false, errorMsg, null, null, null, null, null, null);
    }

    private void validateSuccess(
        Integer gameId,
        List<String> words,
        List<List<String>> correctGroups,
        Long timeLeft,
        Integer errors,
        Integer score
    ) {
        if (
            gameId == null ||
            (words == null || words.isEmpty()) ||
            (correctGroups == null || correctGroups.isEmpty()) ||
            timeLeft == null ||
            errors == null ||
            score == null
        ) {
            throw new IllegalArgumentException("Parameters can't be null");
        }

        final int MIN_ID = 0;
        final int MAX_ID = 911;
        if (gameId < MIN_ID || gameId > MAX_ID) {
            throw new IllegalArgumentException("gameId must be between 0 and 911");
        }



    }

    // Getters
    public boolean isSuccess() { return this.success; }
    public String getError() { return this.error; }
    public Integer getGameId() { return this.gameId; }
    public List<String> getWords() { return this.words; }
    public List<List<String>> getCorrectGroups() { return this.correctGroups; }
    public Long getTimeLeft() { return this.timeLeft; }
    public Integer getErrors() { return this.errors; }
    public Integer getScore() { return this.score; }
}