package com.javeriana.Game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDTO {

    private String userDocument;

    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(final String userDocument) {

        this.userDocument = userDocument;
    }

    public void setUserPassword(final String userPassword) {

        this.userPassword = userPassword;
    }
}
