package com.example.jeu_dpo.services;

import com.example.jeu_dpo.entities.Player;
import com.example.jeu_dpo.security.password.PasswordChangeRequest;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface PlayerService {

        Optional<Player> findByEmail(String email);
        Player registerPlayer(Player player);
        public String login(String email, String password);
        public void deleteAccountPlayer(Long id);
        public void updateProfile(Long id, String firstName, String lastName, String email);
        void updatePassword(String email, PasswordChangeRequest passwordChangeRequest);

}
