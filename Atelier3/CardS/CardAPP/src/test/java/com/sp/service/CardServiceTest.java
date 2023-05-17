/**
 * 
 */
package com.sp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sp.model.Affinity;
import com.sp.model.Card;
import com.sp.model.Family;
import com.sp.repository.CardRepository;

import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author valentinb
 *
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CardService.class)
class CardServiceTest {
	
	@MockBean
	CardRepository cRepo;
	
	@Autowired
	private CardService cSer;
	
	private Set<Card> test = new HashSet<Card>();
	private List<Card> testL = new ArrayList<Card>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("[Before test] --- Creating Card for test");
		Card c1 = new Card(1,"val","c valentin","url", Family.Bird, Affinity.Electric, 2000, 150, 100, 500, 699);
		Card c2 = new Card(2,"max","c maxile","url", Family.Marvel, Affinity.Water, 2000, 150, 100, 500, 699);
		Card c3 = new Card(3,"pol","c paul","url", Family.Tree, Affinity.Fire, 2000, 150, 100, 500, 699);
		Card c4 = new Card(4,"rodo","c rodolphe","url", Family.DC, Affinity.Wind, 2000, 150, 100, 500, 699);
		Card c5 = new Card(5,"chien","c hien","url", Family.DC, Affinity.Poison, 2000, 150, 100, 500, 699);
		test.add(c1);
		test.add(c2);
		test.add(c3);
		test.add(c4);
		test.add(c5);
		testL.add(c1);
		testL.add(c2);
		testL.add(c3);
		testL.add(c4);
		testL.add(c5);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("[After Test] --- Cleaning Cards");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getCard(int)}.
	 */
	@Test
	void testGetCard() {
		
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getCards()}.
	 */
	@Test
	void testGetCards() {
		Mockito.when(
				cRepo.findAll()
				).thenReturn(test);
		
		assertEquals(test, cSer.getCards());
		
	}

	/**
	 * Test method for {@link com.sp.service.CardService#get5cards()}.
	 */
	@Test
	void testGet5cards() {
	
		
	}

	/**
	 * Test method for {@link com.sp.service.CardService#updateCard(com.sp.model.Card)}.
	 */
	@Test
	void testUpdateCard() {
		Card newc = new Card(1,"val","c valentin","url", Family.Bird, Affinity.Electric, 0, 0, 0, 0, 0);
		Mockito.when(
				cRepo.save(Mockito.any())
				).thenReturn(newc);
		
		assertEquals(newc, cSer.updateCard(newc));
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getPrice(int)}.
	 */
	@Test
	void testGetPrice() {
		Card c1 = new Card(1,"val","c valentin","url", Family.Bird, Affinity.Electric, 2000, 150, 100, 500, 699);
		
		Mockito.when(
				cRepo.findByidCard(1)
				).thenReturn(Optional.ofNullable(c1));
		
		assertEquals(699, cSer.getPrice(1));
	
	}

	/**
	 * Test method for {@link com.sp.service.CardService#addCard(com.sp.model.Card)}.
	 */
	@Test
	void testAddCard() {
		Card c1 = new Card(1,"val","c valentin","url", Family.Bird, Affinity.Electric, 2000, 150, 100, 500, 699);
		Mockito.when(
				cRepo.save(Mockito.any())
				).thenReturn(c1);
		
		assertEquals(c1, cSer.updateCard(c1));
	}



}
