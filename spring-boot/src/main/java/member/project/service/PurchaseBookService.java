package member.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import member.project.entity.PurchaseBook;

public interface PurchaseBookService {

	void save(PurchaseBook b);

	List<Map<String, Object>> fetchAllPurchases();

	List<Map<String, Object>> fetchMemberPurchaseBooks(@Param("memberId") String id);

}
