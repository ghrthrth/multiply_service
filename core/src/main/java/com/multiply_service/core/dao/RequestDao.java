package com.multiply_service.core.dao;

import com.multiply_service.core.model.Request;

import java.util.List;

public interface RequestDao {
    public void addRequest(Request request);

    public void updateRequest(Request request);

    public void removeRequest(Request request);

    public void getRequestById(int id);

    public List<Request> listRequest(int id);

}
