package com.xiaobao.common.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbctemplate;
}
