package com.yf.chrome.scheduled;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yf.chrome.client.ChromeReptileClient;
import com.yf.chrome.constant.HomeBtEnum;
import com.yf.chrome.handler.Bt51Handler;
import com.yf.chrome.handler.PushDownload;
import com.yf.chrome.model.HomeBtEntity;
import com.yf.chrome.service.HomeBtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jinghan
 * @title: BtScheduled
 * @projectName girl-springboot
 * @description: Bt51Scheduled
 * @date 2020/9/24 9:23
 */
@Component
public class Bt51Scheduled {

    private static final Logger logger = LoggerFactory.getLogger(Bt51Scheduled.class);


    @Autowired
    private HomeBtService homeBtService;


    /**
     * 定时任务处理
     * 11秒处理
     * 1 小时 执行一次
     */
    @Async("taskExecutor")
//    @Scheduled(cron = "0/11 * * * * ? ")
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void bt51Scheduled() {
        List<HomeBtEntity> byTypes = homeBtService.getByType(HomeBtEnum.BtType.BT51.getCode());
        if (ObjectUtil.isNotEmpty(byTypes)) {
            for (HomeBtEntity btEntity : byTypes) {
                List<String> btDownLoadHtmlList = Bt51Handler.find51BtDownLoadHtml(btEntity.getBtHtmlUrl());
                logger.info("bt定时追更 {},当前index {} ,获取到 htmlList {} 个 ", btEntity.getBtName(), btEntity.getBtNowIndex(), btDownLoadHtmlList.size());
                if (ObjectUtil.isNotEmpty(btDownLoadHtmlList)) {
                    if (ObjectUtil.isEmpty(btEntity.getBtNowIndex())) {
                        btEntity.setBtNowIndex(0);
                    }
                    int i = btEntity.getBtNowIndex() + 1;
                    int size = btDownLoadHtmlList.size();
                    for (; i < size; i++) {
                        String htmlUrl = btDownLoadHtmlList.get(i);
                        String btDownLoadUrl = Bt51Handler.get51BtDownLoadUrl(htmlUrl);
                        Boolean pushCloudTorrent = PushDownload.pushCloudTorrent(btDownLoadUrl);
                        if (pushCloudTorrent) {
                            btEntity.setBtNowIndex(i);
                        }
                    }
                    btEntity.setBtCheckTime(DateUtil.date());
                    btEntity.setBtUpdateTime(DateUtil.date());
                    btEntity.setBtDownloadUrlJson(JSONUtil.toJsonStr(btDownLoadHtmlList));
                    homeBtService.updateById(btEntity);
                }
            }
        }
    }
}
