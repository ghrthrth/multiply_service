package com.multiply_service.core.services;

import com.multiply_service.core.model.Request;

import java.util.List;

public interface RequestService {
    public void addRequest(Request request);

    public void updateRequest(Request request);

    public void removeRequest(int id);

    public void getRequestById(int id);

    public List<Request> listRequest();

}
