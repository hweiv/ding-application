package com.jimi.dingtalk.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankScheduledTask {
    private static final Logger logger = LoggerFactory.getLogger(BankScheduledTask.class);

    /*
     * 推送到钉钉群
     * 60秒后执行，每隔1*60*60秒（1小时）执行, 单位：ms。
     * @Scheduled(initialDelay = 1000L, fixedRate = 1* 60 * 60 * 1000)
     */
    /**
     * 执行银行记录的数据，每点0分0秒 执行，每隔 10 分钟执行一次
     *
     * @Scheduled(cron = "30 59 0/1 * * ?")
     * 秒、分、时、日、月、周
     */
    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(initialDelay = 1000L, fixedRate = 5 * 60 * 1000)
    public void execute1() {
        logger.info("BankScheduledTask-pushBankPayment start run");
        try {
            System.out.println("execute1 执行");
            Thread.sleep(10000);
            System.out.println("execute1 执行完成");
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.error("-ScheduledTask-executor is error:{}", e);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(initialDelay = 1000L, fixedRate = 5 * 60 * 1000)
    public void execute2() {
        logger.info("BankScheduledTask-pushBankPayment start run");
        try {
            System.out.println("execute2 执行");
            Thread.sleep(10000);
            System.out.println("execute2 执行完成");

        } catch (Exception e) {
            logger.error("-ScheduledTask-executor is error:{}", e);
        }
    }
}
