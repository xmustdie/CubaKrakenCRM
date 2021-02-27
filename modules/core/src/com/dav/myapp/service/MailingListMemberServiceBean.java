package com.dav.myapp.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(MailingListMemberService.NAME)
public class MailingListMemberServiceBean implements MailingListMemberService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MailingListMemberServiceBean.class);
    @Inject
    private Persistence persistence;

    @Override
    public List findListMembers() {
        List result;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            result = entityManager.createNativeQuery("SELECT DISTINCT SEC_USER.LOGIN " +
                    "FROM MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK u INNER JOIN SEC_USER ON u.user_id=SEC_USER.id")
                    .getResultList();
            tx.commit();
            log.info(String.valueOf(result));
        }
        return result;
    }
}