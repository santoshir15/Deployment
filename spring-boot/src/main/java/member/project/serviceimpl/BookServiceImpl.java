package member.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.project.entity.BookDetail;
import member.project.repository.BookRepository;
import member.project.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void save(BookDetail book) {
		this.bookRepository.save(book);
	}

	@Override
	public List<BookDetail> fetchAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public BookDetail get(int bookId) {
		return bookRepository.getById(bookId);
	}

	@Override
	public String getAllPurchasedBooks(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
