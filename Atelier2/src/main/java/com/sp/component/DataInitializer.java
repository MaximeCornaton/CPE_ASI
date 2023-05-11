/**
 * 
 */
package com.sp.component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.model.Card;
import com.sp.service.CardService;

/**
 * @author paulaubry
 *
 */
@Component
public class DataInitializer implements CommandLineRunner {
	
    @Autowired
    private CardService cardService;

	@Override
	public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {//getClass().getClassLoader().getResource("static/json/cards.json").getPath()
            List<Card> cards = Arrays.asList(objectMapper.readValue(new File(getClass().getClassLoader().getResource("static/json/cards.json").getPath()), Card[].class));
            cardService.saveAll(cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
