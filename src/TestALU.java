import java.sql.SQLOutput;

public class TestALU {
    public static void main(String[] args) {
        ALU alu = new ALU();

        LongWord l1 = new LongWord();
        l1.set(-(int)Math.pow(2,31)); // 0001
        //System.out.println(l1);
        LongWord l2 = new LongWord();
        l2.set(-(int)Math.pow(2,31)); // 0000
        //System.out.println(l2);

        // 0 0 1 * OVER * bc 2^30+2^30 = 1... GOOD
        // 1 1 0 * OVER * bc 2^31+2^31 = 0... GOOD

        //System.out.println(alu.operate(3, l1, l2));
        //System.out.println(alu.getOF());

        runTests(alu);
    }

    public static void runTests(ALU alu) {

        /*testAnd(alu);
        testOR(alu);
        testXOR(alu);*/
        testADD(alu);
        testSUB(alu);
        /*testSLL(alu);
        testSRL(alu);
        testSRA(alu);*/

    }

    public static void testAnd(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(100);
        LongWord word2 = new LongWord();
        word2.set(540);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of AND: \t\t" + alu.operate(0, word1, word2));
        System.out.println();
    }

    public static void testOR(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(500);
        LongWord word2 = new LongWord();
        word2.set(12455);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of OR: \t\t" + alu.operate(1, word1, word2));
        System.out.println();
    }

    public static void testXOR(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(12345);
        LongWord word2 = new LongWord();
        word2.set(1324);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of XOR: \t\t" + alu.operate(2, word1, word2));
        System.out.println();
    }

    public static void testADD(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set((int) Math.pow(2, 29));
        LongWord word2 = new LongWord();
        word2.set((int) Math.pow(2, 29));

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of ADD: \t\t" + alu.operate(3, word1, word2));
        System.out.println("CF: \t\t" + alu.getCF());
        System.out.println("OF: \t\t" + alu.getOF());
        System.out.println();
    }

    public static void testSUB(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(0);
        LongWord word2 = new LongWord();
        word2.set(1);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of SUB: \t\t" + alu.operate(4, word1, word2));
        System.out.println("CF Flag: \t\t" + alu.getCF());
        System.out.println("OF Flag: \t\t" + alu.getOF());
        System.out.println();
    }

    public static void testSLL(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(1234546789);
        LongWord word2 = new LongWord();
        word2.set(2);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of SLL: \t\t" + alu.operate(5, word1, word2));
        System.out.println();
    }

    public static void testSRL(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(1234546789);
        LongWord word2 = new LongWord();
        word2.set(1);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of SRL: \t\t" + alu.operate(6, word1, word2));
        System.out.println();
    }

    public static void testSRA(ALU alu) {
        LongWord word1 = new LongWord();
        word1.set(1234546789);
        LongWord word2 = new LongWord();
        word2.set(1);

        System.out.println("LongWord 1: \t\t" + word1);
        System.out.println("LongWord 2: \t\t" + word2);
        System.out.println("Result of SRA: \t\t" + alu.operate(7, word1, word2));
        System.out.println();
    }


}
