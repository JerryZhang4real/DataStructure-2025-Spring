package com.example;

/**
* A generic resizable array implementation. 
* Provides basic functionalities such as adding, removing, and accessing elements, 
* along with dynamic resizing to accommodate more elements when needed.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class MyArray<T> {
    private T[] array;
    private int size;

    public MyArray(int initCapacity){
        if(initCapacity <= 0){
            throw new IllegalArgumentException("Initial capacity must be greater than 0!");
        }

        array = (T[]) new Object[initCapacity];
        size = 0;
    }

    public MyArray(){
        this(10);
    }

    public T get(int index){
        return array[index];
    }

    public void add(T element){
        if(size == array.length){
            resize();
        }

        array[size++] = element;
    }

    public T remove(int index){
        checkIndex(index);
        T removedElement = array[index];
        
        for(int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }

        array[--size] = null;

        return removedElement;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(){
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public String toString(){
        String myArray2String = "";
        for(int i = 0; i < size; i++){
            myArray2String += array[i].toString() + " ";
        }

        return myArray2String;
    }
}
