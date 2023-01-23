package com.mjc.stage2;

public class ThreadSafeSingleton{
    // Write your code here!
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){

    }


    synchronized public static ThreadSafeSingleton getInstance()
    {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}