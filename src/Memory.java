public class Memory {
    private byte[] memory;

    public Memory() {
        memory = new byte[256];
    }

    public LongWord read(LongWord address, int numBytes) {
        LongWord word = new LongWord();

        if (numBytes > 4) {
            throw new IllegalArgumentException("numBytes > 4");
        }

        for (int i = 0; i < numBytes; i++) {
            word = word.shiftLeftLogical(8);
            LongWord temp = new LongWord();
            temp.set(memory[(int) address.getUnsigned() + i]);
            word = word.or(temp);
        }

        return word;
    }

    public void write(LongWord address, LongWord word, int numBytes) {
        if (numBytes > 4) {
            throw new IllegalArgumentException("numBytes > 4");
        }

        for (int i = 0; i < numBytes; i++) {
            memory[(int) address.getUnsigned() + i] = (byte) (word.getUnsigned() >> (8 * (numBytes - i - 1)));
        }
    }
}