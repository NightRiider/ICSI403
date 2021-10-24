public class ALU {

    private boolean zeroFlag;
    private boolean negativeFlag;
    private boolean carryoutFlag;
    private boolean overflowFlag;

    public ALU() {
        zeroFlag = false;
        negativeFlag = false;
        carryoutFlag = false;
        overflowFlag = false;
    }

    public boolean getZF() {
        return zeroFlag;
    }

    public boolean getNF() {
        return negativeFlag;
    }

    public boolean getCF() {
        return carryoutFlag;
    }

    public boolean getOF() {
        return overflowFlag;
    }

    public LongWord operate(int code, LongWord op1, LongWord op2) {
        LongWord result = new LongWord();

        if(code == 1000) {
            result = op1.and(op2);
            if(result.isZero())
                zeroFlag = true;
            if(result.getBit(32))
                negativeFlag = true;
        }
        else if(code == 1001) {
            result = op1.or(op2);
            if(result.isZero())
                zeroFlag = true;
            if(result.getBit(32))
                negativeFlag = true;
        }
        else if(code == 1010) {

        }
        else if(code == 1011) {
            return rippleCarryAdd(op1, op2, false);
        }
        else if(code == 1100) {
            return rippleCarryAdd(op1, op2, true);
        }
        else if(code == 1101) {
            return op1.shiftLeftLogical(op2.getSigned());
        }
        else if(code == 1110) {
            return op1.shiftRightLogical(op2.getSigned());
        }
        else if(code == 1111) {
            return op1.shiftRightArithmetic(op2.getSigned());
        }

        return result;
    }

    private LongWord rippleCarryAdd(LongWord a, LongWord b, boolean cin) {
        LongWord result;
        if(!cin) {
            for (int i = 0; i < 32; i++) {

                LongWord carry;
                //contains the bits that are common amongst a and b.
                carry = a.and(b);

                // a now only has bits set where only one of the bits in either a or b is set.
                a = a.xor(b);

                // b now become the result of shifting the carry by one.
                b = carry.shiftLeftLogical(1);

            }
            result = a;
            if(result.isZero()) {
                zeroFlag = true;
            }
        }
        else {
            for(int i = 31; i > -1; i--){
                LongWord added;
                LongWord borrow;
                // flip the bits of the minuend (a)
                borrow = a.not();

                added = borrow.and(b);
                a = a.xor(b);
                b = added.shiftLeftLogical(1);
            }
            result = a;
        }
        return result;
    }

}
