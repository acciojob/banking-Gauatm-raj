package com.driver;


import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000.00);
       this.tradeLicenseId=tradeLicenseId;

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if (balance < 5000) {
            throw new Exception("Insufficient Balance. Minimum balance required is 5000.");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                throw new Exception("Valid License can not be generated");
            }
        }
        if(!canValid()){
            throw new Exception("Valid License can not be generated");
        }
    }
    public boolean canValid(){
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : tradeLicenseId.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if all character counts are even (allowing at most one character with an odd count)
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false; // More than one character with an odd count
                }
            }
        }

        return true;
    }

}
