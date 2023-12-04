package org.example.vlume.providers.modelprovider.userprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vlume.models.User;

import java.io.File;
import java.io.IOException;

public class UserProvider {
    User user;

    public User createValidUser() {

        try {
            File file = new File("src/main/resources/userdata/valid_user_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(file, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
