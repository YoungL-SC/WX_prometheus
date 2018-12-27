package com.wxbc.middle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxbc.bcos.engine.CommonEngine;
import com.wxbc.bcos.entity.COUconst;
import com.wxbc.middle.bean.CouQouta;
import com.wxbc.middle.bean.ResponseFormat;
import com.wxbc.middle.bean.ReturnCode;
import com.wxbc.middle.bean.TestData;
import com.wxbc.middle.utils.CommonConst;
import com.wxbc.middle.utils.SHAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Zhaochen on 11/6/18
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class TestController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    CommonEngine commonEngine;
    String index = "start";
    String file = "你好啊";


    @ResponseBody
    @RequestMapping(value = "/rest/setJsonData/{size}/{threads}", produces = {CommonConst.PRODUCE}, method =
            RequestMethod.GET)
    public ResponseFormat test5(@PathVariable("size") int size,
                                @PathVariable("threads") int threads) throws JsonProcessingException {
        ResponseFormat responseFormat = new ResponseFormat(ReturnCode.CREATE_SUCCESS);
        // String callingapi = "setJsonData";
        com.wxbc.middle.utils.CommonConst.TEST_DATA_COUNT = size;
        COUconst.count.set(0);
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < com.wxbc.middle.utils.CommonConst.TEST_DATA_COUNT; i++) {
            TestData testData = new TestData();
            Date date = new Date();
            String indexHash = SHAUtils.SHA256(index + String.valueOf(date.getTime()));
            String fileHash = SHAUtils.SHA256(file + String.valueOf(date.getTime()));
            testData.setIndexHash(indexHash);
            testData.setFileHash(fileHash);
            String tradeUuid = UUID.randomUUID().toString().replace("-", "");
            threadPool.execute(new TestController.ThreadBcosSetJsonData(tradeUuid, mapper.writeValueAsString(testData), tradeUuid));
        }
        return responseFormat;
    }

    class ThreadBcosSetJsonData implements Runnable {
        private String key;
        private String value;
        private String tradeUuid;

        public ThreadBcosSetJsonData(String key, String value, String tradeUuid) {
            this.key = key;
            this.value = value;
            this.tradeUuid = tradeUuid;
        }

        @Override
        public void run() {
            try {
                commonEngine.setJsonData(key, value, tradeUuid);
            } catch (Exception e) {
                log.error("ThreadBcosSetData:", e);
            }
        }
    }
}

