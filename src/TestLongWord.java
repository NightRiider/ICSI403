public class TestLongWord {

        public static void main(String[] args) {
            LongWord word = new LongWord();

            System.out.println();
            System.out.println("==============================================================================");
            word.set(Integer.MAX_VALUE);
            System.out.println("Original:               " + word);
            System.out.println("Signed:                 " + word.getSigned());
            System.out.println("Unsigned:               " + word.getUnsigned());
            LongWord word2 = new LongWord();
            word2.set(Integer.MAX_VALUE - 5);
            System.out.println("WORD 2:                 " + word2);
            word.copy(word2);
            System.out.println("WORD 2 COPIED:          " + word);

            LongWord set = new LongWord();
            set.set(234378);
            System.out.println("Set:                    " + set);
            System.out.println("Set Value:              " + set.getUnsigned());

            LongWord leftLShift = new LongWord();
            leftLShift.set(Integer.MAX_VALUE);
            leftLShift = leftLShift.shiftLeftLogical(5);
            System.out.println("Left Logical Shift:     " + leftLShift);

            LongWord rightLShift = new LongWord();
            rightLShift.set(Integer.MAX_VALUE);
            rightLShift = rightLShift.shiftRightLogical(5);
            System.out.println("Right Logical Shift:    " + rightLShift);

            LongWord rightAShift = new LongWord();
            rightAShift.set(-324);
            System.out.println("Orig Right Shift:       " + rightAShift);
            rightAShift = rightAShift.shiftRightArithmetic(5);
            System.out.println("Right Arithmetic Shift: " + rightAShift);

            System.out.println("==============================================================================");
        }
}
