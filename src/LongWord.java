/**
 * ICSI404 - Assembly Computer Organization
 * Amiya Bhattacharya
 * 9/15/21 - Assignment #1
 * Version 1 - JP Aliprantis, SB
 */

import java.util.BitSet;
import java.util.Random;

public class LongWord {

    private BitSet bitSet = new BitSet(32);

    public boolean getBit(int i) {
        return bitSet.get(i);
    }

    public void setBit(int i) {
        bitSet.set(i, true);
    }

    public void clearBit(int i) {
        bitSet.clear(i);
    }

    public void toggleBit(int i) {
        bitSet.set(i, !bitSet.get(i));
    }

    public boolean isZero() {
        return bitSet.length() == 0;
    }

    public LongWord and(LongWord other) {
        LongWord newLongWord = new LongWord();
        //newLongWord.copy(this);
        bitSet.and(other.bitSet);

        return newLongWord;
    }

    public LongWord not(LongWord other) {
        for(int i = 0; i < 32; i++) {
            if(!bitSet.get(i)) {
                other.setBit(i);
            }
        }
        return other;
    }

    public void copy(LongWord other) {
        bitSet = (BitSet) other.bitSet.clone();
    }

    // LongWord shiftLeftLogical(int amount); // left-shift this long-word by
    // amount bits (padding with 0’s), creates a new long-word

    // 0110 1001
    // 1010 0100
    // shift by 2

    public LongWord shiftRightLogical(int amount) {

        LongWord newLongWord = new LongWord();

        for (int i = amount; i < 32; i++) {
            if (bitSet.get(i - amount)) {
                newLongWord.setBit(i);
            }
        }

        return newLongWord;
    }

    public LongWord shiftLeftLogical(int amount) {

        LongWord newLongWord = new LongWord();

        for (int i = amount; i < 32; i++) {

            if (bitSet.get(i - amount)) {
                newLongWord.setBit(31 - i);
            }
        }

        return newLongWord;
    }

    //LongWord shiftRightArithmetic(int amount);// right-shift this long-word
    //by amount bits (sign-extending), creates a new long-word
    public LongWord shiftRightArithmetic(int amount) {

        LongWord newLongWord = new LongWord();

        for (int i = 0; i < 32; i++) {
            if (bitSet.get(i)) {
                int newIndex = i + amount;
                newLongWord.setBit(newIndex > 31 ? i : newIndex);
            }
        }

        return newLongWord;
    }

    public void set(int value) {

        int index = 0;

        while (value != 0) {

            if (value % 2 != 0) {
                bitSet.set(31 - index);
            } else {
                bitSet.clear(31 - index);
            }

            index++;
            value = value >>> 1;
        }

    }


    public long getUnsigned() {

        long decimal = 0;

        for (int i = 31; i >= 0; i--) {
            if (bitSet.get(i)) {
                decimal += Math.pow(2, 31 - i);
            }
        }

        return decimal;

    }


    public int getSigned() {

        int decimal = 0;

        // If number is not negative, find the decimal value
        for (int i = 1; i < 32; i++) {

            if (bitSet.get(i)) {
                decimal += Math.pow(2, 31 - i);
            }
        }
        if (bitSet.get(0)) {
            decimal -= Math.pow(2, 31);
        }

        return decimal;
    }

    @Override
    public String toString() {

        StringBuilder bits = new StringBuilder();
        StringBuilder hex = new StringBuilder();
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