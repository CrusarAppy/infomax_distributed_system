public class ThreadLifeCycleDemo
{
    public static void main (String[]args)
    {
        // life cycle of Thread
//         Thread's New State
        A1 threadA = new A1 ();
        B threadB = new B ();
        // Both the above threads are in runnable state
        // Running state of thread A & B
        threadA.start ();
        // Move control to another thread
        // The yield() method is used in Java to hint the task scheduler to move the currently executing
        // task to the Ready state and move another task or thread to the running state. Ω
        threadA.yield ();
        System.out.println(threadA.getState());
        // Blocked State of thread B
        try
        {
            threadA.sleep (1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace ();
        }
        threadB.start ();
        System.out.println ("Main Thread End");
    }
}