package com.ktao.machine.machine;

import com.ktao.machine.RunApp;
import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.service.impl.PoStateMachineService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 3:48 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApp.class)
@WebAppConfiguration
@Log4j2
public class PoStateMachineServiceTest {

    @Resource
    private PoStateMachineService poStateMachineService;

    private PurchaseOrder getOrder() {
        return PurchaseOrder.builder()
                .id(1)
                .poCode("PO00001")
                .orderStatus(PurchaseOrderState.INIT.getCode())
                .build();
    }

    @Test
    public void testPoApprove(){
        // 采购单审核
        poStateMachineService.transition(getOrder(), PurchaseOrderEvent.APPROVE);
    }
}
