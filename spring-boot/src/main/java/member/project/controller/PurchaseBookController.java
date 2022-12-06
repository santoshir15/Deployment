package member.project.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import member.project.entity.BookDetail;
import member.project.entity.Member;
import member.project.entity.PurchaseBook;
import member.project.exception.MemberProjectException;
import member.project.service.BookService;
import member.project.service.MemberService;
import member.project.service.PurchaseBookService;

@RestController
public class PurchaseBookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private PurchaseBookService purchaseBookService;
	private String memberId;

	@PostMapping("/savePurchaseBook")
	public ResponseEntity<?> savePurchaseBook(@RequestParam("bookId") int bookId,
			@RequestParam("memberId") String memberId, @RequestParam("cardType") String c_type,
			@RequestParam("cardNumber") String c_no, @RequestParam("cardCVVNumber") String c_cvv)
			throws MemberProjectException {

		Member member = memberService.get(memberId);
		BookDetail book = bookService.get(bookId);

		PurchaseBook purchaseBook = new PurchaseBook();
		purchaseBook.setBookDetail(book);
		purchaseBook.setMember(member);
		purchaseBook.setCardType(c_type);
		purchaseBook.setCardNumber(c_no);
		purchaseBook.setCardCVV(c_cvv);
		purchaseBook.setRate(book.getRate());
		purchaseBook.setPurchasedDate(Date.valueOf(LocalDate.now()));
		purchaseBookService.save(purchaseBook);

		return ResponseEntity.ok(Map.of("message", "Book Purchase was Successful.", "title", "Post Successful"));
	}
	

	@GetMapping("/fetchMemberPurchaseBooks")
	public ResponseEntity<?> fetchPurchaseBook(@RequestParam("memberId") String id) throws MemberProjectException {
		return ResponseEntity.ok(purchaseBookService.fetchMemberPurchaseBooks(memberId));
	}
		
	
	   
   }

