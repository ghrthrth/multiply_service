package com.multiply_service.core.controllers;

import com.multiply_service.core.model.Request;
import com.multiply_service.core.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestControllers {
    private RequestService requestService;
    @Autowired(required = true)
    @Qualifier(value = "requestService")
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }
    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public String listRequest(Model model){
        model.addAllAttributes("request", new Request());
        model.addAllAttributes("listRequest", this.requestService.listRequest());
    return "request";

    }
    @RequestMapping(value = "/request/add", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute("request") Request request){
        if(request.getId() == 0){
            this.requestService.addRequest(request);
        }else {
            this.requestService.apdateRequest(request);
        }
        return "redirect:/request";
    }

    @RequestMapping("/remove/{id}")
    public String removeRequest(@PathVariable("id") int id){
        this.requestService.removeRequest(id);
        return "redirect:/request";
    }
    @RequestMapping("requestdata/{id}")
    public String requestData(@PathVariable("id") int id, Model model){
        model.addAllAttributes("request", this.requestService.getRequestById(id));
        return  "requestdata";
    }
}

