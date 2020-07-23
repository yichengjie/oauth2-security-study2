package com.yicj.security.component;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName: ThreadLocalVariableRoutingDataSource
 * Description: TODO(描述)
 * Date: 2020/7/23 13:22
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class ThreadLocalVariableRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceTypeManager.get();
    }


    /**
     * DataSourceTypeManager.set(DataSourceType.INFO) ;
     *
     * map的key-type属性指明了键值的类型，否则，就得通过其他方式来确定枚举类的各值做为key与目标数据源之前的对应关系
     *
     * 方式1：
     * <bean id = "dataSource" class ="...ThreadLocalVariableRoutingDataSource">
     *      <property name = "defaultTargetDataSource" ref =""></property>
     *      <property name ="targetDataSource">
     *         <map key-type ="...DataSourceType">
     *              <entry key ="MAIN" value-ref ="mainDataSource"></entry>
     *              <entry key ="INFO" value-ref ="infoDataSource"></entry>
     *              <entry key ="DBLINK" value-ref ="dblinkDataSource"></entry>
     *         </map>
     *      </property>
     * </>
     *
     *
     *
     *  方式2：
     *  因为我们不想使用AbstractRoutingDataSource默认的键值查找行为（根据指定的键值通过JNDI进行查找）,
     *  所以为其重新设置了DataSourceLookup，转而使用MapDataSourceLookup
     *  <util:map id ="dataSources">
     *      <entry key ="MAIN" value-ref ="mainDataSource"></entry>
     *      <entry key ="INFO" value-ref ="infoDataSource"></entry>
     *      <entry key ="DBLINK" value-ref ="dblinkDataSource"></entry>
     *  </util:map>
     *
     *  <bean id ="dataSourceLookup" class ="org.springframework.jdbc.datasource.lookup.MapDataSourceLookup">
     *      <constructor-arg>
     *          <ref bean = "dataSources"></ref>
     *      </constructor-arg>
     *  </bean>
     *
     *  <bean id ="dataSource" class ="...ThreadLocalVariableRoutingDataSource">
     *      <property name = "defaultTargetDataSource" ref =""></property>
     *      <property name ="targetDataSource" ref ="dataSources"></property>
     *      <property name ="dataSourceLookup" ref ="dataSourceLookup"></property>
     *  </bean>
     */
}