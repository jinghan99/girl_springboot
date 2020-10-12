package com.yf.chrome.model;

import java.io.Serializable;
import java.util.Date;

public class HomeBtEntity implements Serializable {
    private Long btId;

    private String btName;

    private String btType;

    private String btHtmlUrl;

    private Integer btAttachIndex;

    private Integer btNowIndex;

    private String btNowInfo;

    private Date btCreateTime;

    private Date btUpdateTime;

    private Date btCheckTime;

    private String btDownloadUrlJson;

    private static final long serialVersionUID = 1L;

    public Long getBtId() {
        return btId;
    }

    public void setBtId(Long btId) {
        this.btId = btId;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public String getBtType() {
        return btType;
    }

    public void setBtType(String btType) {
        this.btType = btType;
    }

    public String getBtHtmlUrl() {
        return btHtmlUrl;
    }

    public void setBtHtmlUrl(String btHtmlUrl) {
        this.btHtmlUrl = btHtmlUrl;
    }

    public Integer getBtAttachIndex() {
        return btAttachIndex;
    }

    public void setBtAttachIndex(Integer btAttachIndex) {
        this.btAttachIndex = btAttachIndex;
    }

    public Integer getBtNowIndex() {
        return btNowIndex;
    }

    public void setBtNowIndex(Integer btNowIndex) {
        this.btNowIndex = btNowIndex;
    }

    public String getBtNowInfo() {
        return btNowInfo;
    }

    public void setBtNowInfo(String btNowInfo) {
        this.btNowInfo = btNowInfo;
    }

    public Date getBtCreateTime() {
        return btCreateTime;
    }

    public void setBtCreateTime(Date btCreateTime) {
        this.btCreateTime = btCreateTime;
    }

    public Date getBtUpdateTime() {
        return btUpdateTime;
    }

    public void setBtUpdateTime(Date btUpdateTime) {
        this.btUpdateTime = btUpdateTime;
    }

    public Date getBtCheckTime() {
        return btCheckTime;
    }

    public void setBtCheckTime(Date btCheckTime) {
        this.btCheckTime = btCheckTime;
    }

    public String getBtDownloadUrlJson() {
        return btDownloadUrlJson;
    }

    public void setBtDownloadUrlJson(String btDownloadUrlJson) {
        this.btDownloadUrlJson = btDownloadUrlJson;
    }

    public static HomeBtEntity.Builder builder() {
        return new HomeBtEntity.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", btId=").append(btId);
        sb.append(", btName=").append(btName);
        sb.append(", btType=").append(btType);
        sb.append(", btHtmlUrl=").append(btHtmlUrl);
        sb.append(", btAttachIndex=").append(btAttachIndex);
        sb.append(", btNowIndex=").append(btNowIndex);
        sb.append(", btNowInfo=").append(btNowInfo);
        sb.append(", btCreateTime=").append(btCreateTime);
        sb.append(", btUpdateTime=").append(btUpdateTime);
        sb.append(", btCheckTime=").append(btCheckTime);
        sb.append(", btDownloadUrlJson=").append(btDownloadUrlJson);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HomeBtEntity other = (HomeBtEntity) that;
        return (this.getBtId() == null ? other.getBtId() == null : this.getBtId().equals(other.getBtId()))
            && (this.getBtName() == null ? other.getBtName() == null : this.getBtName().equals(other.getBtName()))
            && (this.getBtType() == null ? other.getBtType() == null : this.getBtType().equals(other.getBtType()))
            && (this.getBtHtmlUrl() == null ? other.getBtHtmlUrl() == null : this.getBtHtmlUrl().equals(other.getBtHtmlUrl()))
            && (this.getBtAttachIndex() == null ? other.getBtAttachIndex() == null : this.getBtAttachIndex().equals(other.getBtAttachIndex()))
            && (this.getBtNowIndex() == null ? other.getBtNowIndex() == null : this.getBtNowIndex().equals(other.getBtNowIndex()))
            && (this.getBtNowInfo() == null ? other.getBtNowInfo() == null : this.getBtNowInfo().equals(other.getBtNowInfo()))
            && (this.getBtCreateTime() == null ? other.getBtCreateTime() == null : this.getBtCreateTime().equals(other.getBtCreateTime()))
            && (this.getBtUpdateTime() == null ? other.getBtUpdateTime() == null : this.getBtUpdateTime().equals(other.getBtUpdateTime()))
            && (this.getBtCheckTime() == null ? other.getBtCheckTime() == null : this.getBtCheckTime().equals(other.getBtCheckTime()))
            && (this.getBtDownloadUrlJson() == null ? other.getBtDownloadUrlJson() == null : this.getBtDownloadUrlJson().equals(other.getBtDownloadUrlJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBtId() == null) ? 0 : getBtId().hashCode());
        result = prime * result + ((getBtName() == null) ? 0 : getBtName().hashCode());
        result = prime * result + ((getBtType() == null) ? 0 : getBtType().hashCode());
        result = prime * result + ((getBtHtmlUrl() == null) ? 0 : getBtHtmlUrl().hashCode());
        result = prime * result + ((getBtAttachIndex() == null) ? 0 : getBtAttachIndex().hashCode());
        result = prime * result + ((getBtNowIndex() == null) ? 0 : getBtNowIndex().hashCode());
        result = prime * result + ((getBtNowInfo() == null) ? 0 : getBtNowInfo().hashCode());
        result = prime * result + ((getBtCreateTime() == null) ? 0 : getBtCreateTime().hashCode());
        result = prime * result + ((getBtUpdateTime() == null) ? 0 : getBtUpdateTime().hashCode());
        result = prime * result + ((getBtCheckTime() == null) ? 0 : getBtCheckTime().hashCode());
        result = prime * result + ((getBtDownloadUrlJson() == null) ? 0 : getBtDownloadUrlJson().hashCode());
        return result;
    }

    public static class Builder {
        private HomeBtEntity obj;

        public Builder() {
            this.obj = new HomeBtEntity();
        }

        public Builder btId(Long btId) {
            obj.setBtId(btId);
            return this;
        }

        public Builder btName(String btName) {
            obj.setBtName(btName);
            return this;
        }

        public Builder btType(String btType) {
            obj.setBtType(btType);
            return this;
        }

        public Builder btHtmlUrl(String btHtmlUrl) {
            obj.setBtHtmlUrl(btHtmlUrl);
            return this;
        }

        public Builder btAttachIndex(Integer btAttachIndex) {
            obj.setBtAttachIndex(btAttachIndex);
            return this;
        }

        public Builder btNowIndex(Integer btNowIndex) {
            obj.setBtNowIndex(btNowIndex);
            return this;
        }

        public Builder btNowInfo(String btNowInfo) {
            obj.setBtNowInfo(btNowInfo);
            return this;
        }

        public Builder btCreateTime(Date btCreateTime) {
            obj.setBtCreateTime(btCreateTime);
            return this;
        }

        public Builder btUpdateTime(Date btUpdateTime) {
            obj.setBtUpdateTime(btUpdateTime);
            return this;
        }

        public Builder btCheckTime(Date btCheckTime) {
            obj.setBtCheckTime(btCheckTime);
            return this;
        }

        public Builder btDownloadUrlJson(String btDownloadUrlJson) {
            obj.setBtDownloadUrlJson(btDownloadUrlJson);
            return this;
        }

        public HomeBtEntity build() {
            return this.obj;
        }
    }
}