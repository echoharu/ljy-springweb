package org.ljy.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	static final String INSERT = "INSERT article(title, content, userId, name) VALUES(?,?,?,?)";

	static final String SELECT_ALL = "SELECT articleId, title, content, userId, name, left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";

	static final String GET_ARTICLE = "SELECT articleId, title, content, userId, name, cdate FROM article WHERE articleId=?";

	static final String UPDATE_ARTICLE = "update article set title=?, content=? where (articleId, userId) = (?,?)";

	static final String DELETE_ARTICLE = "delete from article where (articleId, userId) = (?,?)";
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);

	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	@Override
	public void insert(Article article) {
		jdbcTemplate.update(INSERT, article.getTitle(), article.getContent(), article.getUserId(), article.getName());

	}

	@Override
	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

	/**
	 * 글 수정
	 */
	public int updateArticle(Article article) {
		return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(), article.getContent(), article.getArticleId(),
				article.getUserId());
	}

	/**
	 * 글 삭제
	 */
	public int deleteArticle(String articleId, String userId) {
		return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
	}

}