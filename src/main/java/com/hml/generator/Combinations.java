package com.hml.generator;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

public class Combinations {
	
	/**
	 * Generates binary string of which most are unique
	 * This is just test data
	 */
	public void generateCombinations(){
		
		for(int num = 0; num < 100; ++ num){
			
			String binaryStr = Integer.toBinaryString(num);
			String csvBinaryString = "";
			for(int c = 0; c < binaryStr.length(); ++c){
				
				if(c == binaryStr.length() - 1){
					csvBinaryString += binaryStr.charAt(c);
				}
				else {
					csvBinaryString += binaryStr.charAt(c) + ",";
				}
			}
			
			PrintUtils.println(csvBinaryString+getTrailingDigits(binaryStr));
		}
	}
	
	public void generateCombinationsArrayForClustering(){
		
		for(int num = 0; num < 100; ++ num){
			
			String binaryStr = Integer.toBinaryString(num);
			String csvBinaryString = "";
			for(int c = 0; c < binaryStr.length(); ++c){
				
				if(c == binaryStr.length() - 1){
					csvBinaryString += binaryStr.charAt(c);
				}
				else {
					csvBinaryString += binaryStr.charAt(c) + ",";
				}
			}
			
			PrintUtils.println("{"+
					csvBinaryString+getTrailingDigits(binaryStr)+"},");
		}
	}
	
	public String[] generateStringHeadersForClustering(int amount){
		
		List<String> headers = new ArrayList<String>();
		for(int counter = 1; counter <= amount; ++counter){
			headers.add(String.valueOf(counter));
		}
		
        String[] names = new String[headers.size()];
        
		return headers.toArray(names);

	}
	
	private String getTrailingDigits(String num){
		
		int iNum = num.length();
		int maxLength = 9;
		
		int numberDigits = maxLength - iNum;
		
		String returnVal = "";
		
		for(int c = 0; c < numberDigits; ++c){
			returnVal += ",0";
		}
		
		return returnVal;
	}


}
