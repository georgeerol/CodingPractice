package Leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Fouche on 12/18/19.
 */
public class LRUCache {
    Map<Integer, ListNode> hashtable = new HashMap<>();
    ListNode head;
    ListNode tail;


    int totalItemsInCache;
    int maxCapacity;


    private class ListNode {
        int key;
        int value;

        ListNode prev;
        ListNode next;
    }


    /**
     * Data Structure to use
     * 1. Fast lookups -> Hashtable
     * 2. Fast Removals -> Doubly LinkedList
     */


    public LRUCache(int capacity) {
        head = new ListNode();
        tail = new ListNode();
        totalItemsInCache = 0;
        this.maxCapacity = capacity;


        /* wire the head and tail together */
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        ListNode node = hashtable.get(key);

        if (node == null) return -1;

        //Item has been accessed. Move to the front of the cache
        moveToHead(node);
        return node.value;


    }

    public void put(int key, int value) {
        ListNode node = hashtable.get(key);

        //Item not found, create a new entry
        if (node == null) {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            //Add to the hashtable and the actual list that represents the cache
            hashtable.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;

            //If over capacity remove the least use item
            if (totalItemsInCache > maxCapacity) {
                removeLeastUseItem();
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeLeastUseItem() {
        ListNode tail = popTail();

        hashtable.remove(tail.key);
        --totalItemsInCache;
    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);

        return tailItem;
    }

    private void moveToHead(ListNode node) {
        //remove from list and add to front
        removeFromList(node);
        //Add to front
        addToFront(node);
    }

    private void addToFront(ListNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedNext.next = savedNext;
        savedNext.prev = savedPrev;

    }

    public   String display(){
        String result = "{";
        ListNode current = this.head;
        while (current != null) {
            result += current.value + "<->";
            current = current.next;
        }
        result += "}";
        return result;
    }



    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }



}
