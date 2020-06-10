package fundamental.datastructures;

import fundamental.datastructures.SafeDepositBox;
import fundamental.datastructures.Valuable;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//
// A safe deposit box is like a locker you can rent from a bank.
// People generally use them to store valuables that need more security or protection
// than their homes provide - things like jewelry or important papers.


// Make a representation in code for a valuable we would put in a safe deposit box.
// A valuable is anything that goes inside a safe deposit box.
//
// Let’s make a representation in code for a safe deposit box.

// Safe deposit boxes can hold multiple valuables.
// Valuables can be added to and removed from a safe deposit box.
// - the method to add a valuable should take in a whole valuable object.
// - the method to remove a valuable should take in just the unique name of that valuable, and return the whole valuable object to the client. (like millilitres or cubic inches).


// Let's update our safe deposit boxes to respect an additional constraint:
// they have a fixed size.
// The size is one of:
//     - small: 15 cubic inches
//     - medium: 30 cubic inches
//     - large: 50 cubic inches

// The valuables added to a box cannot exceed the total volume of that box.


public class Problem {


    public static void main(String[] args) {

        Valuable valuable = new Valuable("ABC",1);
        Valuable valuable2 = new Valuable("ABC",32);
        Valuable valuable3= new Valuable("ABC",65);


        SafeDepositBox safeDepositBox = new  SafeDepositBox();
        safeDepositBox.add(valuable);
        Valuable  valuable4 = safeDepositBox.remove(valuable.getUniqueName());
        System.out.println(valuable4.getUniqueName());
        System.out.println(valuable4.getVolume());


    }

}
