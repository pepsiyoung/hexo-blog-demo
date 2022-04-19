package com.pepsiyoung.web2.config.sqlInterceptor;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;

public class MySqlInjector implements InnerInterceptor {

    @SneakyThrows
    @Override
    public boolean willDoQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {

//        Boolean res = InterceptorIgnoreHelper.willIgnoreDataPermission(ms.getId());
        int lastDotIndex = ms.getId().lastIndexOf(StringPool.DOT);
        String className = ms.getId().substring(0, lastDotIndex);
        String methodName = ms.getId().substring(lastDotIndex + 1);
        Method[] methods = Class.forName(className).getMethods();
        Boolean res = Arrays.stream(methods).anyMatch(item -> item.getName().equals(methodName) && item.getAnnotation(Select.class) != null);
        System.out.println(res);
        return true;
    }

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
//        String changeSql = boundSql.getSql() + " where name = 'zzz'";
        String changeSql = boundSql.getSql();
        mpBs.sql(changeSql);
    }
}
