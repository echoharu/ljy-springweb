package org.ljy.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	static final String INSERT = "INSERT article(title, content, userId, name) VALUES(?,?,'2015041078','이중연')";

	static final String SELECT_ALL = "SELECT articleId, title, content, userId, name, left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";
	
	static final String GET_ARTICLE = "SELECT articleId, title, content, userId, name, cdate FROM article WHERE articleId=?";
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(
										Article.class);

	

	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, 
				new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	@Override
	public void insert(Article article) {
		jdbcTemplate.update(INSERT, article.getTitle(), article.getContent());
		
	}

	@Override
	public void update(Article article) {
		// TODO update() 메서드 구현
	}
	
	@Override
	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

}