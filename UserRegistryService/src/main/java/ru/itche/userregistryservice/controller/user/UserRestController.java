package ru.itche.userregistryservice.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request,
                                                   UriComponentsBuilder uriBuilder){

        UserResponse response = userService.createUser(request);

        return ResponseEntity.created(
                uriBuilder
                        .path("/{id}")
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

}
