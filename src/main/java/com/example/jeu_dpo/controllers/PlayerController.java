package com.example.jeu_dpo.controllers;

import com.example.jeu_dpo.entities.Player;
import com.example.jeu_dpo.security.AuthRequest;
import com.example.jeu_dpo.security.AuthResponse;
import com.example.jeu_dpo.security.password.PasswordChangeRequest;
import com.example.jeu_dpo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerPlayer(@RequestBody Player player) {
        if (playerService.findByEmail(player.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }
        Player registeredPlayer = playerService.registerPlayer(player);
        return ResponseEntity.ok(registeredPlayer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticatePlayer(@RequestBody AuthRequest authRequest) {
        try {
            String jwt = playerService.login(authRequest.getEmail(), authRequest.getPassword());
            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }

    @DeleteMapping("/deleteAccountPlayer/{id}")
    public void deletePlayerAccount(@PathVariable("id") Long id) {
            playerService.deleteAccountPlayer(id);
    }

    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
            playerService.updateProfile(id, firstName, lastName, email);
            return ResponseEntity.ok("Profile updated successfully.");
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest, Authentication authentication) {
            String email = authentication.getName();
            playerService.updatePassword(email, passwordChangeRequest);
            return ResponseEntity.ok("Password changed successfully.");
    }

}
