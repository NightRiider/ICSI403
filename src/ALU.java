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

    public void updateFlags(LongWord result) {
        if (result.isZero())
            zeroFlag = true;
        if (result.getBit(31))
            negativeFlag = true;
    }

    public LongWord operate(int code, LongWord op1, LongWord op2) {
        LongWord result = new LongWord();

        if (code == 0) {
            result = op1.and(op2);
            updateFlags(result);
        } else if (code == 1) {
            result = op1.or(op2);
            updateFlags(result);
        } else if (code == 2) {
            result = op1.xor(op2);
            updateFlags(result);
        } else if (code == 3) {
            result = rippleCarryAdd(op1, op2, false);
            updateFlags(result);
        } else if (code == 4) {
            result = rippleCarryAdd(op1, op2, true);
            updateFlags(result);
        } else if (code == 5) {
            result = op1.shiftLeftLogical(op2.getSigned());
            updateFlags(result);
        } else if (code == 6) {
            result = op1.shiftRightLogical(op2.getSigned());
            if (result.isZero())
                zeroFlag = true;
        } else if (code == 7) {
            result = op1.shiftRightArithmetic(op2.getSigned());
            updateFlags(result);
        }

        return result;
    }

    private LongWord rippleCarryAdd(LongWord a, LongWord b, boolean cin) {
        LongWord result;
        LongWord origA = a;
        LongWord origB = b;
        if (!cin) {
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
            if (result.isZero()) {
                zeroFlag = true;
            }
            if (origA.getBit(31) == origB.getBit(31) && result.getBit(31) != origA.getBit(31))
                overflowFlag = true;
        } else { // subtract
            for (int i = 31; i > -1; i--) {
                LongWord added;
                LongWord borrow;
                // flip the bits of the minuend (a)
                borrow = a.not();

                added = borrow.and(b);
                a = a.xor(b);
                b = added.shiftLeftLogical(1);
            }
            result = a;
            if (a.getBit(31) != b.getBit(31) && result.getBit(31) == b.getBit(31))
                overflowFlag = true;
        }
        return result;
    }

}
