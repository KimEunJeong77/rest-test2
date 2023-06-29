package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("/index");
        return mv;
    }

    @ResponseBody
    @GetMapping("/ajax-list")
    public Map<String,Object> memberAjaxList(Model model){
        List<MemberDTO> list=memberService.findMemberList();
        Map<String,Object> map=new HashMap<>();
        map.put("list", list);
        return map;
    }

    @PostMapping
    public void memberAjaxList(MemberDTO memberDTO){
        memberService.registerMember(memberDTO);
    }
}