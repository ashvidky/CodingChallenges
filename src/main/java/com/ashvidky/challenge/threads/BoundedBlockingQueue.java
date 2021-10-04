package com.ashvidky.challenge.threads;

import java.util.LinkedList;

class BoundedBlockingQueue {

    int capacity;
    LinkedList<Integer> queue = new LinkedList<>();
    Object lock = new Object();
    
    public BoundedBlockingQueue(int capacity) {
        
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        
        System.out.println("enqueue:" + element);

        synchronized(lock){
            
            while (size() == capacity){
                
                //System.out.println("Queue is full. wait for consumer.");
                // block producer
                lock.wait();
            }
            
            queue.addFirst(element);
            lock.notifyAll();
            
            //System.out.println("Element added.");

        }
        
    }
    
    public int dequeue() throws InterruptedException {
        Integer el = null;
        
        synchronized(lock){
            
            while(size() == 0){
                
                //System.out.println("Queue is empty. wait for producer");

                // block consumer
                lock.wait();
            }
            
            el = queue.removeLast();
            lock.notifyAll();
        }
        
        //System.out.println("Return Element:" + el);

        return el;
    }
    
    public int size() {
        return queue.size();
    }
}
