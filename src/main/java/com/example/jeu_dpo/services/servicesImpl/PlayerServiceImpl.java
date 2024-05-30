package com.example.jeu_dpo.services.servicesImpl;

import com.example.jeu_dpo.entities.Player;
import com.example.jeu_dpo.repositories.PlayerRepository;
import com.example.jeu_dpo.security.JwtService;
import com.example.jeu_dpo.security.password.PasswordChangeRequest;
import com.example.jeu_dpo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;


@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public Optional<Player> findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    @Override
    public Player registerPlayer(Player player) {
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        player.setJoinDate(new Date());
        player.setEnabled(true);
        return playerRepository.save(player);
    }

   @Override
    public String login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtService.generateToken((UserDetails) authentication.getPrincipal());
    }

    @Override
    public void deleteAccountPlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void updateProfile(Long id, String firstName, String lastName, String email) {
        Player player = playerRepository.findById(id).orElse(null);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setEmail(email);
        playerRepository.save(player);
    }

    @Override
    public void updatePassword(String email, PasswordChangeRequest passwordChangeRequest) {
        Player player = playerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Player not found with email: " + email));

        if (!passwordEncoder.matches(passwordChangeRequest.getOldPassword(), player.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        if (!passwordChangeRequest.getNewPassword().equals(passwordChangeRequest.getConfirmNewPassword())) {
            throw new IllegalArgumentException("New password and confirm password do not match");
        }

        player.setPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
        playerRepository.save(player);
    }

}