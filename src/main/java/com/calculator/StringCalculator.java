package com.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * The StringCalculator class provides methods to perform mathematical
 * operations on a string of numbers.
 * It supports addition, subtraction, multiplication, and division operations.
 * 
 * @author mmahipalr
 * @implNote This class is a simple calculator that can perform basic arithmetic
 *           operations on a string of numbers.
 * 
 */
public class StringCalculator {
    /**
     * The extractDelimiter method extracts the delimiter from the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the delimiter extracted from the input string
     */
    private String extractDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            return numbers.substring(2, numbers.indexOf("\n"));
        }
        return ",";
    }

    /**
     * The extractNumbers method extracts the numbers from the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the numbers extracted from the input string
     */
    private String extractNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            int index = numbers.indexOf("\n");
            return numbers.substring(index + 1);
        }
        return numbers;
    }

    /**
     * The validateAndReplaceString method replace delimiter with ',' so that we can extract all numbers with same delimiter.
     * remove spaces between numbers
     * 
     * @param numbers the input string containing numbers and delimiter
     * @param delimiter the delimiter used to separate the numbers
     * @return the numbers extracted from the input string
     */
    private String validateAndReplaceString(String numbers, String delimiter) {
    	numbers = numbers.replace(delimiter,",");
    	return numbers.replace(" ", "");
    }
    
    /**
     * The parseNumbers method parses the numbers from the input string.
     * 
     * @param numbers   the input string containing numbers and delimiter
     * @param delimiter the delimiter used to separate the numbers
     * @return an array of parsed numbers
     */
    private int[] parseNumbers(String numbers, String delimiter) {
        String[] nums = numbers.split("[\n" + delimiter + "]");
        int[] parsedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parsedNums[i] = Integer.parseInt(nums[i]);
        }
        return parsedNums;
    }

    /**
     * The ensureNoNegatives method ensures that the input numbers do not contain
     * any negative numbers.
     * 
     * @param nums the array of numbers to check for negatives
     * @throws IllegalArgumentException if any negative numbers are found
     */
    private void ensureNoNegatives(int[] nums) {
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                negatives.add(num);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
    }

    /**
     * The calculateSum method calculates the sum of the numbers.
     * 
     * @param nums the array of numbers to calculate the sum
     * @return the sum of the numbers
     */
    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * Adds the numbers in the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the sum of the numbers
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        numbers = validateAndReplaceString(numbers, delimiter);
        int[] nums = parseNumbers(numbers, ",");
        ensureNoNegatives(nums);

        return calculateSum(nums);
    }
}