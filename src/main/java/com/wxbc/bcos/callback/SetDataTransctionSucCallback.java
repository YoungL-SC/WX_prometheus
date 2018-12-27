package com.wxbc.bcos.callback;

import com.wxbc.bcos.engine.CommonEngine;
import com.wxbc.bcos.entity.COUconst;
import lombok.Getter;
import lombok.Setter;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.channel.dto.EthereumResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Zhaochen on 7/17/18
 */
@Getter
@Setter
@Component("setDataTransctionSucCallback")
@Scope("prototype")
public class SetDataTransctionSucCallback extends TransactionSucCallback {



    @Autowired
    CommonEngine commonEngine;

    private String tradeUuid;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void onResponse(EthereumResponse response) {

        try {
            if (response.getErrorCode() == 0) {
                int i = COUconst.count.incrementAndGet();
                if (1 == i) {
                    logger.info("first...");
                    COUconst.startTime = System.currentTimeMillis();
                } else if (com.wxbc.middle.utils.CommonConst.TEST_DATA_COUNT== i) {
                    long cost = (System.currentTimeMillis() - COUconst.startTime);
                    logger.info("last... count = "+i+" ;cost(ms) : "+cost+", tps :"+(i*1000.00/cost));
                }else if(i %1000 ==0){
                    long cost = (System.currentTimeMillis() - COUconst.startTime);
                    logger.info("i = "+i+" ;cost(ms) : "+cost+ ", tps :"+(i*1000.00/cost));
                }
            } else {
                logger.error("MiddleTransctionSucCallback-Error: uuid=" + tradeUuid + ", errorCode="
                        + response.getErrorCode() + ", errorMessage=" + response.getErrorMessage()
                        + "content=" + response.getContent());
            }
        } catch (Exception e) {
            logger.error("onResponse:", e);
        }

    }
}
