package com.yf.quartz.utils;

import com.yf.common.constant.SystemConstant;
import com.yf.sys.exception.RRException;
import com.yf.common.utils.JSONUtils;
import com.yf.common.utils.SpringContextUtils;
import com.yf.quartz.entity.QuartzJobEntity;
import org.quartz.*;

/**
 * 定时任务工具类
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午10:49:11
 */
public class ScheduleUtils {
    
	private static Scheduler scheduler = (Scheduler) SpringContextUtils.getBean("scheduler");
	
	private final static String JOB_NAME = "TASK_";
    
    /**
     * 获取触发器key
     * @param jobId
     * @return
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_NAME + jobId);
    }
    
    /**
     * 获取jobKey
     * @param jobId
     * @return
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_NAME + jobId);
    }

    /**
     * 获取表达式触发器
     * @param jobId
     * @return
     */
    public static CronTrigger getCronTrigger(Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("获取定时任务CronTrigger出现异常", e);
        }
    }

    /**
     * 创建定时任务
     * @param scheduleJob
     */
    public static void createScheduleJob(QuartzJobEntity scheduleJob) {
        try {
        	//构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(scheduleJob.getJobId())).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
            		.withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId())).withSchedule(scheduleBuilder).build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(QuartzJobEntity.JOB_PARAM_KEY, JSONUtils.beanToJson(scheduleJob));
            
            scheduler.scheduleJob(jobDetail, trigger);
            
            //暂停任务
            if(scheduleJob.getStatus() == SystemConstant.ScheduleStatus.PAUSE.getValue()){
            	pauseJob(scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            throw new RRException("创建定时任务失败", e);
        }
    }
    
    /**
     * 更新定时任务
     * @param scheduleJob
     */
    public static void updateScheduleJob(QuartzJobEntity scheduleJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduleJob.getJobId());

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
            		.withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduleJob.getJobId());
            
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            
            //参数
            trigger.getJobDataMap().put(QuartzJobEntity.JOB_PARAM_KEY, JSONUtils.beanToJson(scheduleJob));
            
            scheduler.rescheduleJob(triggerKey, trigger);
            
            //暂停任务
            if(scheduleJob.getStatus() == SystemConstant.ScheduleStatus.PAUSE.getValue()){
            	pauseJob(scheduleJob.getJobId());
            }
            
        } catch (SchedulerException e) {
            throw new RRException("更新定时任务失败", e);
        }
    }

    /**
     * 立即执行任务
     * @param scheduleJob
     */
    public static void run(QuartzJobEntity scheduleJob) {
        try {
        	//参数
        	JobDataMap dataMap = new JobDataMap();
        	dataMap.put(QuartzJobEntity.JOB_PARAM_KEY, JSONUtils.beanToJson(scheduleJob));
        	
            scheduler.triggerJob(getJobKey(scheduleJob.getJobId()), dataMap);
        } catch (SchedulerException e) {
            throw new RRException("立即执行定时任务失败", e);
        }
    }

    /**
     * 暂停任务
     * @param jobId
     */
    public static void pauseJob(Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("暂停定时任务失败", e);
        }
    }

    /**
     * 恢复任务
     * @param jobId
     */
    public static void resumeJob(Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("恢复定时任务失败", e);
        }
    }

    /**
     * 删除定时任务
     * @param jobId
     */
    public static void deleteScheduleJob(Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("删除定时任务失败", e);
        }
    }
}
