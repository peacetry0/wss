package com.peace.wss.business.dto.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {
    private int id ;
    @NotNull
    @NotBlank
    @Size(min = 3,max = 10)
    private String userName ;
    @NotNull
    @NotBlank
    @Size(min = 3,max = 10)
    private String password ;
}
