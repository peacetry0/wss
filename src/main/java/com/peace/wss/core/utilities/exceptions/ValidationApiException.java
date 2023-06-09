package com.peace.wss.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationApiException extends  ApiException{
    private Map<String,String> validationErrors;
}
