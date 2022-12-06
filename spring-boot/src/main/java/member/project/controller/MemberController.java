package member.project.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import member.project.entity.Admin;
import member.project.entity.Member;
import member.project.exception.MemberProjectException;
import member.project.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/registerMember")
	public ResponseEntity<?> registerMember(@Valid  @ModelAttribute  Member member,BindingResult bindingResult)
			throws MemberProjectException {
		
		if (bindingResult.hasFieldErrors()) {
			StringBuffer error = new StringBuffer();
			bindingResult.getAllErrors().stream().forEach(f -> {
				error.append(f.getObjectName()).append(": ").append(f.getDefaultMessage());
			});
			throw new MemberProjectException(error.toString());
		}

		String memberId = memberService.generateMemeberId();
		member.setMemberId(memberId);
		member.setIsActivated('N');
		member.setRegistrationDate(Date.valueOf(LocalDate.now()));
		member.setActivationDate(Date.valueOf(LocalDate.now()));

		memberService.save(member);

		return ResponseEntity
				.ok(Map.of("message", "Member Register was Successful. Member: " + memberId, "title", "Post Success"));
	}
	
		
	

	// User login
	@PostMapping(value = "/loginMember")
	public ResponseEntity<Map<String, Object>> register(@RequestParam("username") String username,
			@RequestParam("password") String password) throws MemberProjectException {
		return memberService.findByEmailAddressAndPassword(username, password);
	}
	
	    

	// User login
	@PostMapping(value = "/activateMember")
	public ResponseEntity<?> activateMember(@RequestParam("memberid") String memberId) throws MemberProjectException {
		Member member = memberService.get(memberId);
		member.setIsActivated('Y');
		member.setActivationDate(Date.valueOf(LocalDate.now()));
		memberService.save(member);
		return ResponseEntity.ok(Map.of("message", "Member Activation was Successful.", "title", "Update Success"));
	}

}
