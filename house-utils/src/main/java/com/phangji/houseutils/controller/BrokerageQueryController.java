package com.phangji.houseutils.controller;

import com.phangji.houseutils.constants.ActionType;
import com.phangji.houseutils.policy.BrokeragePolicy;
import com.phangji.houseutils.policy.BrokeragePolicyFactory;
import com.phangji.houseutils.policy.PurchaseBrokeragePolicy;
import com.phangji.houseutils.policy.RentBrokeragePolicy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);

        return policy.calculate(price);
    }
}
