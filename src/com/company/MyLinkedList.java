package com.company;

public class MyLinkedList<T>
{
    private int size = 0;
    private Node<T> listHead = null;
    private Node<T> listTail = null;


    public void add(T element)
    {
        Node<T> newNode= new Node<>(element);
        if (listHead == null)
        {
            listHead = newNode;
            listTail = newNode;
        }
        else
        {
            listTail.forward = newNode;
            newNode.back = listTail;
            listTail = newNode;
        }
        size++;
    }

    public boolean add(int index, T element)
    {
        if (index<0 || index > size) return false;
        Node<T> newNode= new Node<>(element);
        if (index == 0 && listHead == null)
        {
            listHead = newNode;
            listTail = newNode;
        }
        else if (index == 0)
        {
            if (listHead.forward == null) listTail = newNode;
            else listHead.forward.back = newNode; // the next node's back link to new
            newNode.forward = listHead;
            listHead = newNode;
        }
        else
        {
            Node<T> currentNode = listHead;
            for (int i=0; i<(index-1); i++)
            {
                currentNode = currentNode.forward;
            }
            if (currentNode.forward == null) listTail = newNode;
            else currentNode.forward.back = newNode; // the next node's back link to new
            newNode.forward = currentNode.forward; //new node links to next in chain
            currentNode.forward = newNode; //current node links to the new node
            newNode.back = currentNode; //new node backward link points to current
        }
        size++;
        return true;
    }

    public T get(int index)
    {
        if (index<0 || index>size) return null;
        Node<T> temporary = listHead;
        for(int i=0; i<index; i++)
        {
            temporary = temporary.forward;
        }
        return (T) temporary.data;
    }

    public String toString()
    {
        String result = "[";
        Node currentNode = listHead;
        while (currentNode != null)
        {
            result = result + (T)currentNode.data;
            if(currentNode.forward != null) result = result + ", ";
            currentNode = currentNode.forward;
        }
        result = result + "]";
        return result;
    }

    //internal class to holde the nodes/elements of this collection
    static class Node<T>
    {
        Object data;
        Node<T> back;
        Node<T> forward;

        public Node(T obj)
        {
            data = obj;
            this.back = null;
            this.forward = null;
        }
    }

}
