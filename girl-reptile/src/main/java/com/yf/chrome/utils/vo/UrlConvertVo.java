package com.yf.chrome.utils.vo;

/**
 * @author jinghan
 * @title: UrlConvertVo
 * @projectName girl-springboot
 * @description: TODO
 * @date 2020/9/28 9:23
 */
public class UrlConvertVo {

    /**
     * status : true
     * message :
     * text : {"thunder":"thunder://QUFodHRwOi8vc3ZpcC5ib2NhaS16dWlkYS5jb20vMjAwOS/lhYPpvpktMTUubXA0Wlo=","qqdl":"qqdl://aHR0cDovL3N2aXAuYm9jYWktenVpZGEuY29tLzIwMDkv5YWD6b6ZLTE1Lm1wNA==","flashget":"flashget://W0ZMQVNIR0VUXWh0dHA6Ly9zdmlwLmJvY2FpLXp1aWRhLmNvbS8yMDA5L+WFg+m+mS0xNS5tcDRbRkxBU0hHRVRd","http":"http://svip.bocai-zuida.com/2009/元龙-15.mp4"}
     */

    private boolean status;
    private String   message;
    private TextBean text;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TextBean getText() {
        return text;
    }

    public void setText(TextBean text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * thunder : thunder://QUFodHRwOi8vc3ZpcC5ib2NhaS16dWlkYS5jb20vMjAwOS/lhYPpvpktMTUubXA0Wlo=
         * qqdl : qqdl://aHR0cDovL3N2aXAuYm9jYWktenVpZGEuY29tLzIwMDkv5YWD6b6ZLTE1Lm1wNA==
         * flashget : flashget://W0ZMQVNIR0VUXWh0dHA6Ly9zdmlwLmJvY2FpLXp1aWRhLmNvbS8yMDA5L+WFg+m+mS0xNS5tcDRbRkxBU0hHRVRd
         * http : http://svip.bocai-zuida.com/2009/元龙-15.mp4
         */

        private String thunder;
        private String qqdl;
        private String flashget;
        private String http;

        public String getThunder() {
            return thunder;
        }

        public void setThunder(String thunder) {
            this.thunder = thunder;
        }

        public String getQqdl() {
            return qqdl;
        }

        public void setQqdl(String qqdl) {
            this.qqdl = qqdl;
        }

        public String getFlashget() {
            return flashget;
        }

        public void setFlashget(String flashget) {
            this.flashget = flashget;
        }

        public String getHttp() {
            return http;
        }

        public void setHttp(String http) {
            this.http = http;
        }
    }

    @Override
    public String toString() {
        return "UrlConvertVo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", text=" + text +
                '}';
    }
}
