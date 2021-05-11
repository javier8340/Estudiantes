package com.anderjavi.estudiantes.exceptions.resolver;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResolver {

   public ResponseEntity<String> resolver(Exception exception){
       ResponseEntity<String> responseEntity = null;

      if (exception instanceof DataIntegrityViolationException){

          String message = ((DataIntegrityViolationException) exception).getMostSpecificCause().getMessage();

          responseEntity =  new ResponseEntity<String>("{status:401,message:"+
                  message+
                  "}", HttpStatus.UNAUTHORIZED);
      }else{
          responseEntity = new ResponseEntity<String>("{status:401,message:"+
                  exception.getCause().getMessage()+"}",HttpStatus.UNAUTHORIZED);
      }
      return responseEntity;
   }
}
