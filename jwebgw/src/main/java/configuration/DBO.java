package configuration;

import configuration.KeyModel;
import system.base.cache.CacheCenter;
import system.db.DBEngine;
import system.db.DBEngineFactory;
import system.db.Service;
import system.web.JWeb;

/**
 * 
 * @author wangchunzi
 */
public abstract class DBO extends KeyModel {

    private final static DBEngine db;
    public final static Service service;
    
    static {
        db = DBEngineFactory.getDBEngine();
        service = db.service;
        CacheCenter.SetDB(service);
    }
    
    /**
     * 1+，0，-1三种状态
     *
     * @param jw
     * @param i
     */
    public final static void out_add_1_0_f1(JWeb jw, final int i) {
        //添加成功
        if (i > 0) {
            jw.printOne(ReturnKey.ADD_SUCESS.statusCode);
            return;
        }
        //添加失败或 查询唯一值时不通过。
        jw.printOne(i == 0 ? KeyModel.ReturnKey.ADD_ERROR.statusCode : KeyModel.ReturnKey.ADD_UNIQUE.statusCode);
    }
    
    /**
     * 1+，0，-1三种状态
     *
     * @param jw
     * @param i
     */
    public final static void out_dell_1_0_f1(JWeb jw, final int i) {
        //添加成功
        if (i > 0) {
            jw.printOne(ReturnKey.DELL_SUCESS.statusCode);
            return;
        }
        //添加失败或 查询唯一值时不通过。
        jw.printOne(i == 0 ? KeyModel.ReturnKey.DELL_ERROR.statusCode : KeyModel.ReturnKey.DELL_UNIQUE.statusCode);
    }
    
    /**
     * 1+，0，-1三种状态
     *
     * @param jw
     * @param i
     */
    public final static void out_update_1_0_f1(JWeb jw, final int i) {
        //添加成功
        if (i > 0) {
            jw.printOne(ReturnKey.UPDATE_SUCESS.statusCode);
            return;
        }
        //添加失败或 查询唯一值时不通过。
        jw.printOne(i == 0 ? KeyModel.ReturnKey.UPDATE_ERROR.statusCode : KeyModel.ReturnKey.UPDATE_UNIQUE.statusCode);
    }
}
