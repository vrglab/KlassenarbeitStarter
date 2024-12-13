package de.szut.mylists;

public class MyArrayList {
    private int[] array;

    private int active_size;

    public MyArrayList() {
        array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }
        active_size = 0;
    }

    public int size() {
        return active_size;
    }

    public void add(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == Integer.MIN_VALUE) {
                array[i] = value;
                active_size++;
                return;
            }
        }
        extend_array_size();
        this.add(value);
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if(active_size == index + 1) {
            array[index] = Integer.MIN_VALUE;
        } else {
            int to_be_moved = active_size - index;

            for (int i = index; i < to_be_moved; i++) {
                array[index] = array[i + 1];
                if(array[i + 2] == Integer.MIN_VALUE) {
                    array[i + 1] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        active_size--;
    }

    boolean contains(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private void extend_array_size() {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
