package org.ljy.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LetterDao {
	
	static final String INSERT = "INSERT letter(title, content, senderId, senderName, receiverId, receiverName) values(?,?,?,?,?,?)";

	static final String SELECT_SEND_ALL = "SELECT letterId, title, receiverId, receiverName, cdate where senderId=?";
	
	static final String SELECT_RECEIVER_ALL = "SELECT letterId, title, senderId, senderName, cdate from letter where receiverId=?";

	static final String GET_LETTER = "SELECT letterId, title, content, senderId, senderName, receiverId, receiverName, cdate from letter where letterId=? and senderId=? or receiverId=?";

	static final String DELETE_LETTER = "delete from letter where letterId=? and senderId=? or receiverId =?";
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Letter> letterRowMapper = new BeanPropertyRowMapper<>(Letter.class);

	/**
	 * 글 등록
	 */
	public int addLetter(Letter letter) {
		return jdbcTemplate.update(INSERT, letter.getTitle(),
				letter.getContent(), letter.getSenderId(),letter.getSenderName(),
				letter.getReceiverId(), letter.getReceiverName());
	}
	
	/**
	 * 글 조회
	 */
	public Letter getLetter(String letterId) {
		return jdbcTemplate.queryForObject(GET_LETTER, letterRowMapper,
				letterId);
	}
	
	/**
	 * 보낸목록 조회
	 */
	public Letter sendLetter(String senderId) {
		return jdbcTemplate.queryForObject(SELECT_SEND_ALL, letterRowMapper,
				senderId);
	}

	
	/**
	 * 받은목록 조회
	 */
	public Letter receiveLetter(String receiverId) {
		return jdbcTemplate.queryForObject(SELECT_RECEIVER_ALL, letterRowMapper,
				receiverId);
	}

	/**
	 * 글 삭제
	 */
	public int deleteLetter(String letterId, String senderId, String receiverId) {
		return jdbcTemplate.update(DELETE_LETTER, letterId, senderId,receiverId);
	}

}