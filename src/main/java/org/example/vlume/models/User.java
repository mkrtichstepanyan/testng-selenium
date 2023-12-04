package org.example.vlume.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
