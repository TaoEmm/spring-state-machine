package com.ktao.machine.controller;

import com.ktao.machine.service.PurchaseOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 2:56 下午
 */
@RestController
@Log4j2
public class PurchaseOrderController {

    @Resource
    private PurchaseOrderService purchaseOrderService;

}
