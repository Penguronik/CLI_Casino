/*
Author:
Date: Monday, November 9, 2020
Purpose:
 */

public class InvalidCardValueException extends Exception {

    // constructor 1
    public InvalidCardValueException() {
        super();
    }

    // constructor 2
    public InvalidCardValueException(String message) {
        super(message);
    }
}
