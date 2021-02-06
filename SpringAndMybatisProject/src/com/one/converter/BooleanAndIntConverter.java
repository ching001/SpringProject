package com.one.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

//BaseTypeHandler<java类型>
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {

	//java(boolean)->DB(number)
	/* ps:PreparedStatement对象
	 * i:PreparedStatement对象操作参数的位置
	 * parameter：java值
	 * jdbcType：jdbc操作数据库类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		if(parameter) {
			ps.setInt(i, 1);
		}else {
			ps.setInt(i, 0);
		}
	}

	//DB(number)->java(boolean)
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int sex = rs.getInt(columnName);
		return sex==1 ? true:false;
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int sex = rs.getInt(columnIndex);
		return sex==1 ? true:false;
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int sex = cs.getInt(columnIndex);
		return sex==1 ? true:false;
	}

	

}
