package com.nicholasTropea.game.net;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Richiesta di registrazione di un nuovo giocatore. 
 * 
 * JSON atteso:
 * {
 *    "operation" : "register",
 *    "name" : "STRING",
 *    "psw" : "STRING"
 * } 
 */
public class RegisterRequest {
    @SerializedName("operation")
    private final String operation = "register";

    @SerializedName("name")
    private final String name;

    @SerializedName("psw")
    private final String password;

    // Costruttore
    public RegisterRequest(String name, String password) {
        this.name = Objects.requireNonNull(name, "Required name").trim();
        this.password = Objects.requireNonNull(password, "Required password");

        // Altre validazioni
        if (this.name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        if (this.password.length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters");
    }

    // Getters
    public String getOperation() { return this.operation; }
    public String getName() { return this.name; }
    public String getPassword() { return this.password; }
}