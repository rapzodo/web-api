package com.kingofus.management;

import com.kingofus.management.controllers.UsersManagementController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagementApplicationTests extends AbstractApisIntegrationTest{

    @Autowired
    private UsersManagementController usersManagementController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(usersManagementController).isNotNull();
    }

}

