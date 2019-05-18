package org.ljy.book.chap11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 인터페이스 MemberDao의 구현체. SpringJdbc를 사용해서 구현
 * 
 */
@Repository("memberDao")
public class MemberDaoImplUsingSpringJdbc implements MemberDao {

	static final String INSERT = "INSERT member(email, password, name) VALUES(?, sha2(?,256), ?)";

	static final String SELECT_ALL = "SELECT memberId, email, name, left(cdate,19) cdate FROM member ORDER BY memberId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(memberId) count FROM member";

	static final String SELECT_BY_LOGIN = "SELECT memberId, email, password, name FROM member WHERE (email,password) = (?,sha2(?,256))";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(
										Member.class);

	@Override
	public Member selectByEmail(String email) {
		// TODO selectByEmail() 메서드 구현
		return null;
	}

	/**
	 * p.201 [리스트 8.12]의 insert() 메서드 수정
	 */
	@Override
	public void insert(Member member) {
		jdbcTemplate.update(INSERT, member.getEmail(), member.getPassword(),
											member.getName());
	}

	@Override
	public void update(Member member) {
		// TODO update() 메서드 구현
	}

	/**
	 * p.195 [리스트 8.9] selectAll() 메서드 수정
	 */
	@Override
	public List<Member> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}
	
	/**
	 * 이메일과 비밀번호로 멤버 가져오기. 로그인 할 때 사용한다.
	 */
	public Member selectByLogin(String email, String password) {
		return jdbcTemplate.queryForObject(SELECT_BY_LOGIN, memberRowMapper,
				email, password);
	}
}