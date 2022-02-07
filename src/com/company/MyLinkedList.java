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
