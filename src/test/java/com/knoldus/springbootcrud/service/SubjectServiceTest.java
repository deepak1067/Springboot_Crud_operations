package com.knoldus.springbootcrud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.knoldus.springbootcrud.bean.Subject;
import com.knoldus.springbootcrud.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubjectService.class})
@ExtendWith(SpringExtension.class)
class SubjectServiceTest {
    @MockBean
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;

    @Test
    void testGetAllSubjects() {
        Iterable<Subject> iterable = (Iterable<Subject>) mock(Iterable.class);
        doNothing().when(iterable).forEach((java.util.function.Consumer<? super Subject>) any());
        when(this.subjectRepository.findAll()).thenReturn(iterable);
        assertTrue(this.subjectService.getAllSubjects().isEmpty());
        verify(this.subjectRepository).findAll();
        verify(iterable).forEach((java.util.function.Consumer<? super Subject>) any());
    }

    @Test
    void testAddSubject() {
        Subject subject = new Subject();
        subject.setId("42");
        subject.setName("Name");
        when(this.subjectRepository.save((Subject) any())).thenReturn(subject);

        Subject subject1 = new Subject();
        subject1.setId("42");
        subject1.setName("Name");
        this.subjectService.addSubject(subject1);
        verify(this.subjectRepository).save((Subject) any());
        assertEquals("42", subject1.getId());
        assertEquals("Name", subject1.getName());
        assertTrue(this.subjectService.getAllSubjects().isEmpty());
    }

    @Test
    void testUpdateSubject() {
        Subject subject = new Subject();
        subject.setId("42");
        subject.setName("Name");
        when(this.subjectRepository.save((Subject) any())).thenReturn(subject);

        Subject subject1 = new Subject();
        subject1.setId("42");
        subject1.setName("Name");
        this.subjectService.updateSubject("42", subject1);
        verify(this.subjectRepository).save((Subject) any());
        assertEquals("42", subject1.getId());
        assertEquals("Name", subject1.getName());
        assertTrue(this.subjectService.getAllSubjects().isEmpty());
    }


    @Test
    void testDeleteSubject() {
        doNothing().when(this.subjectRepository).deleteById((String) any());
        this.subjectService.deleteSubject("42");
        verify(this.subjectRepository).deleteById((String) any());
        assertTrue(this.subjectService.getAllSubjects().isEmpty());
    }
}

