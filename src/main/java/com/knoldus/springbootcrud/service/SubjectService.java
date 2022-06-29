package com.knoldus.springbootcrud.service;

import com.knoldus.springbootcrud.bean.Subject;
import com.knoldus.springbootcrud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    /**
     *Injecting Subject repo
     */
    @Autowired
    public SubjectRepository subjectRepo;

    /**
     * method to get all subjects
     * @return subjects
     */
    public List<Subject> getAllSubjects()
    {
        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findAll().forEach(subjects::add);
        return subjects;
    }

    /**
     * method to add subjets
     * @param subject
     */
    public void addSubject(Subject subject) {
        subjectRepo.save(subject);

    }

    /**
     * method to update subjects
     * @param id
     * @param subject
     */
    public void updateSubject(String id, Subject subject) {
        subjectRepo.save(subject);

    }

    /**
     * method to delete Subjects
     * @param id
     */
    public void deleteSubject(String id) {
        subjectRepo.deleteById(id);

    }

}
