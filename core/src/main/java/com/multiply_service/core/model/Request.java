package com.multiply_service.core.model;

import javax.persistence.*;

@Entity
@Table(name = "REQUESTS")
public class Request {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "REQUEST_NAME")
    private String requestName;

    @Column(name = "REQUEST_VALUE")
    private int value;


    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String bookTitle) {
        this.requestName = bookTitle;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", requestName='" + requestName + '\'' +
                ", value=" + value +
                '}';
    }
}
