package com.multiply_service.core.services;

import com.multiply_service.core.dao.RequestDao;
import com.multiply_service.core.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestDao requestDao;
    public void setRequestDao(RequestDao requestDao){
        this.requestDao = requestDao;
    }

    @Override
    @Transactional
    public void addRequest(Request request) {
        this.requestDao.addRequest(request);
    }

    @Override
    @Transactional
    public void updateRequest(Request request) {
        this.requestDao.updateRequest(request);

    }

    @Override
    @Transactional
    public void removeRequest(int id) {
        this.requestDao.removeRequest(id);
    }

    @Override
    @Transactional
    public void getRequestById(int id) {
    this.requestDao.getRequestById(id);

    }

    @Override
    @Transactional
    public List<Request> listRequest() {
        return this.requestDao.listRequest();
    }
}
