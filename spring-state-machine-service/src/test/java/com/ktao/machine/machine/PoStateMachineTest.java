package com.ktao.machine.machine;

import com.ktao.machine.RunApp;
import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.statemachine.factory.PoStateMachineFactory;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 2:46 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApp.class)
@WebAppConfiguration
@Log4j2
public class PoStateMachineTest {

    @Resource
    private PoStateMachineFactory poStateMachineFactory;

    private PurchaseOrder getOrder() {
        return PurchaseOrder.builder()
                .id(1)
                .poCode("PO00001")
                .orderStatus(PurchaseOrderState.INIT.getId())
                .build();
    }

    @Test
    public void testPoApprove(){
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine = poStateMachineFactory.createStateMachine();
        stateMachine.start();
        Message<PurchaseOrderEvent> payMsg = MessageBuilder
                .withPayload(PurchaseOrderEvent.APPROVE)
                .setHeader("order", getOrder())
                .build();
        stateMachine.sendEvent(payMsg);
    }

    @Test
    public void testPoReject(){
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine = poStateMachineFactory.createStateMachine();
        stateMachine.start();
        Message<PurchaseOrderEvent> payMsg = MessageBuilder
                .withPayload(PurchaseOrderEvent.REJECT)
                .setHeader("order", getOrder())
                .build();
        stateMachine.sendEvent(payMsg);
    }

    @Test
    public void testPoClose(){
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine = poStateMachineFactory.createStateMachine();
        stateMachine.start();
        Message<PurchaseOrderEvent> payMsg = MessageBuilder
                .withPayload(PurchaseOrderEvent.CLOSE)
                .setHeader("order", getOrder())
                .build();
        stateMachine.sendEvent(payMsg);
    }
}
