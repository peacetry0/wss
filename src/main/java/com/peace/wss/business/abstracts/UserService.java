package com.peace.wss.business.abstracts;

import com.peace.wss.business.dto.requests.user.CreateUserRequest;
import com.peace.wss.business.dto.requests.user.UpdateUserRequest;
import com.peace.wss.business.dto.responses.user.GetAllUserResponse;
import com.peace.wss.business.dto.responses.user.GetByIdUserResponse;

import java.util.List;

public interface UserService {

    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id) ;
    void create(CreateUserRequest createUserRequest) ;
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id) ;
}
