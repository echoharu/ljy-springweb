package org.ljy.article;

public class Article {


	String articleId;
	String title;
	String content;
	String userId;
	String name;
	String cdate;
	
	public Article() {
	}
	
	/**
	 * title, content 으로 초기화하는 컨스트럭터
	 * 
	 * @param title    제목
	 * @param content  내용 
	 */
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	public String getContentHtml() {
		if (content != null)
			return content.replace("\n", "<br/>");
		return null;
}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title
				+ ", content=" + content + ", userId=" + userId + ", name="
				+ name + ", cdate=" + cdate + "]";
	}
}
