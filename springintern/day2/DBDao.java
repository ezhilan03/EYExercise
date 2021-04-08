package day2;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBDao {
	private DataSource dataSource;

	public final DataSource getDataSource() {
		return dataSource;
	}

	public final void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	JdbcTemplate jdbcTemplate;
	public void test() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		int n = jdbcTemplate.queryForInt("select count(*) from customer_details");
		System.out.println("No of rows... "+n);
	}
}
