package com.nicholasTropea.game.model;

import java.util.Map;

/** Rappresenta un giocatore registrato. */
public class Player {
    /** Nickname univoco del giocatore */
    private String nickname;

    /** Password del giocatore */
    private String password;

    /** Punteggio globale del giocatore */
    private int globalScore;

    /** Win-rate del giocatore */
    private float winRate;

    /** Loss-rate del giocatore */
    private float lossRate;

    /** Streak corrente delle partite vinte */
    private int currentStreak;

    /** Streak più alta mai raggiunta */
    private int maxStreak;

    /** Tipi di risultati di una partita */
    private enum ResultType {
        WIN_0,       // Vinta con 0 errori
        WIN_1,       // Vinta con 1 errore
        WIN_2,       // Vinta con 2 errori
        WIN_3,       // Vinta con 3 errori
        LOST,        // Persa con 4 errori
        NOT_FINISHED // Iniziata ma non terminata
    }

    /** Mappa contente il numero di occorrenze di un certo risultato */
    private Map<ResultType, Integer> resultCounts;

    // costruttore, getters     
}