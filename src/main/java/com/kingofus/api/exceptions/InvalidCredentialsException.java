package com.kingofus.api.exceptions;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(){
        super("Username OR password doesn't match with our records. Please check and retry!");
    }
}
