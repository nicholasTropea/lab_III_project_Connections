package com.nicholasTropea.game.model;

/**
 * Rappresenta la posizione in classifica di un utente.
 * 
 * Restituita da una {@link LeaderboardResponse}.
 */
public class LeaderboardRecord {
    /** Username dell'utente */
    private final String username;

    /** Posizione in classifica dell'utente */
    private final int position;
    
    /** Costruttore */
    public LeaderboardRecord(String username, int position) {
        if (username.trim().isEmpty() || username == null) throw new IllegalArgumentException("username cannot be empty or null");
        if (position < 1) throw new IllegalArgumentException("position cannot be less than 1");

        this.username = username;
        this.position = position;
    }

    // Getters
    public String getUsername() { return this.username; }
    public int getPosition() { return this.position; }
}