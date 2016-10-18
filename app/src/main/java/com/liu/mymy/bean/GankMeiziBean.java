package com.liu.mymy.bean;

import java.util.List;

/**
 *
 * Created by liu on 2016/10/17.
 */
public class GankMeiziBean {

    /**
     * error : false
     * results : [{"_id":"580412cc421aa90e6f21b3da","createdAt":"2016-10-17T07:52:44.2Z","desc":"10-17","publishedAt":"2016-10-17T11:32:00.914Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f8uxlbptw7j20ku0q1did.jpg","used":true,"who":"daimajia"},{"_id":"58001f88421aa95dd351b126","createdAt":"2016-10-14T07:58:00.288Z","desc":"10-14","publishedAt":"2016-10-14T11:34:54.723Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f8rgvvm5htj20u00u0q8s.jpg","used":true,"who":"代码家"},{"_id":"57fede2f421aa95dd78e8e08","createdAt":"2016-10-13T09:06:55.83Z","desc":"10-13","publishedAt":"2016-10-13T11:30:10.490Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f8qd9a4fx7j20u011hq78.jpg","used":true,"who":"daimajia"},{"_id":"57fd9af5421aa95dd78e8df1","createdAt":"2016-10-12T10:07:49.232Z","desc":"10-12","publishedAt":"2016-10-12T11:40:02.146Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f8p9eahanlj20u011h42y.jpg","used":true,"who":"daimajia"},{"_id":"57fc40a1421aa95dd78e8ddb","createdAt":"2016-10-11T09:30:09.136Z","desc":"10-11","publishedAt":"2016-10-11T11:42:22.814Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f8o2ov8xi0j20u00u0q61.jpg","used":true,"who":"daimajia"},{"_id":"57facc74421aa95de3b8ab6b","createdAt":"2016-10-10T07:02:12.35Z","desc":"10-10","publishedAt":"2016-10-10T11:41:33.500Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f8mssipb9sj20u011hgqk.jpg","used":true,"who":"daimajia"},{"_id":"57f98925421aa95de3b8ab5a","createdAt":"2016-10-09T08:02:45.353Z","desc":"10-9","publishedAt":"2016-10-09T11:45:38.236Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f8lox7c1pbj20u011h12x.jpg","used":true,"who":"daimajia"},{"_id":"57f85461421aa95dd78e8daf","createdAt":"2016-10-08T10:05:21.431Z","desc":"10-8","publishedAt":"2016-10-08T11:42:07.440Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f8kmud15q1j20u011hdjg.jpg","used":true,"who":"daimajia"},{"_id":"57edba71421aa95dd78e8d93","createdAt":"2016-09-30T09:05:53.26Z","desc":"出发去旅行","publishedAt":"2016-09-30T11:46:31.941Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f8bc5c5n4nj20u00irgn8.jpg","used":true,"who":"嗲马甲"},{"_id":"57ec633b421aa95dd78e8d86","createdAt":"2016-09-29T08:41:31.815Z","desc":"9-29","publishedAt":"2016-09-29T11:36:17.680Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f8a5uj64mpj20u00u0tca.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    /**
     * _id : 580412cc421aa90e6f21b3da
     * createdAt : 2016-10-17T07:52:44.2Z
     * desc : 10-17
     * publishedAt : 2016-10-17T11:32:00.914Z
     * source : chrome
     * type : 福利
     * url : http://ww3.sinaimg.cn/large/610dc034jw1f8uxlbptw7j20ku0q1did.jpg
     * used : true
     * who : daimajia
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
