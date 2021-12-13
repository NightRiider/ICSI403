public class TestMemory {
    public static void runTests() {
        testSetAndRead(100, 189);
        testSetAndRead(832, 190);
        testSetAndRead(77, 252);
        testSetAndRead(312321, 10);
    }

    private static void testSetAndRead(int value, int loc) {
        Memory memory = new Memory();
        LongWord location = new LongWord();
        location.set(loc);
        LongWord word = new LongWord();
        word.set(value);
        memory.write(location, word, 4);
        System.out.println("Wrote " + word.getSigned() + " to " + location.getSigned());

        LongWord readWord = memory.read(location, 4);
        System.out.println("Read " + readWord.getSigned() + " from " + location.getSigned());
    }
}
