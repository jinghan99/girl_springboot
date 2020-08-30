package com.yf.m3u8.vo;

/**
 * @Package com.yf.m3u8.vo
 * @Description: TODO
 * @author: jingh
 * @date 2020/8/29 17:13
 */
public class M3u8TsVo implements Comparable<M3u8TsVo> {

    private String file;
    private float  seconds;
//    第 几个 ts
    private Integer lineIndex;

    public M3u8TsVo(String file, Integer lineIndex) {
        this.file = file;
        this.lineIndex = lineIndex;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public float getSeconds() {
        return seconds;
    }

    public void setSeconds(float seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return file + " (" + seconds + "sec)";
    }


    public Integer getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(Integer lineIndex) {
        this.lineIndex = lineIndex;
    }

    /**
     * 获取时间
     */
    public long getLongDate() {
        try {
            return Long.parseLong(file.substring(0, file.lastIndexOf(".")));
        } catch (Exception e) {
            return 0;
        }
    }


    @Override
    public int compareTo(M3u8TsVo o) {
        return file.compareTo(o.file);
    }
}
