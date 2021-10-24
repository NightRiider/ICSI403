public class TestALU {
    public static void main(String[] args) {
        ALU alu = new ALU();

        LongWord l1 = new LongWord();
        l1.set(245);
        LongWord l2 = new LongWord();
        l2.set(55);
        LongWord operation = new LongWord();
        //operation

        System.out.println(alu.operate(1011 ,l1, l2));
    }
}
