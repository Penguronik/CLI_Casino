/*
Author: Tomer Lapid
Date: Monday, November 9, 2020
Purpose: To have a specific exception incase a card with incorerect values is created
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
