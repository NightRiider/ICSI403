import java.util.BitSet;

public class TestLongWord {

    public static void runTests() {
        testgetBit();
        testsetBit();
        testclearBit();
        testtoggleBit();

        testgetSigned();
        testgetUnsigned();
        testSet();
        testCopy();

        testshiftLeftLogical();
        testshiftRightLogical();
        testshiftRightArithmetic();

        testNot();
        testAnd();
        testOr();
        testXor();

        testisZero();
    }

    private static void testgetBit() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);

        System.out.println("LongWord:            \t" + longWord);
        System.out.println("LongWord.getBit(0):  \t" + longWord.getBit(0));
        System.out.println("getBit(0):           \t" + (longWord.getBit(0) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testsetBit() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);

        System.out.println("LongWord:            \t" + longWord);
        longWord.setBit(1);
        System.out.println("LongWord after Test: \t" + longWord);
        System.out.println("setBit(1):           \t" + (longWord.getBit(1) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testclearBit() {
        LongWord longWord = new LongWord();
        longWord.set(1234567);

        System.out.println("LongWord:            \t" + longWord);
        longWord.clearBit(0);
        System.out.println("LongWord after Test  \t" + longWord);
        System.out.println("clearBit(0):           \t" + (!longWord.getBit(0) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testtoggleBit() {
        LongWord longWord = new LongWord();
        longWord.set(1234567);

        System.out.println("LongWord:            \t" + longWord);
        longWord.toggleBit(1);
        System.out.println("LongWord after Test  \t" + longWord);
        System.out.println("toggleBit(1):        \t" + (!longWord.getBit(1) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testgetSigned() {
        LongWord longWord = new LongWord();
        longWord.set(-1234567);

        System.out.println("LongWord:            \t" + longWord);
        System.out.println("LongWords real value:\t" + -1234567);
        System.out.println("getSigned():         \t" + (longWord.getSigned() == -1234567 ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testgetUnsigned() {
        LongWord longWord = new LongWord();
        longWord.set(1234567);

        System.out.println("LongWord:            \t" + longWord);
        System.out.println("getUnsigned():       \t" + (longWord.getUnsigned() == 1234567 ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testSet() {
        LongWord longWord = new LongWord();
        longWord.set(1234);

        System.out.println("LongWord:            \t" + longWord);
        System.out.println("LongWord value:      \t" + longWord.getSigned());
        System.out.println("Set(1234):           \t" + (longWord.getSigned() == 1234 ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testCopy() {
        LongWord longWord = new LongWord();
        longWord.set(1234);
        LongWord other = new LongWord();
        other.set(4321);

        System.out.println("LongWord:            \t" + longWord);
        System.out.println("Other LongWord:      \t" + other);
        longWord.copy(other);
        System.out.println("LongWord after Copy: \t" + longWord);
        System.out.println("copy()               \t" + (longWord.getSigned() == 4321 ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testshiftLeftLogical() {
        LongWord longWord = new LongWord();
        longWord.set(Integer.MAX_VALUE);

        System.out.println("LongWord:            \t" + longWord);
        longWord = longWord.shiftLeftLogical(5);
        System.out.println("LongWord after Shift:\t" + longWord);
        System.out.println("shiftLeftLogical()   \t" + (longWord.getSigned() == (Integer.MAX_VALUE << 5) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testshiftRightLogical() {
        LongWord longWord = new LongWord();
        longWord.set(Integer.MAX_VALUE);

        System.out.println("LongWord:             \t" + longWord);
        longWord = longWord.shiftRightLogical(5);
        System.out.println("LongWord after Shift: \t" + longWord);
        System.out.println("shiftRightLogical()   \t" + (longWord.getSigned() == (Integer.MAX_VALUE >>> 5) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testshiftRightArithmetic() {
        LongWord longWord = new LongWord();
        longWord.set(Integer.MAX_VALUE);

        System.out.println("LongWord:             \t" + longWord);
        longWord = longWord.shiftRightArithmetic(5);
        System.out.println("LongWord after Shift: \t" + longWord);
        System.out.println("shiftRightArithmetic()\t" + (longWord.getSigned() == (Integer.MAX_VALUE >> 5) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testNot() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);

        System.out.println("LongWord:             \t" + longWord);
        longWord = longWord.not();
        System.out.println("LongWord after Not:   \t" + longWord);
        // 123456789 NOT-ed is decimal value of -123456790
        System.out.println("not():                \t" + (longWord.getSigned() == ~123456789 ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testAnd() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);
        LongWord other = new LongWord();
        other.set(987654321);
        LongWord result = longWord.and(other);

        System.out.println("LongWord:             \t" + longWord);
        System.out.println("Other:                \t" + other);
        System.out.println("LongWord & Other:     \t" + result);
        System.out.println("and():                \t" + (result.getSigned() == (123456789 & 987654321) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testOr() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);
        LongWord other = new LongWord();
        other.set(987654321);
        LongWord result = longWord.or(other);

        System.out.println("LongWord:             \t" + longWord);
        System.out.println("Other:                \t" + other);
        System.out.println("LongWord | Other:     \t" + result);
        System.out.println("or():                 \t" + (result.getSigned() == (123456789 | 987654321) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testXor() {
        LongWord longWord = new LongWord();
        longWord.set(123456789);
        LongWord other = new LongWord();
        other.set(987654321);
        LongWord result = longWord.xor(other);

        System.out.println("LongWord:             \t" + longWord);
        System.out.println("Other:                \t" + other);
        System.out.println("LongWord XOR Other:   \t" + result);
        System.out.println("or():                 \t" + (result.getSigned() == (123456789 ^ 987654321) ? "Pass" : "Fail"));
        System.out.println();
    }

    private static void testisZero() {
        LongWord longWord = new LongWord();
        longWord.set(0);

        System.out.println("LongWord:             \t" + longWord);
        System.out.println("isZero() result:      \t" + longWord.isZero());
        System.out.println("isZero():             \t" + (longWord.isZero() ? "Pass" : "Fail"));
        System.out.println();
    }


    public static void main(String[] args) {
        runTests();


        LongWord word = new LongWord();
        for(int i = 0; i < 32; i++) {
            word.setBit(i, true);
        }
        System.out.println("LW: " + word);
        System.out.println("LW: " + word.getUnsigned());
        System.out.println("LW signed: " + word.getSigned());
        /*BitSet bitSet = new BitSet(32);
        LongWord lw = new LongWord(bitSet);
        for(int i = 0; i < 32; i++) {
            if(i % 2 == 0)
                bitSet.set(i);
        }
        System.out.println("LW: " + lw);
        System.out.println("LW UnSigned: " + lw.getUnsigned());
        System.out.println("LW signed: " + lw.getSigned());*/
    }
}
