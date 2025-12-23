package com.nicholasTropea.game.net;

import com.google.gson.annotations.SerializedName;
import java.util.List;

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
        return new LoginResponse(true, null, gameId, words, correctGroups, timeLeft, errors, score);
    }

    public static LoginResponse error(String errorMsg) {
        return new LoginResponse(false, errorMsg, null, null, null, null, null, null);
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