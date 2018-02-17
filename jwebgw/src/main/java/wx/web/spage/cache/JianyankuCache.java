package wx.web.spage.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import wx.web.spage.bean.Spage_jingyankuSimple;
import wx.web.spage.service.JingyankuService;

/**
 *
 * @author jweb wx.web.spage.cache.JianyankuCache.CACHE
 */
public class JianyankuCache extends system.base.cache.CacheData {

    private List<Spage_jingyankuSimple> list;
    private final Map<String, List<Spage_jingyankuSimple>> simpleList = new HashMap<>();
    final static public system.base.cache.CacheCenter CACHE = new system.base.cache.CacheCenter(JianyankuCache.class);

    //,zdyJson;
    @Override
    public void loadData(system.db.Service db) {
        this.list = JingyankuService.selectVast(null);
        this.simpleList.clear();
        List<Spage_jingyankuSimple> allList = new ArrayList<>(list.size());
        copyMyObject(allList);
        while (allList.size() > 0) {
            findMyfl(allList.get(0), allList);
        }
    }

    private void copyMyObject(final List<Spage_jingyankuSimple> allList) {
        for (Spage_jingyankuSimple obj : this.list) {
            allList.add(obj);
        }
    }

    public List getList() {
        return this.list;
    }

    public String getJSON(String flid, String bt, String key) {
        List<Spage_jingyankuSimple> f = new ArrayList<>();
        List<Spage_jingyankuSimple> mapf;
        int fi = 0;
        boolean bid, bbt, bkey;
        String keys[];
        bid = null == flid || flid.isEmpty();
        bbt = null == bt || bt.isEmpty();
        bkey = null == key || key.isEmpty();

        if (bid && bbt && bkey) { //默认打开首页时 展示99条记录
            while (this.list.size() > fi && fi < 100) {
                f.add(this.list.get(fi++));
            }
            return getMyJSON(f);//无须后续处理。直接返回json数据

        } else if (!bid && bbt & bkey) {//存在按分类,不存在 关键词或标题时，取出分类的集合 直接返回，无须后续处理
            String[] flids = flid.split(",");
            for (String str : flids) {
                mapf = simpleList.get(str);
                if (null != mapf) {
                    f.addAll(simpleList.get(str));
                }
            }
            return getMyJSON(f);
        } else if (!bid) {//存在按分类,并存在关键词或标题时，取出分类的集合，须后续处理
            String[] flids = flid.split(",");
            for (String str : flids) {
                mapf = simpleList.get(str);
                if (null != mapf) {
                    f.addAll(simpleList.get(str));
                }
            }
        } else {//不存在分类时，必然存在 关键词或标题。给它所有数据。表示在所有数据找到匹配的数据
            f.addAll(this.list);
        }

        List<Spage_jingyankuSimple> rs = new ArrayList<>();
        Set<Spage_jingyankuSimple> set = new HashSet<>();

        //开始匹配相似值数据
        //标题与关键词
        if (!bbt && !bkey) {
            keys = key.split(" ");
            for (Spage_jingyankuSimple rObj : f) {
                //对象包括此标题 或 对象的词与 客户关键关词匹配。
                if (rObj.getSpage_jingyanku_biaoti().contains(bt) || hasTheKey(keys, rObj)) {
                    set.add(rObj);//加入返回集合中
                }
            }
            rs.addAll(set);

        } else if (!bkey) {//只有关键词不为空时
            keys = key.split(" ");
            rs.addAll(checkKey(keys, f));
        } else {//只有标题不为空时
            for (Spage_jingyankuSimple rObj : f) {
                //对象包括此标题
                if (rObj.getSpage_jingyanku_biaoti().contains(bt)) {
                    rs.add(rObj);//加入返回集合中
                }
            }
        }
        return getMyJSON(rs);
    }

