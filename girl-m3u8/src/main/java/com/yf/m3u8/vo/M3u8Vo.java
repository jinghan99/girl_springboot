package com.yf.m3u8.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Package com.yf.m3u8.vo
 * @Description: m3u8 映射实体
 * @author: jingh
 * @date 2020/8/29 17:12
 */
public class M3u8Vo {
    private String         basepath;
    private String         nextUrl;
    private List<M3u8TsVo> tsList = new ArrayList<>();
    private long           startTime;// 开始时间
    private long           endTime;// 结束时间
    private long           startDownloadTime;// 开始下载时间
    private long           endDownloadTime;// 结束下载时间


    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public List<M3u8TsVo> getTsList() {
        return tsList;
    }

    public void addTs(M3u8TsVo ts) {
        this.tsList.add(ts);
    }

    public void setTsList(List<M3u8TsVo> tsList) {
        this.tsList = tsList;
    }


    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartDownloadTime() {
        return startDownloadTime;
    }

    public void setStartDownloadTime(long startDownloadTime) {
        this.startDownloadTime = startDownloadTime;
    }

    public long getEndDownloadTime() {
        return endDownloadTime;
    }

    public void setEndDownloadTime(long endDownloadTime) {
        this.endDownloadTime = endDownloadTime;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    /**
     * 获取开始时间
     *
     * @return
     */
    public long getStartTime() {
        if (tsList.size() > 0) {
            Collections.sort(tsList);
            startTime = tsList.get(0).getLongDate();
            return startTime;
        }
        return 0;
    }

    /**
     * 获取结束时间(加上了最后一段时间的持续时间)
     *
     * @return
     */
    public long getEndTime() {
        if (tsList.size() > 0) {
            M3u8TsVo m3U8Ts = tsList.get(tsList.size() - 1);
            endTime = m3U8Ts.getLongDate() + (long) (m3U8Ts.getSeconds() * 1000);
            return endTime;
        }
        return 0;
    }


}
