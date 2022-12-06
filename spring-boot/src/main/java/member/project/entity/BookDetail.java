package member.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
	private String author;
	private Double rate;
	@Column(columnDefinition = " date ")
	private Date publishDates;
	@Column(columnDefinition = " longtext ")
	private String image;
	@Column(columnDefinition = " date ")
	private Date addedDate;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(targetEntity = PurchaseBook.class, mappedBy = "bookDetail")
	List<PurchaseBook> purchaseBookList;

	public BookDetail() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getPublishDates() {
		return publishDates;
	}

	public void setPublishDates(Date publishDates) {
		this.publishDates = publishDates;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public List<PurchaseBook> getPurchaseBookList() {
		return purchaseBookList;
	}

	public void setPurchaseBookList(List<PurchaseBook> purchaseBookList) {
		this.purchaseBookList = purchaseBookList;
	}

	public BookDetail(int bookId, String bookName, String author, Double rate, Date publishDates, String image,
			Date addedDate, List<PurchaseBook> purchaseBookList) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.rate = rate;
		this.publishDates = publishDates;
		this.image = image;
		this.addedDate = addedDate;
		this.purchaseBookList = purchaseBookList;
	}

	@Override
	public String toString() {
		return "BookDetail [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", rate=" + rate
				+ ", publishDates=" + publishDates + ", image=" + image + ", addedDate=" + addedDate
				+ ", purchaseBookList=" + purchaseBookList + "]";
	}

}
