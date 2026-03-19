package ru.itche.userregistryservice.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePatchUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePutUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request,
                                                   UriComponentsBuilder uriBuilder){
        UserResponse response = userService.createUser(request);

        return ResponseEntity.created(
                uriBuilder
                        .path("/api/users/{id}")
                        .buildAndExpand(response.userId())
                        .toUri()
        ).body(response);
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        UserResponse response = userService.getUser(id);

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> responses= userService.getUsers();

        return ResponseEntity.ok()
                .body(responses);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                     @Valid @RequestBody UpdatePutUserRequest request) {
        UserResponse response = userService.updateUser(id, request);

        return ResponseEntity.ok()
                .body(response);
    }

    @PatchMapping("/{id:\\d+}")
    public ResponseEntity<UserResponse> patchUser(@PathVariable Long id,
                                                   @Valid @RequestBody UpdatePatchUserRequest request) {
        UserResponse response = userService.patchUser(id, request);

        return ResponseEntity.ok()
                .body(response);
    }




}
