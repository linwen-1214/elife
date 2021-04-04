package cn.ylw.evaluation.handler;

import cn.ylw.evaluation.enums.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: ylw
 * @date: 2021年04月04日 11时49分
 * @description:
 */
public class StatusTypeHandler extends BaseTypeHandler<StatusEnum> {
    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, StatusEnum statusEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, statusEnum.value());
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public StatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int statusValue = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        }
        return StatusEnum.valueOf(statusValue);
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public StatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int statusValue = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        }
        return StatusEnum.valueOf(statusValue);
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public StatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int statusValue = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        }
        return StatusEnum.valueOf(statusValue);
    }
}
