package com.peace.wss.business.rules;

import com.peace.wss.core.utilities.exceptions.InvalidUserNameException;
import com.peace.wss.core.utilities.exceptions.UserNotFoundException;
import com.peace.wss.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRules {

    private final UserRepository userRepository ;
    public void checkIfUserIdExists(int id){
         if (!(this.userRepository.existsById(id))){
             throw new UserNotFoundException("User Not found") ;
        }
    }
    public void checkIfUserNameExists(String userName){
        if (this.userRepository.existsByUserName(userName)){
            throw new InvalidUserNameException("Username alreay exists") ;
        }
    }

}
