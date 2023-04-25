/* 
 * CSS 162 Assert Demo
 * 
 * Usage: This software is configured to crash your program immediately upon execution.
 * If your software doesn't crash, you don't have assertions enabled (use "-ea")
 * in your editor.  Google the name of your editor and "how to enable asserts" or follow
 * the instructions specific to BlueJ or Eclipse in the lab.
 * 
 * Author: Rob Nash
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AssertDemo {

	/* Work on this in a piecewise fashion by uncommenting and focusing on one section at a time
	 * in isolation rather than running everything at once.
	 */
	public static void main(String[] args) {
		assert(true);
		//assert(false);
		
		//warmUpAsserts();
		
		//assertWithPrimitives();
		
		//assertWithObjects();
		
		homeworkRelatedAsserts();
	}
	private static void warmUpAsserts() {	
			assert( 5 > 1 );
			
			int a = 30;
			assert(a != 0);
	
			assert(null == null);	  //could this ever be false?
			assert(true == true);	  //a bad day indeed if this could be false
			assert("Hello".equals("Hello"));
			assert(123 > 12);
	}

	/*
	 * Using asserts in conjunction with primitive types is familiar to you;
	 * just as in a loop or if, you want to form a true/false (boolean) expression
	 * by employing the relational operators.
	 */
	private static void assertWithPrimitives() {
		//assert below to ensure a Fraction's denominator is never 0
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();
				
		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();
				
		assert(denom != 0);
	
		//assert that all ArrayLists start empty
		ArrayList<String> emptyList = new ArrayList<String>();
		assert(emptyList.size() == 0);
		assert(30.5 >= 30);
		assert(true != false);
	}
	
	/*
	 * Asserts work with both primitives and objects.  Just as you 
	 * use "==" with primitives and ".equals()" with objects, so too 
	 * will you use ".equals()" in asserts that deal with object equality. 
	 */
	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);
		//guess what .equals() does if you don't create one yourself? (hint ==)
		assert( ad.equals(ad) );
		//Created an .equals for Account to check contents.
		Account
				Act1 = new Account("Jonathan Sebastiani"),
				Act2 = new Account("Emily Bautel");
		Act1.deposit(100);
		Act2.deposit(100);
		assert(Act1.equals(Act2));

		Account Act3 = Act2;
		assert(Act3.equals(Act2));

		Act3.deposit(100);
		assert(Act3.equals(Act2));
	}
	/*
	For immutable objects, if we are comparing the objects, we need to create an equals class.
	If we are comparing the contents of the objects, we can use ==
	 */


	/*
	 * This function compares the address at "this" to the address of the object handed 
	 * into the function.
	 */
	public void checkAddress(Object input) {
		System.out.println("Address of this :" + this);
		System.out.println("Address of input:" + input);
		//how many aliases for the one "new" object created in main exist in this scope? 
		//1? 2? 3? Which are they?
		assert(this == input);  //== does an address check for objects, which is frequently NOT what we want
	}
	/*
	8)
	"this" points to the calling object, and "input" points to the argument object. They will end
	up being the same because we are comparing the addresses of the same object.
	 */

	/*	
	 * Asserts are a useful tool for transforming postconditions and class invariants into code.
	 * Lets build a few asserts that work with your current Bill & Money assignment.
	 * Change the value of paidDate and cents to trip the asserts and observe the asserted error message. 
	 */
	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();  //really, a Date 
		assert( paidDate != null);  	 //perhaps one rule is that paidDate shouldn't be null after calling setPaidDate()
		int cents = 0;
		assert( cents >= 0 && cents <=99);  //another class invariant is written as an assert here.
		double cost = 10;
		assert( cost >= 10);
		boolean isTrue = true;
		assert(isTrue);
	}
}
/*
1) I think it depends which technique I would want to use. If I am looking at some sort of for-loop
with a lot of confusing numbers, I would want to use the debugging option to walk through the whole
thing. But, if I want to check something really quick, or keep it in my code so that I can test
it a bunch of times, I would want to use asserts.
2) I think that asserts would be better for longer programs because we can get a lot of information
about where and what is happening to better navigate the code.
3) For debugging, it makes it very easy to go slowly over code and see exactly what is going on.
If it gets too difficulty, you can even write the variables down on paper so that you can track a lot better.
You can inspect every variable at every line, rather than having to print a bunch and make your code
super messy.
4) Having proper documentation can help when finding and avoiding bugs because when a bug comes up, you
can know exactly where it is and how it is failing.
 */
