package com.uk;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.uk.PokerConstants;
import com.uk.constants.ErrorMessageConstants;
import com.uk.exceptions.PokerException;

public class Poker {

	private static final int POKER_GAME_SIZE = 5;

	private Map<Integer, Integer> sequence2Count;
	private Set<Character> cardSuitType;

	public Poker() {
		sequence2Count = new HashMap<>();
		cardSuitType = new HashSet<>();
	}

	public String pokerGame(String[] inputCards) {
		String outPut = "";
		splitInput(inputCards);
		boolean result = checkFlush(cardSuitType);
		if (result) {
			return PokerConstants.FLUSH;
		}
		int pokerSameRankSize = sequence2Count.size();
		Integer[] seqArray = new Integer[pokerSameRankSize];
		sequence2Count.keySet().toArray(seqArray);

		switch (pokerSameRankSize) {

		case 5:
			if (checkForStraigth(seqArray)) {
				outPut = PokerConstants.STRAIGHT;
			} else {
				outPut = PokerConstants.HIGH_CARD;
			}
			break;
		case 2:
			if (checkFourOfKind(seqArray)) {

				outPut = PokerConstants.FOUR_OF_KIND;
			} else if (checkFullHouse(seqArray)) {
				outPut = PokerConstants.FULL_HOSUE;
			} else {
				outPut = PokerConstants.HIGH_CARD;
			}
			break;
		case 3:
			if (checkThreeOfAKind(seqArray)) {
				outPut = (PokerConstants.THREE_OF_KIND);
			} else if (checkForPair(seqArray)) {
				outPut = PokerConstants.PAIR;
			} else {
				outPut = PokerConstants.HIGH_CARD;
			}
			break;
		case 4:
			if (checkForPair(seqArray)) {
				outPut = PokerConstants.PAIR;
			} else {
				outPut = PokerConstants.HIGH_CARD;
			}
			break;
		default:
			outPut = PokerConstants.HIGH_CARD;
		}
		return outPut;
	}

	public boolean checkThreeOfAKind(Integer[] seqArray) {
		boolean isThreeOfKind = false;
		for (int number : seqArray) {
			if (getSameSequenceCount(number) == 3) {
				isThreeOfKind = true;
			}
		}
		return isThreeOfKind;
	}

	public boolean checkFullHouse(Integer[] seqArray) {
		boolean isFullHosue = false;
		if (checkForPair(seqArray) && checkThreeOfAKind(seqArray)) {
			isFullHosue = true;
		}
		return isFullHosue;
	}

	public boolean checkForPair(Integer[] seqArray) {
		boolean isPair = false;
		for (int number : seqArray) {
			if (getSameSequenceCount(number) == 2) {
				isPair = true;
			}
		}
		return isPair;

	}

	public boolean checkForStraigth(Integer[] seqArray) {
		boolean isStraigth = false;
		Arrays.sort(seqArray);
		int sequenceCounter = 0;
		for (int j = seqArray.length - 1; j > 0; j--) {

			if (seqArray[j] - 1 != seqArray[j - 1]) {
				break;
			}
			sequenceCounter++;
		}
		if (sequenceCounter == 3 && seqArray[0] == 1) {
			sequenceCounter++;
		}
		if (sequenceCounter == POKER_GAME_SIZE - 1) {
			isStraigth = true;
		}
		return isStraigth;
	}

	private int getSameSequenceCount(Integer key) {
		int counter = sequence2Count.get(key);
		return counter;
	}

	public boolean checkFourOfKind(Integer[] seqArray) {
		boolean isFourOfKind = false;
		for (int number : seqArray) {
			if (getSameSequenceCount(number) == 4) {
				isFourOfKind = true;
			}
		}
		return isFourOfKind;
	}

	public boolean checkFlush(Set<Character> keySet) {
		if (keySet.size() == 1) {
			return true;
		}
		return false;
	}

	public Integer getIntValue(char charValue) {
		Integer convertedValue;
		switch (charValue) {

		case 'A':
			convertedValue = 1;
			break;
		case 'T':
			convertedValue = 10;
			break;
		case 'J':
			convertedValue = 11;
			break;
		case 'Q':
			convertedValue = 12;
			break;
		case 'K':
			convertedValue = 13;
			break;
		default:
			convertedValue = Character.getNumericValue(charValue);
			break;
		}
		return convertedValue;
	}

	public void checkDuplicates(String[] inputs) {
		if (inputs.length < POKER_GAME_SIZE){
			throw new PokerException(ErrorMessageConstants.INVALID_INPUT);
		}
		Set<String> pokerInputs = new HashSet<>();
		Collections.addAll(pokerInputs, inputs);
		if (pokerInputs.size() != POKER_GAME_SIZE) {
			throw new PokerException(ErrorMessageConstants.INVALID_INPUT);
		}
	}

	public void splitInput(String[] inputs) {
		checkDuplicates(inputs);
		for (String s : inputs) {
			char cardSuit = s.charAt(0);
			cardSuitType.add(cardSuit);
			char sequenceNumber = s.charAt(1);
			Integer sequenceInt = getIntValue(sequenceNumber);
			Integer sequenceCounter = sequence2Count.get(sequenceInt);
			if (sequenceCounter == null) {
				sequenceCounter = 0;
			}
			sequence2Count.put(sequenceInt, ++sequenceCounter);
		}

	}

	public static void main(String[] args) {
		Poker poker = new Poker();
		System.out.println(poker.pokerGame(new String[] {"HA" , "CA" , "D2" , "D8" , "C2"}));
	}
}