    /**
     * 检查关键词是否匹配 此对象的关键词 一般6个关键词足于精简出想要的记录
     */
    private static boolean hasTheKey(final String[] key, final Spage_jingyankuSimple obj) {
        switch (key.length) {
            case 0:
                return false;
            case 1:
                return obj.getSpage_jingyanku_gjc().contains(key[0]);
            case 2:
                return obj.getSpage_jingyanku_gjc().contains(key[0])
                        && obj.getSpage_jingyanku_gjc().contains(key[1]);
            case 3:
                return obj.getSpage_jingyanku_gjc().contains(key[0])
                        && obj.getSpage_jingyanku_gjc().contains(key[1])
                        && obj.getSpage_jingyanku_gjc().contains(key[2]);
            case 4:
                return obj.getSpage_jingyanku_gjc().contains(key[0])
                        && obj.getSpage_jingyanku_gjc().contains(key[1])
                        && obj.getSpage_jingyanku_gjc().contains(key[2])
                        && obj.getSpage_jingyanku_gjc().contains(key[3]);
            case 5:
                return obj.getSpage_jingyanku_gjc().contains(key[0])
                        && obj.getSpage_jingyanku_gjc().contains(key[1])
                        && obj.getSpage_jingyanku_gjc().contains(key[2])
                        && obj.getSpage_jingyanku_gjc().contains(key[3])
                        && obj.getSpage_jingyanku_gjc().contains(key[4]);
            default:
                return obj.getSpage_jingyanku_gjc().contains(key[0])
                        && obj.getSpage_jingyanku_gjc().contains(key[1])
                        && obj.getSpage_jingyanku_gjc().contains(key[2])
                        && obj.getSpage_jingyanku_gjc().contains(key[3])
                        && obj.getSpage_jingyanku_gjc().contains(key[4])
                        && obj.getSpage_jingyanku_gjc().contains(key[5]);
        }
    }

    /**
     * 找出所有与key匹配的
     *
     * @param key
     * @param list
     * @return
     */
    private static List<Spage_jingyankuSimple> checkKey(final String[] key, final List<Spage_jingyankuSimple> list) {
        List<Spage_jingyankuSimple> rs = new ArrayList<>();
        Set<Spage_jingyankuSimple> set = new HashSet<>();

        xx:
        for (Spage_jingyankuSimple obj : list) {
            for (String str : key) {
                if (!obj.getSpage_jingyanku_gjc().contains(str)) {
                    continue xx;
                }
            }
            set.add(obj);
        }
        rs.addAll(set);
        return rs;
    }

    private static String getMyJSON(List<Spage_jingyankuSimple> list) {
        StringBuilder sb = new StringBuilder();
        for (Spage_jingyankuSimple f : list) {
            sb.append(",{\"spage_jingyanku_zj\": \"").append(f.getSpage_jingyanku_zj())
                    .append("\",\"spage_jingyanku_biaoti\": \"").append(f.getSpage_jingyanku_biaoti())
                    .append("\",\"spage_jingyanku_gjc\": \"").append(f.getSpage_jingyanku_gjc())
                    .append("\",\"spage_jingyanku_fabushijian\": \"").append(f.getSpage_jingyanku_fabushijian())
                    .append("\",\"spage_jingyanku_zhidanren\": \"").append(f.getSpage_jingyanku_zhidanren())
                    .append("\",\"spage_jingyanku_zhidanren_zj\": \"").append(f.getSpage_jingyanku_zhidanren_zj())
                    .append("\",\"jingyankufl_id\": \"").append(f.getJingyankufl_id())
                    .append("\",\"jingyankufl_name\": \"").append(f.getJingyankufl_name())
                    .append("\",\"spage_jingyanku_zhidanshijian\": \"").append(f.getSpage_jingyanku_zhidanshijian()).append("\"}");
        }
        return sb.length() == 0 ? "[]" : "[" + sb.substring(1) + "]";
    }

    private void findMyfl(Spage_jingyankuSimple obj, List<Spage_jingyankuSimple> list) {
        List<Spage_jingyankuSimple> rs = simpleList.get(obj.getJingyankufl_id());
        boolean i = false;
        if (null == rs) {
            rs = new ArrayList<>();
            i = true;
        }
        for (Spage_jingyankuSimple f : list) {
            if (obj.getJingyankufl_id().equals(f.getJingyankufl_id())) {
                rs.add(f);
            }
        }
        if (i) {
            simpleList.put(obj.getJingyankufl_id(), rs);
        }
        list.removeAll(rs);
    }
}
