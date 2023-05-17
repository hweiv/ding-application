package com.jimi.dingtalk.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduledTask {
    private static final Logger logger = LoggerFactory.getLogger(TestScheduledTask.class);

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
//    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(initialDelay = 1000L, fixedRate = 5 * 60 * 1000)
    public void execute1() {
        logger.info("TestScheduledTask-pushBankPayment start run");
        try {
            System.out.println("Test-execute1 执行");
            Thread.sleep(10000);
            System.out.println("Test-execute1 执行完成");
        } catch (Exception e) {
            logger.error("-ScheduledTask-executor is error:{}", e);
        }
    }

//    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(initialDelay = 1000L, fixedRate = 5 * 60 * 1000)
    public void execute2() {
        logger.info("TestScheduledTask-pushBankPayment start run");
        try {
            System.out.println("Test-execute2 执行");
            Thread.sleep(10000);
            System.out.println("Test-execute2 执行完成");
        } catch (Exception e) {
            logger.error("-ScheduledTask-executor is error:{}", e);
        }
    }
}
