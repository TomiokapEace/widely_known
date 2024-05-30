package com.example.widely_known;
import com.example.widely_known.service.IconGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class widely_knownApplicationTests {
    @Resource
    private IconGroupService iconGroupService;
    @Test
    void contextLoads() {
        System.out.println(iconGroupService.queryIconGroupListByRelevanceId("2").get(0).getIconPath());
    }

}