package com.liu.mymy.bean;

import java.util.List;

/**
 * 干货集中营Android实体
 * Created by liu on 2016/10/14.
 */
public class GankAndroidBean {

    /**
     * error : false
     * results : [{"_id":"57ff53c3421aa95ddb9cb5de","createdAt":"2016-10-13T17:28:35.999Z","desc":"打造鲁棒的安卓APP，从此告别 Activity Not Found、Activity State Loss 和 fragment transaction 中的 NPE","publishedAt":"2016-10-14T11:34:54.723Z","source":"web","type":"Android","url":"https://github.com/Piasy/SafelyAndroid","used":true,"who":"Piasy"},{"_id":"580020cc421aa95dd351b127","createdAt":"2016-10-14T08:03:24.841Z","desc":"大众点评开源的分布式服务通信框架（RPC），是大众点评最基础的底层框架之一。","publishedAt":"2016-10-14T11:34:54.723Z","source":"chrome","type":"Android","url":"https://github.com/dianping/pigeon/blob/master/USER_GUIDE.md","used":true,"who":"代码家"},{"_id":"5800268e421aa95ddb9cb5e3","createdAt":"2016-10-14T08:27:58.242Z","desc":"打造鲁棒的安卓APP，从此告别 Activity Not Found 错误和 Activity State Loss 错误 （原文链接）","publishedAt":"2016-10-14T11:34:54.723Z","source":"chrome","type":"Android","url":"http://blog.piasy.com/2016/04/03/Safely-Android/","used":true,"who":"代码家"},{"_id":"58003ded421aa95dd78e8e14","createdAt":"2016-10-14T10:07:41.447Z","desc":"Google 开源了一个专为 VR 设计的相机 App。","images":["http://img.gank.io/45d98d26-2e21-4f70-a539-1e98d39ee981"],"publishedAt":"2016-10-14T11:34:54.723Z","source":"chrome","type":"Android","url":"https://github.com/googlecreativelab/Sprayscape","used":true,"who":"机器人"},{"_id":"57e4c303421aa95bc7f06a9d","createdAt":"2016-09-23T13:52:03.800Z","desc":"Android Linker 与 SO 加壳技术","publishedAt":"2016-10-13T11:30:10.490Z","source":"chrome","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzA3NTYzODYzMg==&amp;mid=2653577840&amp;idx=1&amp;sn=df50a9ba89673655d0ddc4b3c1bb30e6&amp;scene=0#rd","used":true,"who":"LHF"},{"_id":"57e7e7fd421aa95de3b8aad9","createdAt":"2016-09-25T23:06:37.257Z","desc":"支持左右两边同时滚动的进度条","images":["http://img.gank.io/08a79d2c-d17d-41df-8e93-f8c7322ca99e"],"publishedAt":"2016-10-13T11:30:10.490Z","source":"web","type":"Android","url":"https://github.com/alex5241/AwesomeProgressbar","used":true,"who":"alex"},{"_id":"57fe7a40421aa95de3b8ab98","createdAt":"2016-10-13T02:00:32.256Z","desc":"方便简洁的BottomDialog，支持任意布局","images":["http://img.gank.io/02df349b-806b-471f-8f60-4376c3796f73","http://img.gank.io/a4e3f48f-cb51-41c3-aa5b-ef7722561e81"],"publishedAt":"2016-10-13T11:30:10.490Z","source":"web","type":"Android","url":"https://github.com/shaohui10086/BottomDialog","used":true,"who":"邵辉Vista"},{"_id":"57fca10c421aa95dd78e8de5","createdAt":"2016-10-11T16:21:32.80Z","desc":"转换QQ微信语音格式转为mp3","publishedAt":"2016-10-12T11:40:02.146Z","source":"chrome","type":"Android","url":"https://github.com/ketn4391/android_silk_v3_decoder","used":true,"who":"蒋朋"},{"_id":"57fd262f421aa95dd351b104","createdAt":"2016-10-12T01:49:35.190Z","desc":"简化上传图片之前必需的压缩方法","publishedAt":"2016-10-12T11:40:02.146Z","source":"web","type":"Android","url":"https://github.com/shaohui10086/AdvancedLuban","used":true,"who":"邵辉Vista"},{"_id":"57fd9964421aa95dd351b106","createdAt":"2016-10-12T10:01:08.961Z","desc":"一个漂亮的 Share Button UI 效果。","images":["http://img.gank.io/ee1fcfbd-20a5-4819-943c-80d55301dc4d"],"publishedAt":"2016-10-12T11:40:02.146Z","source":"chrome","type":"Android","url":"https://github.com/kayan1990/ShareButton","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 57ff53c3421aa95ddb9cb5de
     * createdAt : 2016-10-13T17:28:35.999Z
     * desc : 打造鲁棒的安卓APP，从此告别 Activity Not Found、Activity State Loss 和 fragment transaction 中的 NPE
     * publishedAt : 2016-10-14T11:34:54.723Z
     * source : web
     * type : Android
     * url : https://github.com/Piasy/SafelyAndroid
     * used : true
     * who : Piasy
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
