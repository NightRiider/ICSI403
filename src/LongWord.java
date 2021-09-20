/**
 * ICSI404 - Assembly Computer Organization
 * Amiya Bhattacharya
 * 9/15/21 - Assignment #1
 * Version 1 - JP Aliprantis, SB
 */

import java.util.BitSet;
import java.util.Random;

public class LongWord {

    private final BitSet bitSet = new BitSet(32);

    public LongWord() {
        for (int i = 0; i < 32; i++) {
            bitSet.set(i, new Random().nextBoolean());
        }
    }

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

    public int getSigned() {

        int decimal = 0;

        // 00000000 00000000 00000000 00000000
        // 01000000 00000000 00000000 00000000

        for (int i = 0; i < 32; i++) {
            if (!bitSet.get(i)) {
                decimal += Math.pow(2, i);
            }
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