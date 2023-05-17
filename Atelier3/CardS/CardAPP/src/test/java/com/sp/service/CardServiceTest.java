/**
 * 
 */
package com.sp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sp.model.Affinity;
import com.sp.model.Card;
import com.sp.model.Family;

/**
 * @author valentinb
 *
 */
class CardServiceTest {
	
	private CardService cSer;
	private Card c1;
	private Card c2;
	private Card c3;
	private Card c4;
	private Card c5;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("[Before test] --- Creating Card for test");
		Card c1 = new Card("val","c valentin","url", Family.Bird, Affinity.Electric, 2000, 150, 100, 500, 699);
		Card c2 = new Card("max","c maxile","url", Family.Marvel, Affinity.Water, 2000, 150, 100, 500, 699);
		Card c3 = new Card("pol","c paul","url", Family.Tree, Affinity.Fire, 2000, 150, 100, 500, 699);
		Card c4 = new Card("rodo","c rodolphe","url", Family.DC, Affinity.Wind, 2000, 150, 100, 500, 699);
		Card c5 = new Card("chien","c hien","url", Family.DC, Affinity.Poison, 2000, 150, 100, 500, 699);
		
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
		assertEquals(c1, cSer.getCard(1));
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getCards()}.
	 */
	@Test
	void testGetCards() {
		Set<Card> test = new HashSet<Card>();
		assertEquals(test.getClass().getSimpleName(),cSer.getCards().getClass().getSimpleName());
		assertEquals(test.size(), cSer.getCards().getClass().getSimpleName().length());
	}

	/**
	 * Test method for {@link com.sp.service.CardService#get5cards()}.
	 */
	@Test
	void testGet5cards() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#updateCard(com.sp.model.Card)}.
	 */
	@Test
	void testUpdateCard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getPrice(int)}.
	 */
	@Test
	void testGetPrice() {
		assertEquals(699, cSer.getPrice(1));
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#addCard(com.sp.model.Card)}.
	 */
	@Test
	void testAddCard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#saveAll(java.util.List)}.
	 */
	@Test
	void testSaveAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.service.CardService#getCardBuyable()}.
	 */
	@Test
	void testGetCardBuyable() {
		fail("Not yet implemented");
	}

}
