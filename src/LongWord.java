/**
 * ICSI404 - Assembly Computer Organization
 * Amiya Bhattacharya
 * 9/15/21 - Assignment #1
 * Version 1 - JP Aliprantis, SB
 */

import java.util.BitSet;

public class LongWord {

    private BitSet bitSet = new BitSet(32);

    public LongWord() {

    }


    private LongWord(BitSet bitSet) {
        this.bitSet = bitSet;
    }

    // Gets the value of a bit at index i
    public boolean getBit(int i) {
        return bitSet.get(31 - i);
    }

    // Sets a specific bit to be true
    public void setBit(int i) {
        bitSet.set(31 - i);
    }

    // Sets a specific bit to be a specific value (T|F)
    public void setBit(int i, boolean value) {
        bitSet.set(31 - i, value);
    }

    // Clears the bit at a specific index
    public void clearBit(int i) {
        bitSet.clear(31 - i);
    }

    // Flips the bit of the specified index
    public void toggleBit(int i) {
        bitSet.set(31 - i, !bitSet.get(31 - i));
    }

    // Returns if the bits are all zeroes or not
    public boolean isZero() {
        return bitSet.length() == 0;
    }

    // Performs a logical AND comparison between two long words, returning a new one
    public LongWord and(LongWord other) {
        LongWord result = new LongWord();

        for (int i = 0; i < 32; i++) {
            result.bitSet.set(i, bitSet.get(i) && other.bitSet.get(i));
        }

        return result;
    }

    // Performs a logical OR comparison between two long words, returning a new one
    public LongWord or(LongWord other) {
        LongWord result = new LongWord();

        for (int i = 0; i < 32; i++) {
            result.bitSet.set(i, bitSet.get(i) || other.bitSet.get(i)); // Sets the bit for OR of the 2 bitSets
        }

        return result;
    }

    // Performs a logical XOR comparison between two long words, returning a new one
    public LongWord xor(LongWord other) {
        LongWord result = new LongWord();

        for (int i = 0; i < 32; i++) {
            result.bitSet.set(i, bitSet.get(i) != other.bitSet.get(i));
        }

        return result;
    }

    // Flips the bits in the binary representation
    // 1 -> 0 and 0 -> 1
    public LongWord not() {
        LongWord newLongWord = new LongWord();

        for (int i = 0; i < 32; i++) {
            newLongWord.setBit(i, !getBit(i));
        }

        return newLongWord;
    }

    // Copies the values from one bitSet and places them into another bitSet
    public void copy(LongWord other) {
        bitSet = (BitSet) other.bitSet.clone();
    }

    // Shifts the bits to the right by amount, padding with 0s
    public LongWord shiftRightLogical(int amount) {
        LongWord newLongWord = new LongWord();


        for (int i = amount; i < 32; i++) {
            if (bitSet.get(i - amount)) {
                newLongWord.setBit(31 - i);
            }
        }

        return newLongWord;
    }

    // Shifts the bits to the left by amount, padding with 0s
    public LongWord shiftLeftLogical(int amount) {
        return new LongWord(bitSet.get(amount, Math.max(amount, bitSet.length())));
    }

    // Right Shifts the long word by amount
    // with sign-extending
    public LongWord shiftRightArithmetic(int amount) {
        LongWord newLongWord = new LongWord();

        for (int i = amount; i < 32; i++) {
            if (bitSet.get(i - amount)) {
                newLongWord.setBit(31 - i);
            }
        }

        newLongWord.bitSet.set(0, amount, bitSet.get(0));

        return newLongWord;
    }

    // Sets the bitSet values to the correct binary representation of number value
    public void set(int value) {
        int index = 0;

        while (value != 0) {

            if (value % 2 != 0) { // if multiple of 2
                bitSet.set(31 - index);
            } else {
                bitSet.clear(31 - index);
            }

            index++;
            value = value >>> 1; // shifts the value by 1
        }
    }

    // Calculates decimal value from the binary representation
    // Positive numbers only
    public long getUnsigned() {
        long decimal = 0;

        // Calculates only positive number from binary representation
        // Adds to sum of powers of 2 for true bits
        for (int i = 0; i < 32; i++) {
            if (bitSet.get(i)) {
                decimal += Math.pow(2, 31 - i);
            }
        }

        return decimal;
    }

    // Calculates decimal value from the binary representation
    // Also accounts for two's complement
    public int getSigned() {
        int decimal = 0;

        // If number is not negative, find the decimal value by adding up powers of 2 on true bits
        for (int i = 1; i < 32; i++) {
            if (bitSet.get(i)) {
                decimal += Math.pow(2, 31 - i);
            }
        }
        // If most significant bit is 1, subtract it from the current total sum to get 2s complement
        if (bitSet.get(0)) {
            decimal -= Math.pow(2, 31);
        }

        return decimal;
    }

    @Override
    // Returns the binary and hex representation of a long word
    public String toString() {
        StringBuilder bits = new StringBuilder(); // holds binary representation of number
        StringBuilder hex = new StringBuilder(); // holds hex representation of number
        int space = 1; // used to know when to add space and convert to hex

        for (int i = 0; i < 32; i++) {
            bits.append(bitSet.get(i) ? 1 : 0); // Appends each bit to the StringBuilder

            if (space % 4 == 0) {
                String binary = bits.substring(space + (space / 4) - 5, space + (space / 4) - 1); // gets last 4 bits
                hex.append(Integer.toHexString(Integer.parseInt(binary, 2)).toUpperCase()); // converts the 4 bits to hexadecimal
                bits.append(' '); // appends space to byte representation
            }

            space++;
        }

        // Separates binary and hex representation
        bits.append("\t0x");

        return bits.append(hex).toString();
    }
}