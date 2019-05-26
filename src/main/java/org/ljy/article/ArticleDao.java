package org.ljy.article;

import java.util.List;

public interface ArticleDao {
	
	Article getArticle(String articleId);
	
	
	void insert(Article article);


	List<Article> selectAll(int offset, int count);
	
	
	int countAll();
	
	
	
	int deleteArticle(String articleId);


	int updateArticle(Article article);


}
