package com.nicholasTropea.game.model;

import java.util.List;
import java.util.ArrayList;

/** Rappresenta lo stato di un giocatore rispetto ad una partita. */
public class PlayerGameState {
    /** Nickname del player a cui si riferisce */
    private final String playerNickname;

    /** Id del game a cui si riferisce */
    private final int gameId;
    
    /** Numero di proposte corrette effettuate dal giocatore */
    private int correctProposals;

    /** Lista di parole rimanenti da raggruppare */
    private List<String> remainingWords;

    /** Numero di errori effettuati */
    private int errorCount;

    /** Punteggio accumulato in questa partita */
    private int score;

    /** Stati in cui si può concludere la partita */
    private enum GameResult {
        WON,
        LOST,
        NOT_FINISHED
    }

    /** Stato con cui si è conclusa la partita */
    private GameResult finalState;

    public PlayerGameState() {
        this.playerNickname = "";
        this.gameId = 1;
        this.correctProposals = 2;
        this.remainingWords = new ArrayList();
        this.errorCount = 0;
        this.score = 1;
        this.finalState = GameResult.WON;
    }
}