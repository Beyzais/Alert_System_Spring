package com.data.springboot_data.error;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(Long id){

        super("Book id not found :" + id);
    }

}
