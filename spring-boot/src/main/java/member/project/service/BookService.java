package member.project.service;

import java.util.List;

import member.project.entity.BookDetail;

public interface BookService {

	void save(BookDetail book);
	
	List<BookDetail> fetchAllBooks();

	BookDetail get(int bookId);

	String getAllPurchasedBooks(String emailId);
	
}
