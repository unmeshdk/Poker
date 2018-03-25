package com.uk.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uk.Poker;
import com.uk.exceptions.PokerException;




public class PokerGameTest {

	protected static final String FLUSH = "FLUSH";
	protected static final String THREE_OF_KIND = "THREE_OF_KIND";
	protected static final String FOUR_OF_KIND = "FOUR_OF_KIND";
	protected static final String FULL_HOSUE = "FULL_HOSUE";
	protected static final String STRAIGHT = "STRAIGHT";
	protected static final String PAIR = "PAIR";
	protected static final String HIGH_CARD = "HIGH_CARD";


	public static String INVALID_INPUT ="Invalid Inputs";
	
	
	@Test(expected = PokerException.class)
	public void testInvalidPokerCardSequenceLength(){
		Poker pk = new Poker();
		assertEquals(INVALID_INPUT, pk.pokerGame(new String[] { "C6" , "CJ" , "H3" , "S9"}));
	}

	
	@Test
	public void testPairStart(){
		Poker pk = new Poker();
		assertEquals(PAIR, pk.pokerGame(new String[] {"HA" , "CA" , "D2" , "D8" , "C2"}));
	}
	

	@Test
	public void testPairMid(){
		Poker pk = new Poker();
		assertEquals(PAIR,pk.pokerGame(new String[] {"H5" , "CA" , "H4" , "S4" , "D7"}));
	}

	@Test
	public void test2PairMid() {
		Poker pk = new Poker();
		assertEquals(PAIR, pk.pokerGame(new String[] {"D6" , "C8" , "H8" , "S7" , "H7"}));
	}
	
	@Test
	public void testFullHouseRandom1(){
		Poker pk = new Poker();
		assertEquals(FULL_HOSUE, pk.pokerGame(new String[] {"HA" , "CA" , "D2" , "DA" , "C2"}));
	}
	
	@Test
	public void testFullHouseRandom2() {
		Poker pk = new Poker();
		assertEquals(FULL_HOSUE, pk.pokerGame(new String[] {"HA" , "S2" , "C2" , "D2" , "SA"}));
	}

	@Test
	public void testFullHouseStart() {
		Poker pk = new Poker();
		assertEquals(FULL_HOSUE,pk.pokerGame(new String[] {"HA" , "CA" , "DA" , "S4" , "D4"}));
	}

	@Test
	public void testFullHouseEnd() {
		Poker pk = new Poker();
		assertEquals(FULL_HOSUE, pk.pokerGame(new String[] {"D6" , "C6" , "H8" , "S8" , "C8"}));
	}
	
	@Test
	public void testFullHouseRandom3() {
		Poker pk = new Poker();
		assertEquals(FULL_HOSUE, pk.pokerGame(new String[] {"D6" , "H8" , "C8" , "C6" , "S8"}));
	}
	
	
	
	
	@Test
	public void testThreeOfKindStarting() {
		Poker pk = new Poker();
		assertEquals(THREE_OF_KIND, pk.pokerGame(new String[] {"HA" , "H2" , "CA" , "DA" , "C8"}));
	}
	

	@Test
	public void testThreeOfKindMid() {
		Poker pk = new Poker();
		assertEquals(THREE_OF_KIND,pk.pokerGame(new String[] {"H2" , "CA" , "HA" , "SA" , "H6"}));
	}

	@Test
	public void testFourOfKindStart() {
		Poker pk = new Poker();
		assertEquals(FOUR_OF_KIND, pk.pokerGame(new String[] {"D8" , "C8" , "H8" , "S8" , "HA"}));
	}
	
	@Test
	public void testFourOfKindEnd() {
		Poker pk = new Poker();
		assertEquals(FOUR_OF_KIND, pk.pokerGame(new String[] {"C3" , "S8" , "C8" , "H8" , "D8"}));
	}
	
	@Test
	public void testFlushHSuit() {
		Poker pk = new Poker();
		assertEquals(FLUSH, pk.pokerGame(new String[] {"H2" , "H8" , "H4" , "H5" , "H6"}));
	}
	
	@Test
	public void testFlushCSuit() {
		Poker pk = new Poker();
		assertEquals(FLUSH, pk.pokerGame(new String[] {"CT" , "CJ" , "CQ" , "CK" , "CA"}));
	}
	
	@Test
	public void testFlushDSuit() {
		Poker pk = new Poker();
		assertEquals(FLUSH, pk.pokerGame(new String[] {"D4" , "D5" , "D6" , "D7" , "D8"}));
	}
	
	@Test
	public void testFlushSSuit() {
		Poker pk = new Poker();
		assertEquals(FLUSH, pk.pokerGame(new String[] {"S2" , "S8" , "S4" , "S5" , "S9"}));
	}
	
	@Test
	public void testThreeOfKindDescendingInput() {
		Poker pk = new Poker();
		assertEquals(THREE_OF_KIND, pk.pokerGame(new String[] {"CA" , "S2" , "D6" , "H6" , "C6"}));
	}
	
	@Test
	public void testStraightstartwithA() {
		Poker pk = new Poker();
		assertEquals(STRAIGHT, pk.pokerGame(new String[] {"CA" , "S2" , "S3" , "D4" , "H5"}));
	}
	
	@Test
	public void testStraightsEndsWithA() {
		Poker pk = new Poker();
		assertEquals(STRAIGHT,pk.pokerGame(new String[] {"CT" , "DJ" , "CQ" , "CK" , "CA"}));
	}
	
	@Test
	public void testStraightOther() {
		Poker pk = new Poker();
		assertEquals(STRAIGHT, pk.pokerGame(new String[] {"H4" , "C5" , "C6" , "S7" , "D8"}));
	}
	
	@Test
	public void testStraightOtherEndswithT() {
		Poker pk = new Poker();
		assertEquals(STRAIGHT, pk.pokerGame(new String[] { "C6" , "D7" , "H8" , "S9" , "CT"}));
	}
	
	@Test
	public void testStraightDescending() {
		Poker pk = new Poker();
		assertEquals(STRAIGHT, pk.pokerGame(new String[] {"CA" , "SK" , "HQ" , "DJ" , "HT"}));
	}

	@Test
	public void testHighCard1() {
		Poker pk = new Poker();
		assertEquals(HIGH_CARD, pk.pokerGame(new String[] {"CA" , "S2" , "D6" , "H4" , "C5"}));
	}
	
	@Test
	public void testHighCard2() {
		Poker pk = new Poker();
		assertEquals(HIGH_CARD,pk.pokerGame(new String[] {"S2", "D5", "C7","ST","HA"}));
	}
	
	@Test
	public void testHighCard3() {
		Poker pk = new Poker();
		assertEquals(HIGH_CARD, pk.pokerGame(new String[] {"H4" , "CA" , "S6" , "CT" , "D8"}));
	}
	
	@Test
	public void testHighCard4() {
		Poker pk = new Poker();
		assertEquals(HIGH_CARD, pk.pokerGame(new String[] { "C6" , "CJ" , "H3" , "S9" , "CT"}));
	}

}
