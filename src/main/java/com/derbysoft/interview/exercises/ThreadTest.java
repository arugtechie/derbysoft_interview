package com.derbysoft.interview.exercises;

/**
 * 1. Write a program that spawns two threads. One thread should print out "Hello World" and the other "World Hello"
 *    using the defined String variables.
 *
 * 2. Modify the code to create a deadlock as the two threads fight for synchronized access to both variables.
 *    Feel free to add a loop to each thread to increase the chance of a deadlock.
 *
 * 3. Solve the deadlock problem.
 *
 */
public class ThreadTest {

  static final String HELLO = "Hello";
  static final String WORLD = "World";

  public static void main(String argv[])
  {
    Thread1 thread1 = new Thread1("thread1");
    Thread2 thread2 = new Thread2("thread2");
    thread1.start();
    thread2.start();
  }

  static class Thread1 extends Thread
  {
    public Thread1(String name)
    {
      super(name);
    }

    @Override
    public void run() {
      synchronized (ThreadTest.HELLO) {
        try {
          // Adding delay so that both threads can start trying to lock resources
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(this.getName() + " acquired " + "HELLO lock");
        System.out.println(Thread.currentThread().getName() + " waiting for " + "WORLD lock");
        synchronized (ThreadTest.WORLD) {
          System.out.println(ThreadTest.HELLO + " " + ThreadTest.WORLD);
        }
      }
    }

  }

  static class Thread2 extends Thread
  {
    public Thread2(String name)
    {
      super(name);
    }

    @Override
    public void run() {
      synchronized (ThreadTest.HELLO)
      {
        try {
          // Adding delay so that both threads can start trying to lock resources
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(this.getName() + " acquired " + "HELLO lock");
        System.out.println(Thread.currentThread().getName() + " waiting for " + "WORLD lock");
        synchronized (ThreadTest.WORLD) {
          System.out.println(ThreadTest.WORLD + " " + ThreadTest.HELLO);
        }
      }
    }

  }
}
