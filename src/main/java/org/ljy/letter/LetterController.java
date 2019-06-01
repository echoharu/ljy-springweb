package org.ljy.letter;

import java.util.List;

import org.ljy.book.chap11.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LetterController {
	

	@Autowired
	LetterDao letterDao;

	/**
	 * 받은 목록
	 */
	@GetMapping("/letter/listOfReceiver")
	public void listOfReceiver(@SessionAttribute("MEMBER") Member member,
			Model model) {
		List<Letter> letters = letterDao
				.listLettersOfReceiver(member.getMemberId());
		model.addAttribute("letters", letters);
	}

	/**
	 * 보낸 목록
	 */
	@GetMapping("/letter/listOfSender")
	public void listOfSender(@SessionAttribute("MEMBER") Member member,
			Model model) {
		List<Letter> letters = letterDao
				.listLettersOfSender(member.getMemberId());
		model.addAttribute("letters", letters);
	}

	/**
	 * 보기
	 */
	@GetMapping("/letter/view")
	public void view(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member, Model model) {
		Letter letter = letterDao.getLetter(letterId, member.getMemberId());
		model.addAttribute("letter", letter);
	}

	/**
	 * 편지 저장
	 */
	@PostMapping("/letter/add")
	public String add(Letter letter,
			@SessionAttribute("MEMBER") Member member) {
		letter.setSenderId(member.getMemberId());
		letter.setSenderName(member.getName());
		letterDao.addLetter(letter);
		return "redirect:/app/letter/listOfSender";
	}

	/**
	 * 편지 삭제
	 */
	@GetMapping("/letter/delete")
	public String delete(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member) {
		int updatedRows = letterDao.deleteLetter(letterId,
				member.getMemberId());
		if (updatedRows == 0)
			throw new RuntimeException("No Authority!");

		return "redirect:/보낸목록 또는 받은목록";
	}
}
