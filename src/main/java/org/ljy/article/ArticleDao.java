package org.ljy.article;

import java.util.List;

public interface ArticleDao {
	
	Article getArticle(String articleId);
	
	
	void insert(Article article);

	
	void update(Article article);


	List<Article> selectAll(int offset, int count);
	
	
	int countAll();

}
