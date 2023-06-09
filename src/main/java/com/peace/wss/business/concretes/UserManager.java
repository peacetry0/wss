package com.peace.wss.business.concretes;

import com.peace.wss.business.abstracts.UserService;
import com.peace.wss.business.dto.requests.user.CreateUserRequest;
import com.peace.wss.business.dto.requests.user.UpdateUserRequest;
import com.peace.wss.business.dto.responses.user.GetAllUserResponse;
import com.peace.wss.business.dto.responses.user.GetByIdUserResponse;
import com.peace.wss.business.rules.UserRules;
import com.peace.wss.core.utilities.exceptions.UserNotFoundException;
import com.peace.wss.core.utilities.mapper.ModelMapperService;
import com.peace.wss.dataAccess.UserRepository;
import com.peace.wss.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository ;
    private final ModelMapperService modelMapperService ;
    private final UserRules userRules ;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUserResponse> responses = users.stream()                                       //Strean bir dizi üzerinde farklı işlemler yapmamızı salar
                .map(user -> this.modelMapperService
                        .forResponse()
                        .map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());                                                     //Streamdaki tüm öğreleri bir liste halinde toplar
        return responses;
    }

    @Override
    public GetByIdUserResponse getById(int id) {

        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found")) ;
        GetByIdUserResponse response = this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);
        return response;
    }

    @Override
    public void create(CreateUserRequest createUserRequest) {
        this.userRules.checkIfUserNameExists(createUserRequest.getUserName());
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);   //ModelMapperMapping
        this.userRepository.save(user);

    /*      User user = new User() ;                              //ManuelMapping
         user.setUserName(createUserRequest.getUserName());
         user.setPassword(createUserRequest.getPassword());
         this.userRepository.save(user);*/

    }

    @Override
    public void update( UpdateUserRequest updateUserRequest) {
        User updateUser = this.modelMapperService.forRequest().map(updateUserRequest, User.class);

         this.userRepository.save(updateUser) ;


    }

    @Override
    public void delete(int id) {
         this.userRules.checkIfUserIdExists(id);
          this.userRepository.deleteById(id);
    }
}
