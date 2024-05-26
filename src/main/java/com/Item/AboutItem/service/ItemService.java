package com.Item.AboutItem.service;

import com.stripe.param.checkout.SessionCreateParams;

public class ItemService {


    public void justStripLogicTesting(){
        SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT);
    }

}
