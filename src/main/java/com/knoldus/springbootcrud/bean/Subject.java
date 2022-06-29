package com.knoldus.springbootcrud.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {

    /**
     * id variable for subject
     */
    @Id
    private String id;
    /**
     * name variable for subject
     */
    private String name;


    /**
     * constuctor Subject
     */
    public Subject() {

    }

    /**
     * method Subject
     * @param id
     * @param name
     */
    public Subject(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * method to getid
     * @return id
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
