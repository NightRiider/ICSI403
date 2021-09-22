public class TestLongWord {

    public static void main(String[] args) {
        LongWord word = new LongWord();

        System.out.println();
        System.out.println("==============================================================================");
        word.set(162356);
        System.out.println("Original:               " + word);
        System.out.println("Signed:                 " + word.getSigned()); // getSigned method test
        System.out.println("Unsigned:               " + word.getUnsigned()); // getUnSigned method test
        System.out.println("4th bit value:          " + word.getBit(4)); // good
        word.setBit(1);
        System.out.println("setBit at index 1:      " + word); // good
        word.clearBit(1);
        System.out.println("ClearBit at index 1:    " + word); // good
        word.toggleBit(3);
        System.out.println("ToggleBit at index 3:   " + word); // good
        System.out.println();

        LongWord word1 = new LongWord();
        word1.set(0);
        System.out.println("Word1:                  " + word1);
        System.out.println("isZero on word1:        " + word1.isZero()); // good
        System.out.println();

        LongWord word2 = new LongWord();
        word2.set(Integer.MAX_VALUE - 5);
        System.out.println("WORD 2:                 " + word2);
        word.copy(word2); // copy() method test
        System.out.println("WORD 2 COPIED to WORD:  " + word); // good

        // Set method test - GOOD
        LongWord set = new LongWord();
        set.set(234378);
        System.out.println("Set:                    " + set);
        System.out.println("Set Value:              " + set.getUnsigned());
        System.out.println();

        // Left logical shift test - GOOD
        LongWord leftLShift = new LongWord();
        leftLShift.set(4874);
        System.out.println("Original Left:          " + leftLShift);
        leftLShift = leftLShift.shiftLeftLogical(4);
        System.out.println("Left Logical Shift:     " + leftLShift);
        System.out.println();

        // Right logical shift test - GOOD
        LongWord rightLShift = new LongWord();
        rightLShift.set(1234567891);
        System.out.println("Original Right:         " + rightLShift);
        rightLShift = rightLShift.shiftRightLogical(4);
        System.out.println("Right Logical Shift:    " + rightLShift);
        System.out.println();

        // Right arithmetic method test - GOOD
        LongWord rightAShift = new LongWord();
        rightAShift.set(3894323);
        System.out.println("Orig Right Shift:       " + rightAShift);
        rightAShift = rightAShift.shiftRightArithmetic(7);
        System.out.println("Right Arithmetic Shift: " + rightAShift);
        System.out.println();

        // Not() method test - GOOD
        LongWord not = new LongWord();
        not.set(52556);
        System.out.println("Original bitSet (not) : " + not);
        System.out.println("Not-ed bitSet :         " + not.not());
        System.out.println();

        // And() method test - GOOD
        LongWord testAnd1 = new LongWord();
        testAnd1.set(4325);
        LongWord testAnd2 = new LongWord();
        testAnd2.set(9753);
        System.out.println("Original bitSet (and1) : " + testAnd1);
        System.out.println("Original bitSet (and2) : " + testAnd2);
        System.out.println("And-ed new BitSet :      " + testAnd1.and(testAnd2));
        System.out.println();

        // Or() method test
        LongWord testOr1 = new LongWord();
        testOr1.set(4325);
        LongWord testOr2 = new LongWord();
        testOr2.set(9753);
        System.out.println("Original bitSet (or1) :  " + testOr1);
        System.out.println("Original bitSet (or2) :  " + testOr2);
        System.out.println("Or-ed new BitSet :       " + testOr1.or(testOr2));
        System.out.println();

        // Xor() method test
        LongWord testXor1 = new LongWord();
        testXor1.set(123456);
        LongWord testXor2 = new LongWord();
        testXor2.set(654321);
        System.out.println("Original bitSet (xor1):  " + testXor1);
        System.out.println("Original bitSet (xor2):  " + testXor2);
        System.out.println("Xor-ed new BitSet :      " + testXor1.xor(testXor2));

        System.out.println("==============================================================================");
    }
}
