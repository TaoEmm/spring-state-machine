package com.ktao.machine.statemachine.config;

import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.statemachine.presist.PoStateMachinePersist;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 4:21 下午
 */
@Configuration
public class PoStateMachinePersistConfig {

    @Resource
    private PoStateMachinePersist poStateMachinePersist;

    @Bean
    public StateMachinePersister<PurchaseOrderState, PurchaseOrderEvent, PurchaseOrder> persister(){
        return new DefaultStateMachinePersister<>(poStateMachinePersist);
    }
}
