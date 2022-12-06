package member.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import member.project.entity.Member;

public interface MemberService {

	void save(Member member);
	
	String generateMemeberId();

	List<Member> fetchAllMember();

	ResponseEntity<Map<String, Object>> findByEmailAddressAndPassword(String emailAddress, String password);

	Member get(String memberId);

	
}
