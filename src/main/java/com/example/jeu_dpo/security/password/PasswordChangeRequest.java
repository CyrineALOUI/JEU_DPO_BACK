package com.example.jeu_dpo.security.password;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordChangeRequest {

    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

}
