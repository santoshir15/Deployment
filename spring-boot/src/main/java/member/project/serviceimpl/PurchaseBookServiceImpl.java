package member.project.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.project.entity.PurchaseBook;
import member.project.repository.PurchaseBookRepository;
import member.project.service.PurchaseBookService;

@Service
public class PurchaseBookServiceImpl implements PurchaseBookService{

	@Autowired
	private PurchaseBookRepository repository;
	
	@Override
	public void save(PurchaseBook b) {
		repository.save(b);		
	}

	@Override
	public List<Map<String, Object>> fetchAllPurchases() {
		return repository.fetchAllPurchases().stream()
                .map(t -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("author", t.get("author"));
                    map.put("last_name", t.get("last_name"));
                    map.put("first_name", t.get("first_name"));
                    map.put("book_name", t.get("book_name"));
                    map.put("image", t.get("image"));
                    map.put("rate", t.get("rate"));
                    map.put("purchase_book_id", t.get("purchase_book_id"));
                    map.put("purchased_date", t.get("purchased_date"));
                    return map;
                }).collect(Collectors.toList());
		
	}

	@Override
	public List<Map<String, Object>> fetchMemberPurchaseBooks(String id) {
		return repository.fetchMemberPurchase(id).stream().map(t -> {
			Map<String, Object> map = new HashMap<>();
			map.put("author", t.get("author"));
			map.put("book_name", t.get("book_name"));
			map.put("image", t.get("image"));
			map.put("rate", t.get("rate"));
			map.put("purchase_book_id", t.get("purchase_book_id"));
			map.put("purchased_date", t.get("purchased_date"));
			return map;
		}).collect(Collectors.toList());
	}
	

}
