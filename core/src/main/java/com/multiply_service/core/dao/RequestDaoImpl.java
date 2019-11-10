package com.multiply_service.core.dao;

import com.multiply_service.core.model.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao{
    private static final Logger logger = LoggerFactory.getLogger(RequestDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRequest(Request request) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(request);
        logger.info("Request is successfully saved."+ request);

    }

    @Override
    public void updateRequest(Request request) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(request);
        logger.info("Request is successfully update:"+request);

    }

    @Override
    public void removeRequest(int request, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Request request1 = (Request) session.load(Request.class, new Integer(id));
        if (request1!=null){
            session.delete(request);
        }
        logger.info("Request is successfully removed"+request);
    }

    @Override
    public void getRequestById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Request request = (Request) session.load(Request.class, new Integer(id));
        logger.info("Request is successfully id load"+request);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Request> listRequest() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Request> requestList = session.createQuery("from Request").list();
        for (Request request: requestList){
            logger.info("Requests lists:"+ request);
        }

        return requestList;
    }
}
