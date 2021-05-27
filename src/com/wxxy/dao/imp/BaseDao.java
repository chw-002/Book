package com.wxxy.dao.imp;

import com.wxxy.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行update delete insert 操作
     *
     * @return 返回-1 表示执行失败，返回其他表示影响行数
     */
    public int update(String sql, Object... params) {
        Connection conn = JdbcUtil.getConn();
        try {
            return queryRunner.update(conn, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeConn(conn);
        }
        return -1;
    }

    /**
     * 查询返回一条JavaBean的sql语句
     *
     * @param sql    执行的sql语句
     * @param type   返回的对象类型
     * @param params sql对应的参数
     * @param <T>    返回类型的泛型
     * @return
     */
    public <T> T queryForOne(String sql, Class<T> type, Object... params) {
        Connection conn = JdbcUtil.getConn();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeConn(conn);
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     *
     * @param sql    执行的sql语句
     * @param type   返回的对象类型
     * @param params sql对应的参数
     * @param <T>    返回类型的泛型
     * @return
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object... params) {
        Connection conn = JdbcUtil.getConn();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeConn(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的单个值的情况
     *
     * @param sql    执行的sql语句
     * @param params sql语句对应的参数
     * @return
     */
    public Object queryForSingleValue(String sql, Object... params) {
        Connection conn = JdbcUtil.getConn();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
