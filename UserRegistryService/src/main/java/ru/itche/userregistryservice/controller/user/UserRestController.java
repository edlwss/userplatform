package ru.itche.userregistryservice.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Пользователи", description = "Crud-операции для управления сущностью User")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    @Operation(description = "Создание пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Пользователь создан"),
            @ApiResponse(responseCode = "400", description = "Пользователь не создан - некоррекный запрос"),
    })
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
    @Operation(description = "Получение пользователя по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
    })
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        UserResponse response = userService.getUser(id);

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping
    @Operation(description = "Получение всех пользователей")
    @ApiResponse(responseCode = "200", description = "Список пользователей найден")
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> responses= userService.getUsers();

        return ResponseEntity.ok()
                .body(responses);
    }

    @PutMapping("/{id:\\d+}")
    @Operation(description = "Полное обновление данных пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Данные пользователя обновлены"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "400", description = "Пользователь не обновлен - некоррекный запрос")
    })
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                     @Valid @RequestBody UpdatePutUserRequest request) {
        UserResponse response = userService.updateUser(id, request);

        return ResponseEntity.ok()
                .body(response);
    }

    @PatchMapping("/{id:\\d+}")
    @Operation(description = "Частичное/полное обновление данных пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Данные пользователя обновлены"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "400", description = "Пользователь не обновлен - некоррекный запрос")
    })
    public ResponseEntity<UserResponse> patchUser(@PathVariable Long id,
                                                   @Valid @RequestBody UpdatePatchUserRequest request) {
        UserResponse response = userService.patchUser(id, request);

        return ResponseEntity.ok()
                .body(response);
    }

    @DeleteMapping("{id:\\d+}")
    @Operation(description = "Удаление пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь удален"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return ResponseEntity.noContent()
                .build();
    }


}
