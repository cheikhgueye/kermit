package sn.dsi.kermit.controller;


import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.exception.AppException;
import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Role;
import sn.dsi.kermit.model.RoleName;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.payload.PagedResponse;
import sn.dsi.kermit.payload.SignUpRequest;
import sn.dsi.kermit.payload.UserIdentityAvailability;
import sn.dsi.kermit.payload.UserProfile;
import sn.dsi.kermit.payload.UserSummary;
import sn.dsi.kermit.repository.ObjectifRepository;
import sn.dsi.kermit.repository.StructureRepository;
import sn.dsi.kermit.repository.UserRepository;
import sn.dsi.kermit.security.CurrentUser;
import sn.dsi.kermit.security.UserPrincipal;
import sn.dsi.kermit.util.AppConstants;
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StructureRepository pollRepository;

    @Autowired
    private ObjectifRepository voteRepository;

   

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/users/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

       

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName());

        return userProfile;
    }


    @PutMapping("update/user/{id}")
    public User updateNote(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

}
