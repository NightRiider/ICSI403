public class TestALU {
    public static void main(String[] args) {
        ALU alu = new ALU();

        LongWord l1 = new LongWord();
        l1.set(-4); // 0001
        System.out.println(l1);
        LongWord l2 = new LongWord();
        l2.set(3); // 0000
        System.out.println(l2);

        System.out.println(alu.operate(3, l1, l2));
        System.out.println(alu.getOF());
    }

}
