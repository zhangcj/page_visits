package com.beecho.easyuse.controller;

import com.beecho.easyuse.LogModule.*;
import com.beecho.easyuse.Request.RequestConfigManager;
import com.beecho.easyuse.Request.RequestProtocol;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/30.
 */
@RestController
public class SampleController {

    @RequestMapping("/")
    public String home() {
//        Properties properties = new Properties();
//        properties.put("metadata.broker.list", "10.168.46.127:9092");
//        properties.put("serializer.class", "kafka.serializer.StringEncoder");
//        //properties.put("partitioner.class", "com.beecho.easyuse.kafka.SimplePartitioner");
//        properties.put("request.required.acks", "1");
//
//        ProducerConfig config = new ProducerConfig(properties);
//        Producer<String, String> producer = new Producer<String, String>(config);
//
//        long runtime = new Date().getTime();
//        String ip = "192.168.2." + new Random().nextInt(255);
//        String msg = runtime + ", www.autohome.com.cn, " + ip;
//
//        KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
//        producer.send(data);

//        LogEntity logEntity = new LogEntity(new LogContent("trackInfo", "message"));
//
//        ILogSaveProvider logSaveProvider = new LogSaveLocalhostProvider();
//        boolean result = logSaveProvider.saveLog(logEntity);
//
//        return result ? "ok" : "err";


        RequestConfigManager.manager.setGloableRequestSize(10) // 设置请求文本大小
        .setGloableRequestFormatJson() // 设置请求为json
        .setGloableRequestProtocol(new RequestProtocol(RequestProtocol.InternalSoa));

        return "OK";
    }
}
