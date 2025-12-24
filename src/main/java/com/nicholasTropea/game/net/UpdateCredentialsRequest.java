package com.nicholasTropea.game.net;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Richiesta di modifica delle credenziali.
 * Riceve una {@link UpdateCredentialsResponse}.
 * 
 * JSON atteso:
 * <pre>{@code
 * {
 *    "operation" : "updateCredentials",
 *    "oldName" : "STRING",
 *    "newName" : "STRING",
 *    "oldPsw" : "STRING",
 *    "newPsw" : "STRING"
 * } 
 * }</pre>
 * 
 * Errori possibili: "oldPsw errata", "newName già registrato"...
 */
public class UpdateCredentialsRequest {
    /** Operazione effettuata */
    @SerializedName("operation")
    private final String operation = "updateCredentials";

    /** Attuale nome utente dell'account da cambiare */
    @SerializedName("oldName")
    private final String oldName;

    /** Attuale password dell'account da cambiare */
    @SerializedName("oldPsw")
    private final String oldPassword;

    /** Nuovo nome da impostare (opzionale) */
    @SerializedName("newName")
    private final String newName;

    /** Nuova password da impostare (opzionale, minimo 6 caratteri) */
    @SerializedName("newPsw")
    private final String newPassword;

    /**
     * Costruttore completo.
     * 
     * Crea una richiesta per cambio di credenziali.
     * 
     * @param oldName attuale nome utente dell'account da cambiare
     * @param oldPsw attuale password dell'account da cambiare
     * @param newName eventuale nuovo nome da impostare
     * @param newPassword eventuale nuova password da impostare
     */
    public UpdateCredentialsRequest(String oldName, String oldPassword, String newName, String newPassword) {
        // Check leggero
        validate(oldName, oldPassword, newName, newPassword);

        this.oldName = oldName.trim();
        this.oldPassword = oldPassword;
        this.newName = newName != null ? newName.trim() : "";
        this.newPassword = newPassword != null ? newPassword : "";
    }


    /**
     * Valida gli argomenti passati al costruttore.
     * 
     * @param oldName Nome attuale
     * @param oldPassword Password attuale
     * @param newName Nuovo nome
     * @param newPassword Nuova password
     * 
     * @throws IllegalArgumentException se uno dei parametri è malformato
     */
    private static void validate(String oldName, String oldPassword, String newName, String newPassword) {
        Objects.requireNonNull(oldName, "oldName is required");
        Objects.requireNonNull(oldPassword, "oldPassword is required");

        // Password o nome devono cambiare
        if (
            (newName == null || newName.trim().isEmpty()) &&
            (newPassword == null || newPassword.isEmpty())
        ) {
            throw new IllegalArgumentException("Either password, name or both must change");
        }

        if (oldName.trim().isEmpty()) throw new IllegalArgumentException("oldName cannot be empty");
        if (oldPassword.isEmpty()) throw new IllegalArgumentException("oldPassword cannot be empty");
        if (oldPassword.length() < 6) throw new IllegalArgumentException("OldPassword must be at least 6 characters long");
        if (newPassword != null && newPassword.length() < 6) throw new IllegalArgumentException("newPassword must be at least 6 characters long");
        if (newName != null && newName.trim().isEmpty()) throw new IllegalArgumentException("newName cannot be empty");
    }

    // Getters
    public String getOperation() { return this.operation; }
    public String getOldName() { return this.oldName; }
    public String getOldPassword() { return this.oldPassword; }
    public String getNewName() { return this.newName; }
    public String getNewPassword() { return this.newPassword; }
}