package com.example.jeu_dpo.services;

import com.example.jeu_dpo.entities.Player;
import com.example.jeu_dpo.security.password.PasswordChangeRequest;

import java.util.Optional;

public interface PlayerService {

        Optional<Player> findByEmail(String email);
        Player savePlayer(Player player);
        Player registerPlayer(Player player);
        public String login(String email, String password);
        public void deleteAccountPlayer(Long id);
        void updatePassword(String email, PasswordChangeRequest passwordChangeRequest);

}
