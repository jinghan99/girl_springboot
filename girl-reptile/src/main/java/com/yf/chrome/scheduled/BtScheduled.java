package com.yf.chrome.scheduled;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.yf.chrome.constant.HomeBtEnum;
import com.yf.chrome.handler.Bt31Handler;
import com.yf.chrome.handler.Bt51Handler;
import com.yf.chrome.handler.PushDownload;
import com.yf.chrome.model.HomeBtEntity;
import com.yf.chrome.service.HomeBtService;
import com.yf.chrome.utils.vo.BtNewInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jinghan
 * @title: BtScheduled
 * @projectName girl-springboot
 * @description: Bt51Scheduled
 * @date 2020/9/24 9:23
 */
@Component
public class BtScheduled {

    private static final Logger logger = LoggerFactory.getLogger(BtScheduled.class);

    @Autowired
    private HomeBtService homeBtService;

    /**
     * 定时任务处理
     * 30分钟 执行一次
     */
    @Async("taskExecutor")
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void btScheduled() {
        try {
            executeBt51();
            executeBt31();
        } catch (Exception e) {
            logger.error("定时任务异常 {}", e.getLocalizedMessage(), e);
        }
    }

    private void executeBt51() {
        List<HomeBtEntity> byTypes = homeBtService.getByType(HomeBtEnum.BtType.BT51.getCode());
        if (ObjectUtil.isNotEmpty(byTypes)) {
            for (HomeBtEntity btEntity : byTypes) {
                int attachIndex = 0;
                if (ObjectUtil.isNotEmpty(btEntity.getBtAttachIndex())) {
                    attachIndex = btEntity.getBtAttachIndex();
                }
                List<String> btDownLoadHtmlList = Bt51Handler.find51BtDownLoadHtml(btEntity.getBtHtmlUrl(), attachIndex);
                if (ObjectUtil.isNotEmpty(btDownLoadHtmlList)) {
                    logger.info("51bt定时追更 {},当前index {} ,获取到 htmlList {} 个 ", btEntity.getBtName(), btEntity.getBtNowIndex(), btDownLoadHtmlList.size());
                    if (ObjectUtil.isEmpty(btEntity.getBtNowIndex())) {
                        btEntity.setBtNowIndex(0);
                    }
                    int size = btDownLoadHtmlList.size();
                    for (int i = btEntity.getBtNowIndex() + 1; i < size; i++) {
                        String htmlUrl = btDownLoadHtmlList.get(i);
                        BtNewInfoVo btNewInfoVo = Bt51Handler.get51BtDownLoadUrl(htmlUrl);
                        if (btNewInfoVo != null) {
                            Boolean pushCloudTorrent = PushDownload.pushCloudTorrent(btNewInfoVo.getBtUrl());
                            if (pushCloudTorrent) {
                                btEntity.setBtNowIndex(i);
                                btEntity.setBtNowInfo(btNewInfoVo.getBtName());
                            }
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


    private void executeBt31() {
        List<HomeBtEntity> byTypes = homeBtService.getByType(HomeBtEnum.BtType.BT31.getCode());
        if (ObjectUtil.isNotEmpty(byTypes)) {
            for (HomeBtEntity btEntity : byTypes) {
                int attachIndex = 0;
                if (ObjectUtil.isNotEmpty(btEntity.getBtAttachIndex())) {
                    attachIndex = btEntity.getBtAttachIndex();
                }
                List<String> btDownLoadHtmlList = Bt31Handler.find31BtDownLoadHtml(btEntity.getBtHtmlUrl());
                if (ObjectUtil.isNotEmpty(btDownLoadHtmlList)) {
                    logger.info("31bt定时追更 {},当前index {} ,获取到 htmlList {} 个 ", btEntity.getBtName(), btEntity.getBtNowIndex(), btDownLoadHtmlList.size());
                    if (ObjectUtil.isEmpty(btEntity.getBtNowIndex())) {
                        btEntity.setBtNowIndex(0);
                    }
                    int i = btEntity.getBtNowIndex() + 1;
                    int size = btDownLoadHtmlList.size();
                    for (; i < size; i++) {
                        String htmlUrl = btDownLoadHtmlList.get(i);
                        String btDownLoadUrl = Bt31Handler.get31BtDownLoadUrl(htmlUrl);
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
