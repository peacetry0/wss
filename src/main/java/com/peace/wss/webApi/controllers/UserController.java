package com.peace.wss.webApi.controllers;

import com.peace.wss.business.abstracts.UserService;
import com.peace.wss.business.dto.requests.user.CreateUserRequest;
import com.peace.wss.business.dto.requests.user.UpdateUserRequest;
import com.peace.wss.business.dto.responses.user.GetAllUserResponse;
import com.peace.wss.business.dto.responses.user.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService ;


    @GetMapping()
    public List<GetAllUserResponse> getAll(){
        return this.userService.getAll() ;
    }

    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable() int id ){
        return this.userService.getById(id) ;
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody() @Valid() CreateUserRequest createUserRequest){
        this.userService.create(createUserRequest);
    }
    @PutMapping("/update/{id}")
    public void update( @RequestBody() UpdateUserRequest updateUserRequest){
       this.userService.update(updateUserRequest);
    }
    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable int id ){
        this.userService.delete(id);
    }
}
