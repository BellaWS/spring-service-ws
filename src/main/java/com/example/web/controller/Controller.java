package com.example.web.controller;

//import com.envisioniot.enos.ecp.audit.util.JsonUtil;
import com.envisioniot.enos.ecp.log.sdk.EnvisionLogger;
import com.example.web.entity.LogEntityTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class Controller {

    private EnvisionLogger logger = EnvisionLogger.getLogger(Controller.class);
    private String logInfo;

    @RequestMapping("/hello")
    public String hello(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = "hello world ! " + dateFormat.format(date);
        logger.info("/hello : information log!");

        LogEntityTest logEntityTest = new LogEntityTest();
        logEntityTest.setLogInfo("info test for json object");
        logEntityTest.setLogWarn("warn test for json object");
        logEntityTest.setLogDebug("debug test for json object");
        logEntityTest.setLogError("error test for json object");
        log.info("normal info message = {}",logEntityTest);
        log.error("error info message = {}",logEntityTest);
        log.debug("debug info message = {}", logEntityTest);
        log.warn("warn info message = {}", logEntityTest);

        log.info("normal info message = {}",logEntityTest);
        log.error("error info message = {}",logEntityTest);
        log.debug("debug info message = {}", logEntityTest);
        log.warn("warn info message = {}", logEntityTest);

        log.warn(logEntityTest.toString());
    //    log.info(JsonUtil.toJson(logEntityTest));
        logEntityTest.setLogInfo("only only test test");
    //    log.info(JsonUtil.toJson(logEntityTest));

        return result;
    }

    @GetMapping(value="/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid)
    {
        String result = "id = "+myid;
        logger.info("/say: "+ result +" !");
        return result;
    }

    @GetMapping(value="/unknown")//unknown类型日志
    public String unknown()
    {
        logInfo = "Log level testing: This is an UNKNOWN-log!";
        System.out.println(logInfo);
        return logInfo;
    }

    @GetMapping(value="/info")//普通info类型日志
    public String info()
    {
        logInfo = "Log level testing: This is an INFO-log!";
        logger.info(logInfo);
        return logInfo;
    }

    @GetMapping("/warn")//warn类型日志
    public String warn() {
        logInfo = "Log level testing: This is a WARN-log!";
        logger.warn(logInfo);
        return logInfo;
    }

    @GetMapping("/err")//error类型日志
    public String err() {
        logInfo = "Log level testing: This is an ERROR-log！";
        logger.error(logInfo);
        return logInfo;
    }

    @GetMapping("/debug")//debug类型日志
    public String debug() {
        logInfo = "Log level testing: This is a DEBUG-log！this is mt tttsdddfsasdasasdasdtttttttest";
        logger.debug(logInfo);
        return logInfo;
    }

//    @GetMapping("/trace")//trace类型日志
//    public String trace() {
//        log = "This is an trace log！"
//        logger.trace(log);
//        return log;
//    }
}