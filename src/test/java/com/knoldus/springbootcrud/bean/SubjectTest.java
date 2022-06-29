package com.knoldus.springbootcrud.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubjectTest {
    /**
     * testConstructor
     */
    @Test
    void testConstructor() {
        Subject actualSubject = new Subject();
        actualSubject.setId("42");
        actualSubject.setName("Name");
        assertEquals("42", actualSubject.getId());
        assertEquals("Name", actualSubject.getName());
    }

    /**
     * test Constructor
     */
    @Test
    void testConstructor2() {
        Subject actualSubject = new Subject("42", "Name");
        actualSubject.setId("42");
        actualSubject.setName("Name");
        assertEquals("42", actualSubject.getId());
        assertEquals("Name", actualSubject.getName());
    }
}

