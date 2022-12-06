package member.project.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseBookId;
	@JsonIgnore
	@JoinColumn(name = "member_id", referencedColumnName = "memberId")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Member.class)
	private Member member;
	@JsonIgnore
	@JoinColumn(name = "book_details_id", referencedColumnName = "bookId")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BookDetail.class)
	private BookDetail bookDetail;
	private Double rate;
	@Column(columnDefinition = " date ")
	private Date purchasedDate;
	private String cardType;
	private String cardNumber;
	private String cardCVV;

	public int getPurchaseBookId() {
		return purchaseBookId;
	}

	public void setPurchaseBookId(int purchaseBookId) {
		this.purchaseBookId = purchaseBookId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}

	public PurchaseBook(int purchaseBookId, Member member, BookDetail bookDetail, Double rate, Date purchasedDate,
			String cardType, String cardNumber, String cardCVV) {
		super();
		this.purchaseBookId = purchaseBookId;
		this.member = member;
		this.bookDetail = bookDetail;
		this.rate = rate;
		this.purchasedDate = purchasedDate;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardCVV = cardCVV;
	}

	@Override
	public String toString() {
		return "PurchaseBook [purchaseBookId=" + purchaseBookId + ", member=" + member + ", bookDetail=" + bookDetail
				+ ", rate=" + rate + ", purchasedDate=" + purchasedDate + ", cardType=" + cardType + ", cardNumber="
				+ cardNumber + ", cardCVV=" + cardCVV + "]";
	}

	public PurchaseBook() {
		// TODO Auto-generated constructor stub
	}

}
