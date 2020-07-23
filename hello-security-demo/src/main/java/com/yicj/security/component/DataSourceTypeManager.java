package com.yicj.security.component;


/**
 * ClassName: DataSourceTypeManager
 * Description: TODO(描述)
 * Date: 2020/7/23 13:23
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class DataSourceTypeManager {

    private static final ThreadLocal<DataSourceType> dsTypes = ThreadLocal.withInitial(() -> DataSourceType.MAIN);


    public static DataSourceType get(){
        return dsTypes.get() ;
    }

    public static void set(DataSourceType dataSourceType){
        dsTypes.set(dataSourceType);
    }
}