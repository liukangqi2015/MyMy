package com.liu.mymy.util;

import com.liu.mymy.bean.GankMeiziInfo;
import com.liu.mymy.bean.ResultsBean;

import java.util.List;

import io.realm.Realm;

/**
 * 数据库工具类
 * Created by liu on 2016/10/19.
 */
public class DataUtil {
    /**
     * 保存gank妹子到数据库中
     *
     * @param gankMeiziInfos
     */

    public static void putGankMeiziCache(List<GankMeiziInfo> gankMeiziInfos)
    {

        ResultsBean meizi;
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        for (int i = 0; i < gankMeiziInfos.size(); i++)
        {
            meizi = new ResultsBean();
            String url = gankMeiziInfos.get(i).url;
            String desc = gankMeiziInfos.get(i).desc;
            meizi.setUrl(url);
            meizi.setDesc(desc);
            realm.copyToRealm(meizi);
        }
        realm.commitTransaction();
        realm.close();
    }
}
