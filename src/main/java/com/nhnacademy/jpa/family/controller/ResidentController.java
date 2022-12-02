package com.nhnacademy.jpa.family.controller;

import com.nhnacademy.jpa.family.config.WebConfig;
import com.nhnacademy.jpa.family.entity.Resident;
import com.nhnacademy.jpa.family.service.ResidentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public String viewResidentMain(Pageable pageable, Model model) {
        //TODO model 추가
        if (pageable.getPageSize() != WebConfig.PAGE_SIZE) {
            return "redirect:/?page=0&size=" + WebConfig.PAGE_SIZE;
        }
        Page<Resident> page = residentService.viewResidentsBy(pageable);
        model.addAttribute("page", page);
        model.addAttribute("residents", page.getContent());

        return "/resident/residentMain";
    }

}