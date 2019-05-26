package org.ljy.article;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ljy.book.chap11.Member;
import org.ljy.book.chap11.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ArticleController {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ArticleDao articleDao;

	Logger logger = LogManager.getLogger();
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	/**
	 * p.271 [리스트 11.5] handleStep1()
	 */
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	/**
	 * p.276 [리스트 11.8] handleStep2()
	 */
	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if (!agree) {// 동의하지 않으면 step1으로 돌아감
			logger.debug("약관에 동의하지 않았습니다.");
			return "register/step1";
		}
		// 동의하면 step2로 forward
		return "register/step2";
	}

	/**
	 * p.282 [리스트 11.11] handleStep3()
	 */
	@PostMapping("/register/step3")
	public String handleStep3(Member member) {
		try {
			memberDao.insert(member);
			logger.debug("회원 정보를 저장했습니다. {}", member);
			return "register/step3";
		} catch (DuplicateKeyException e) {
			logger.debug("이미 존재하는 이메일입니다. email = {}", member.getEmail());
			return "register/step2";
		}
	}

	@GetMapping("/members")
	public String members(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Member> memberList = memberDao.selectAll(offset, COUNT);

		int totalCount = memberDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("members", memberList);
		return "members";
	}

	/**
	 * 글 목록
	 */
	@GetMapping("/article/list")
	public void articleList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지당 행의 수와 페이지의 시작점
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);
		int totalCount = articleDao.countAll();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articleList", articleList);
	}

	/**
	 * 글 보기
	 */
	@GetMapping("/article/view")
	public void articleView(@RequestParam("articleId") String articleId,
			Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article", article);
	}

	/**
	 * 글 등록 화면
	 */
	@GetMapping("/article/addForm")
	public String articleAddForm(HttpSession session) {
		return "article/addForm";
	}

	/**
	 * 글 등록
	 */
	@PostMapping("/article/add")
	public String articleAdd(Article article,
			@SessionAttribute("MEMBER") Member member) {
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.insert(article);
		return "redirect:/app/article/list";
	}
	
	@GetMapping("/article/update")
	public String updateArticle(HttpSession session,
		@RequestParam("articleId") String articleId,
		
		Model model) {
	Article article = articleDao.getArticle(articleId);

	model.addAttribute("article", article);
		return "article/update";
	}

	
	@PostMapping("/article/clear")
	public String update(Article article, HttpSession session, Model model,
			@SessionAttribute("MEMBER") Member member) {
		articleDao.updateArticle(article);
		model.addAttribute("article", article);
		return "redirect:/app/article/list";
	}
	
	
	@GetMapping("/article/delete")
	public String deleteArticle(String articleId,
			@SessionAttribute("MEMBER") Member member) {
		articleDao.deleteArticle(articleId);
		return "article/delete";
	}
}