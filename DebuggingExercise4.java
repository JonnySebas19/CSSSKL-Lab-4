class DebuggingExercise4
{
    public static void main(String[] args)
    {
        Account a = new Account("Jonathan Sebastiani");
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
}
/*
2) ** I am using IntelliJ **
A) The variable watch window is at the bottom of the screen. I can see all the variables that
have been used in this method. I can also see the values variables that are on that specific line
of code, off to the right of that line.
B) The method call stack is to the left of the variable watch window. This tells me what methods are being used
at the time.

3)
A) This will go to the next line in that specific class that I am in. If a method is used in this line,
it will just go to the next line and go through everything that is in that method.
B) This will go into the method that is called in that line. This is different because it goes into the method
instead of over it.
C) This will go out of whatever method that is being used and keeps going with the code
step by step. This is different because it goes out of the method instead of going over or into.
D) I do not have a continue option in IntelliJ, but I assume that it would just resume the program and start going
from wherever I say to continue from. This is different from moving in steps because it will move through the
code until the next error, breakpoint, or end of code, instead of moving line by line.
 */