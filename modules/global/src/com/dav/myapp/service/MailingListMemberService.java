package com.dav.myapp.service;

import java.util.List;

public interface MailingListMemberService {
    String NAME = "myapp_MailingListMemberService";

    public List<String> findListMembers();
}