/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author GBarbieri
 */
public enum DataType {

    UNSIGNED_INT_8,
    UNSIGNED_INT_16,
    UNSIGNED_INT_32,
    UNSIGNED_INT_64,
    INT_8,
    INT_16,
    INT_32,
    INT_64,
    FLOAT_16,
    FLOAT_32,
    FLOAT_64,
    NUM_DATATYPES,
    UNKNOWN;

    public final int value;

    private DataType() {
        value = Counter.nextValue;
        Counter.nextValue++;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }

    public int getSize() {
        switch (this) {
            case INT_8:
            case UNSIGNED_INT_8:
                return 1;
            case INT_16:
            case UNSIGNED_INT_16:
            case FLOAT_16:
                return 2;
            case INT_32:
            case UNSIGNED_INT_32:
            case FLOAT_32:
                return 4;
            case INT_64:
            case UNSIGNED_INT_64:
            case FLOAT_64:
                return 8;
            case UNKNOWN:
                return 0;
            default:
                throw new AssertionError("unsupported type", null);
        }
    }
}
