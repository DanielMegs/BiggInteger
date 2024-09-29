package daniel;

import java.math.BigInteger;

/**
 * A class representing integers with basic arithmetic operations.
 * @author danny
 */
public class BiggestInteger {
    private final BigInteger value;

    /**
     * Constructs a BiggestInteger from a string of an integer.
     * 
     * @param val the string representing the integer value
     * @throws IllegalArgumentException if the string is not a valid for an integer
     */
    public BiggestInteger(String val) {
        try {
            value = new BigInteger(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer format.");
        }
    }

    /**
     * Adds another BiggestInteger to the result.
     * 
     * @param other BiggestInteger to be added
     * @return a new BiggestInteger representing the sum
     */
    public BiggestInteger add(BiggestInteger other) {
        return new BiggestInteger(value.add(other.value).toString());
    }

    /**
     * Returns a BiggestInteger whose value is the remainder of division of this BiggestInteger
     * by the specified divisor. The result will always be non-negative.
     * 
     * @param div the BiggestInteger to divide by
     * @return a new BiggestInteger representing the remainder
     * @throws ArithmeticException if the divisor is zero
     */
    public BiggestInteger mod(BiggestInteger div) {
        if (div.value.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero.");
        }
        BigInteger result = value.mod(div.value);
        return new BiggestInteger(result.toString());
    }

    @Override
    public String toString() {
        return value.toString();
    }
    /**
     * A simple test method to demonstrate the functionality of the BiggestInteger class.
     * 
     * @param args command line arguments
     */
    
    //Test the functionality of BiggestInteger class
    public static void main(String[] args) {
        //Test add() method
        BiggestInteger num1 = new BiggestInteger("123456789");
        BiggestInteger num2 = new BiggestInteger("987654321");
        BiggestInteger sum = num1.add(num2);
        System.out.println("Sum: " + sum);

        //Test mod() method
        BiggestInteger num3 = new BiggestInteger("123456789");
        BiggestInteger num4 = new BiggestInteger("100000");
        BiggestInteger modResult = num3.mod(num4);
        System.out.println("Modulus: " + modResult);

        //Test for exception
        try {
            BiggestInteger num5 = new BiggestInteger("123456789");
            BiggestInteger num6 = new BiggestInteger("0");
            num5.mod(num6);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
