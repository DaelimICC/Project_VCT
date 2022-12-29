package com.daelim.icc.vctserver.constdata;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public abstract class ObjectMapping {
    private ObjectMapper objectMapper = new ObjectMapper();
    protected HttpStatus httpStatus;
    protected Object msg;

    public ResponseEntity<String> makeResponse(){
        try{
            return ResponseEntity.status(httpStatus).body(objectMapper.writeValueAsString(new JsonMessage(msg)));
        }catch (JsonProcessingException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }
}

@Data
@AllArgsConstructor
class JsonMessage{
    private Object msg;
}
