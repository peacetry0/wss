package com.peace.wss.business.dto.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllUserResponse {
    private int id ;
    private String userName ;
    private String password ;
}
