package member.project.service;

import member.project.entity.Admin;

public interface AdminService {

	 Admin findByEmailAddressAndPassword(String emailAddress, String password);
}
