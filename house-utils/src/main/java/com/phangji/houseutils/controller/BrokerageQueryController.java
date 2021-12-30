package com.phangji.houseutils.controller;

import com.phangji.houseutils.constants.ActionType;
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
        if (actionType == ActionType.PURCHASE) {
            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();

            return policy.calculate(price);
        }

        if (actionType == ActionType.RENT) {
            RentBrokeragePolicy policy = new RentBrokeragePolicy();
            return policy.calculate(price);
        }

        return null;
    }
}
