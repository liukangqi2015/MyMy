package com.liu.mymy.bean;

import java.util.List;

/**
 * 知乎日报实体
 * Created by liu on 2016/10/10.
 */
public class ZhiHuBean {

    /**
     * date : 20161010
     * stories : [{"images":["http://pic4.zhimg.com/993d83993cc2ed88fc61bc9faa264b3b.jpg"],"type":0,"id":8870686,"ga_prefix":"101015","title":"出了问题，先别急着责怪「强势母亲」「恶婆婆」「无能丈夫」\u2026\u2026"},{"images":["http://pic2.zhimg.com/ceab18b88bc8d3fc786c7b621c30ec0d.jpg"],"type":0,"id":8870968,"ga_prefix":"101014","title":"当城市开始衰落，解决的方法也许是「不要拯救」"},{"title":"很早以前，动画里的人物头发颜色还挺正常的，后来\u2026\u2026","ga_prefix":"101013","images":["http://pic3.zhimg.com/7c847f8bcc1244287fa934b2fed8ae62.jpg"],"multipic":true,"type":0,"id":8865033},{"images":["http://pic4.zhimg.com/afe5e88b3a3ac40074c4702d503a7f2b.jpg"],"type":0,"id":8869116,"ga_prefix":"101012","title":"大误 · 我就是一司机，你给我这么多选择是要干嘛？"},{"images":["http://pic2.zhimg.com/7f61d2478faaca89728b255618be9eb5.jpg"],"type":0,"id":8868640,"ga_prefix":"101011","title":"做好心理准备，未来的银行里可能没几人上班了"},{"images":["http://pic3.zhimg.com/79f9358565b07c9441bf97f06f47e2ca.jpg"],"type":0,"id":8860166,"ga_prefix":"101010","title":"通过改变饮食结构治疗癌症，还只是美好的设想"},{"title":"115 年里只有 17 位女性得过诺贝尔奖，这是性别歧视吗？","ga_prefix":"101009","images":["http://pic4.zhimg.com/032362de8852ee26d5bf17192c3f396f.jpg"],"multipic":true,"type":0,"id":8869430},{"images":["http://pic1.zhimg.com/f49e98148d5f44d09cc5eba9f2cd1aec.jpg"],"type":0,"id":8867769,"ga_prefix":"101008","title":"炒期货不光要懂经济，还得懂气候"},{"images":["http://pic2.zhimg.com/551e8127141e4a9948d996eb3a37bf21.jpg"],"type":0,"id":8868582,"ga_prefix":"101007","title":"在互联网上，也要为失明的他们修建一条「盲道」"},{"images":["http://pic4.zhimg.com/6cf8d1b510ab6ef8393531ac0f3f752f.jpg"],"type":0,"id":8869385,"ga_prefix":"101007","title":"如果全世界都用同一种货币，岂不是会方便很多？"},{"title":"人肉搜索了一下自己，发现网络世界真的毫无隐私","ga_prefix":"101007","images":["http://pic3.zhimg.com/7ee07063ed9f5f8b8f1c97cbd21ffc82.jpg"],"multipic":true,"type":0,"id":8867998},{"images":["http://pic2.zhimg.com/f52e55e27c969f73c831b3eb83c4e2a1.jpg"],"type":0,"id":8869410,"ga_prefix":"101007","title":"读读日报 24 小时热门 TOP 5 · 他是金庸世界里最会聊天的人"},{"images":["http://pic4.zhimg.com/aab112152dc92f904c087f755e56a58b.jpg"],"type":0,"id":8869064,"ga_prefix":"101006","title":"瞎扯 · 如何正确地吐槽"},{"images":["http://pic4.zhimg.com/e9be478788cd40a754426e8745c4a82f.jpg"],"type":0,"id":8864905,"ga_prefix":"101006","title":"这里是广告 · 当工科老王遇见直播"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/976da4d8f406c52bbbb986e6cb0c75ad.jpg","type":0,"id":8869430,"ga_prefix":"101009","title":"115 年里只有 17 位女性得过诺贝尔奖，这是性别歧视吗？"},{"image":"http://pic1.zhimg.com/34ea0211be41d9b40c60bcc120216e98.jpg","type":0,"id":8868582,"ga_prefix":"101007","title":"在互联网上，也要为失明的他们修建一条「盲道」"},{"image":"http://pic3.zhimg.com/07cdcfb2b181720c4f4126e411069ec2.jpg","type":0,"id":8867998,"ga_prefix":"101007","title":"人肉搜索了一下自己，发现网络世界真的毫无隐私"},{"image":"http://pic1.zhimg.com/b11b7f016e857ceabb499dffcfdf3760.jpg","type":0,"id":8869410,"ga_prefix":"101007","title":"读读日报 24 小时热门 TOP 5 · 他是金庸世界里最会聊天的人"},{"image":"http://pic4.zhimg.com/3351509da5aae1225a12633c7bc39c87.jpg","type":0,"id":8868229,"ga_prefix":"100917","title":"知乎好问题 · 如何高情商地说服别人所持观点是伪科学？"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/993d83993cc2ed88fc61bc9faa264b3b.jpg"]
     * type : 0
     * id : 8870686
     * ga_prefix : 101015
     * title : 出了问题，先别急着责怪「强势母亲」「恶婆婆」「无能丈夫」……
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/976da4d8f406c52bbbb986e6cb0c75ad.jpg
     * type : 0
     * id : 8869430
     * ga_prefix : 101009
     * title : 115 年里只有 17 位女性得过诺贝尔奖，这是性别歧视吗？
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
