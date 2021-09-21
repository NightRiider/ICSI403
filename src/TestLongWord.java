public class TestLongWord {

        public static void main(String[] args) {
            LongWord word = new LongWord();
            System.out.println(word);
            System.out.println("Signed : " + word.getSigned());
            System.out.println("Unsigned : " + word.getUnsigned());
            word.set(5);
        }
}
