package com.mytests.spring.springboot14.springtesting.test3.forTests.repositories;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.FooEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class FooRepository {

	private static final FooEntityRowMapper ROW_MAPPER = new FooEntityRowMapper();

	private final JdbcTemplate jdbcTemplate;

	public FooRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void save(FooEntity entity) {
		this.jdbcTemplate.update("insert into sample (id, name) values (?, ?)",
				entity.getId(), entity.getName());
	}

	public FooEntity findById(int id) {
		return this.jdbcTemplate.queryForObject(
				"select id, name from sample where id =?", new Object[] { id },
				ROW_MAPPER);
	}

	public Collection<FooEntity> findAll() {
		return this.jdbcTemplate.query("select id, name from sample", ROW_MAPPER);
	}

	private static class FooEntityRowMapper implements RowMapper<FooEntity> {

		@Override
		public FooEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			return new FooEntity(id, name);
		}

	}

}