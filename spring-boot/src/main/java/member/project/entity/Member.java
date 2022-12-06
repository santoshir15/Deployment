package member.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Member {

	@Id
	@Column(columnDefinition = " varchar(5) ")
	private String memberId = "null";
	@NotNull
	@Column(columnDefinition = " varchar(55) ")
	private String firstName;
	@NotNull
	@Column(columnDefinition = " varchar(55) ")
	private String lastName;
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = " phone number should be 10 numbers")
	@Column(columnDefinition = " varchar(10) ")
	private String phoneNumber;
	@NotNull
	@Pattern(regexp = "^[A-Za-z]+@(.+)$")
	@Email(message = "email is required and must be valid mail id")
	@Column(columnDefinition = " varchar(85) ")
	private String emailAddress;
	@NotNull
	@Column(columnDefinition = " varchar(125)")
	private String password;
	@NotNull
	@Column(columnDefinition = " date ")
	private Date dateOfBirth;
	@Column(columnDefinition = " date ")
	private Date registrationDate;
	@Column(columnDefinition = " enum('N','Y') default 'N' ")
	private Character isActivated;
	@Column(columnDefinition = " date ")
	private Date activationDate;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(targetEntity = PurchaseBook.class, mappedBy = "member")
	private List<PurchaseBook> purchaseBookList;

	public Member() {
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Character getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Character isActivated) {
		this.isActivated = isActivated;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public List<PurchaseBook> getPurchaseBookList() {
		return purchaseBookList;
	}

	public void setPurchaseBookList(List<PurchaseBook> purchaseBookList) {
		this.purchaseBookList = purchaseBookList;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", registrationDate=" + registrationDate + ", isActivated=" + isActivated
				+ ", activationDate=" + activationDate + ", purchaseBookList=" + purchaseBookList + "]";
	}

	public Member(String memberId, String firstName, String lastName, String phoneNumber, String emailAddress,
			String password, Date dateOfBirth, Date registrationDate, Character isActivated, Date activationDate) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.isActivated = isActivated;
		this.activationDate = activationDate;
	}

}
