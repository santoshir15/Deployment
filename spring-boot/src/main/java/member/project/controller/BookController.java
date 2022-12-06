package member.project.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import member.project.entity.BookDetail;
import member.project.exception.MemberProjectException;
import member.project.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/saveBook")
	public ResponseEntity<?> addBook(@ModelAttribute BookDetail bookDetail) throws MemberProjectException {
		bookDetail.setAddedDate(Date.valueOf(LocalDate.now()));
		bookService.save(bookDetail);
		return ResponseEntity.ok(Map.of("message", "Book was Successfully Added!", "title", "Post Successful"));
	}

	// Fetch All Books
	@GetMapping("/fetchAllBooks")
	private ResponseEntity<?> fetchAllBooks() throws MemberProjectException {
		return ResponseEntity.ok(bookService.fetchAllBooks());
	}

}
