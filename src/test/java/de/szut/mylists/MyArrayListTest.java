package de.szut.mylists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyArrayListTest {
    private MyArrayList myArrayList;

    @BeforeEach
    public void Init() {
        myArrayList = new MyArrayList();
    }

    @Test
    public void test_Add() {
        for (int i = 0; i < 3; i++) {
            myArrayList.add(1);
        }
        assertThat(myArrayList.size()).isEqualTo(3);
    }

    @Test
    public void test_beyond_ten_Add() {
        for (int i = 0; i < 12; i++) {
            myArrayList.add(1);
        }
        assertThat(myArrayList.size()).isEqualTo(12);
    }

    @Test
    public void test_Size() {
        myArrayList.add(1);
        assertThat(myArrayList.size()).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12})
    public void test_beyond_ten_Contains(int input) {
        for (int i = 0; i < 12; i++) {
            myArrayList.add(i + 1);
        }
        assertThat(myArrayList.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void test_Contains_true(int input) {
        myArrayList.add(input);
        assertThat(myArrayList.contains(input)).isEqualTo(true);
    }

    @Test
    public void test_Contains_false() {
        for (int i = 0; i < 12; i++) {
            myArrayList.add(i + 1);
        }

        assertThat(myArrayList.contains(15)).isEqualTo(false);
    }

    @Test
    public void test_Get() {
        for (int i = 0; i < 12; i++) {
            myArrayList.add(i + 1);
        }

        assertThat(myArrayList.get(4)).isEqualTo(5);
    }

    @Test
    public void test_Get_out_of_bounds() throws Exception {
        for (int i = 0; i < 9; i++) {
            myArrayList.add(i + 1);
        }

        assertThatThrownBy(()-> myArrayList.get(15)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void test_Remove_middle_value() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        assertThat(myArrayList.get(1)).isEqualTo(3);
    }

    @Test
    public void test_Remove_last_value() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(2);
        assertThat(myArrayList.get(2)).isEqualTo(Integer.MIN_VALUE);
    }
}
