package com.example.demo.service;

import com.example.demo.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> findMemberList();
    void registerMember(MemberDTO memberDTO);
}