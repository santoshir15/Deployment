package member.project.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import member.project.entity.Member;
import member.project.repository.MemberRepository;
import member.project.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void save(Member member) {
		memberRepository.save(member);		
	}
	
	@Override
	public String generateMemeberId() {
		Random rand = new Random();
		int num = ((rand.nextInt(9) + 1) * 100) + ((rand.nextInt(7) + 1) * 10) + (rand.nextInt(9) + 1)
				+ (rand.nextInt(9) + 1) + (rand.nextInt(9) + 1);
		return String.format("R-%s", num);
	}

	@Override
	public List<Member> fetchAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public ResponseEntity<Map<String, Object>> findByEmailAddressAndPassword(String emailAddress, String password) {
		Map<String, Object> map = new HashMap<>();
		Member member= memberRepository.findByEmailAddressAndPassword(emailAddress, password);
		if (member == null) {
			map.put("message", "Invalid Email Address or Password");
			map.put("title", "Login Error");
			return ResponseEntity.badRequest().body(map);
		} else if (member.getIsActivated().toString().equals("N")) {
			map.put("message", "Member Account Has not been Activated! Contact Admin.");
			map.put("title", "Account Error");
			return ResponseEntity.badRequest().body(map);
		} else {
			map.put("userid", member.getMemberId());
			map.put("fullname", member.getFirstName() + " " + member.getLastName());
			map.put("emailaddress", member.getEmailAddress());
			map.put("phone", member.getPhoneNumber());
			map.put("message", "Login Was Successful");
			map.put("title", "Login Successful");
			return ResponseEntity.ok(map);
		}
	}

	@Override
	public Member get(String memberId) {
		return memberRepository.getById(memberId);
	}

	
}
