package com.nicholasTropea.game.model;

import java.util.List;

/** Rappresenta una singola partita. */
public class Game {
    /** Id univoco della partita */
    private final int gameId;

    /** Lista dei gruppi di parole della partita */
    private final List<Group> groups;

    public Game(int id, List<Group> groups) {
        this.gameId = id;
        this.groups = List.copyOf(groups);
    }

    /**
     * Getter per il game id.
     * 
     * @return Game id
     */
    public int getId() { return this.gameId; }

    /** 
     * Getter per i gruppi del game.
     * 
     * @return Copia della lista dei gruppi
     */
    public List<Group> getGroups() { return List.copyOf(this.groups); }

    /**
     * Rappresenta un gruppo appartenente ad una partita.
     */
    public static class Group {
        /** Tema generale del gruppo */
        private final String theme;

        /** Lista di parole del gruppo */
        private final List<String> words;

        public Group(String theme, List<String> words) {
            this.theme = theme;
            this.words = List.copyOf(words);
        }

        /**
         * Getter per il tema del gruppo.
         * 
         * @return Tema del gruppo
         */
        public String getTheme() { return this.theme; }

        /** 
         * Getter per la lista di parole del gruppo
         * 
         * @return Copia della lista di parole del gruppo
         */
        public List<String> getWords() { return List.copyOf(this.words); }
    }
}