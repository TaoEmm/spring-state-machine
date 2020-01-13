package com.ktao.machine.machine;

import com.ktao.machine.RunApp;
import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.service.impl.PoStateMachineService;
import com.ktao.machine.statemachine.factory.PoStateMachineFactory;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static com.ktao.machine.consts.PurchaseOrderConst.PO_STATE_MACHINE_KEY;

/**
 * 状态机持久化测试
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 4:23 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApp.class)
@WebAppConfiguration
@Log4j2
public class PoStateMachinePersistTest {
    @Resource
    private PoStateMachineFactory poStateMachineFactory;


    @Resource
    private StateMachinePersister<PurchaseOrderState, PurchaseOrderEvent, PurchaseOrder> persister;


    private PurchaseOrder getOrder() {
        return PurchaseOrder.builder()
                .id(1)
                .poCode("PO00001")
                .orderStatus(PurchaseOrderState.INIT.getCode())
                .build();
    }

    @Test
    public void testPersist() throws Exception {
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine = poStateMachineFactory.createStateMachine();
        // 启动状态机实例
        stateMachine.start();
        System.out.println("初始状态：" + stateMachine.getState().getId());
        PurchaseOrder order = getOrder();
        // 封装采购单数据
        Message<PurchaseOrderEvent> message = MessageBuilder
                .withPayload(PurchaseOrderEvent.APPROVE)
                .setHeader(PO_STATE_MACHINE_KEY, order)
                .build();
        stateMachine.sendEvent(message);
        System.out.println("审核后的状态：" + stateMachine.getState().getId());
        persister.restore(stateMachine, order);
        System.out.println("恢复后的状态：" + stateMachine.getState().getId());
    }
}
