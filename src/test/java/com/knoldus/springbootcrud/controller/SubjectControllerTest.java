package com.knoldus.springbootcrud.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.springbootcrud.bean.Subject;
import com.knoldus.springbootcrud.service.SubjectService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SubjectController.class})
@ExtendWith(SpringExtension.class)
class SubjectControllerTest {
    @Autowired
    private SubjectController subjectController;

    @MockBean
    private SubjectService subjectService;

    @Test
    void testGetAllSubjects() throws Exception {
        when(this.subjectService.getAllSubjects()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subjects");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllSubjects2() throws Exception {
        when(this.subjectService.getAllSubjects()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/subjects");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testAddSubject() throws Exception {
        doNothing().when(this.subjectService).addSubject((Subject) any());

        Subject subject = new Subject();
        subject.setId("42");
        subject.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(subject);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateSubject() throws Exception {
        doNothing().when(this.subjectService).updateSubject((String) any(), (Subject) any());

        Subject subject = new Subject();
        subject.setId("42");
        subject.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(subject);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/subjects/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateSubject2() throws Exception {
        when(this.subjectService.getAllSubjects()).thenReturn(new ArrayList<>());
        doNothing().when(this.subjectService).updateSubject((String) any(), (Subject) any());

        Subject subject = new Subject();
        subject.setId("42");
        subject.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(subject);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/subjects/{id}", "", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testDeleteSubject() throws Exception {
        doNothing().when(this.subjectService).deleteSubject((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/subjects/{id}", "42");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteSubject2() throws Exception {
        doNothing().when(this.subjectService).deleteSubject((String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/subjects/{id}", "42");
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    void testDeleteSubject3() throws Exception {
        when(this.subjectService.getAllSubjects()).thenReturn(new ArrayList<>());
        doNothing().when(this.subjectService).deleteSubject((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/subjects/{id}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testDeleteSubject4() throws Exception {
        when(this.subjectService.getAllSubjects()).thenReturn(new ArrayList<>());
        doNothing().when(this.subjectService).deleteSubject((String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/subjects/{id}", "", "Uri Vars");
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

