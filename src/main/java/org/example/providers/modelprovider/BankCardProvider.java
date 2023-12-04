package org.example.providers.modelprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.BankCard;

import java.io.File;
import java.io.IOException;

public class BankCardProvider {
    BankCard bankCard;

    public BankCard createValidCardData() {
        try {
            File file = new File("src/main/resources/bank_card_data/valid_bank_card_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            bankCard = objectMapper.readValue(file, BankCard.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankCard;
    }


}
