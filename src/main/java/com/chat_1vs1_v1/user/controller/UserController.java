package com.chat_1vs1_v1.user.controller;

import com.chat_1vs1_v1.common.DataResponse;
import com.chat_1vs1_v1.user.service.UserService;
import com.chat_1vs1_v1.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MessageMapping("/user.addUser")
    //@SendTo("/topic/public")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    //@SendTo("/topic/public")
    @SendTo("/user/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<?> findConnectedUsers() {
        List<User> users = userService.findConnectedUsers();

        return DataResponse.setDataSearchSuccess(users, "success");
    }
}
