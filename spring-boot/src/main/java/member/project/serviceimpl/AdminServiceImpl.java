package member.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.project.entity.Admin;
import member.project.repository.AdminRepository;
import member.project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin findByEmailAddressAndPassword(String emailAddress, String password) {
		return this.adminRepository.findByEmailAddressAndPassword(emailAddress, password);
	}

}
