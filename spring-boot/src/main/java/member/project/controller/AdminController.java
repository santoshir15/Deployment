package member.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import member.project.entity.Admin;
import member.project.exception.MemberProjectException;
import member.project.service.AdminService;
import member.project.service.MemberService;
import member.project.service.PurchaseBookService;

@RestController
public class AdminController {

	@Autowired
    private AdminService adminService;
	
	@Autowired
    private MemberService memberService;
	
	@Autowired
    private PurchaseBookService purchaseBookService;
	
	@PostMapping(value = "/loginAdmin")
    public ResponseEntity<Map<String, Object>> loginEvent(@RequestParam("username") String username,
                                                          @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>();
        Admin details = adminService.findByEmailAddressAndPassword(username, password);
        if (details != null) {
            map.put("userid", details.getAdminId());
            map.put("fullname", details.getFirstName() + " " + details.getLastName());
            map.put("emailaddress", details.getEmailAddress());
            map.put("message", "Login Was Successful");
            map.put("title", "Login Successful");
            return ResponseEntity.ok(map);
        } else {
            map.put("message", "Invalid Email Address or Password");
            map.put("title", "Login Error");
            return ResponseEntity.badRequest().body(map);
        }
    }


    // Fetch All Member
    @GetMapping("/fetchAllMembers")
    private ResponseEntity<?> fetchMembers() {
        return ResponseEntity.ok(memberService.fetchAllMember());
    }

    
    // Fetch All purchase! 
    @GetMapping("/fetchAllPurchaseBooks")
    public ResponseEntity<?> fetchPurchaseBook() throws MemberProjectException {
        return ResponseEntity.ok(purchaseBookService.fetchAllPurchases());
    }

}
  