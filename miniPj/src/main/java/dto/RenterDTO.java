package dto;

import java.util.Date;

public class RenterDTO {
	
	//대여
	String rentalId;
	String userId; // 빌린사람
	
	//대여자 리스트
	Date rentalDate;
	Date rentalStart;
	Date rentalEnd;
	int itemRentalPrice;
	
	

	//상품
	String itemId;
	String itemName;
	int itemPice;
	int itemQty;
	
	
	
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public Date getRentalStart() {
		return rentalStart;
	}
	public void setRentalStart(Date rentalStart) {
		this.rentalStart = rentalStart;
	}
	public Date getRentalEnd() {
		return rentalEnd;
	}
	public void setRentalEnd(Date rentalEnd) {
		this.rentalEnd = rentalEnd;
	}
	public int getItemRentalPrice() {
		return itemRentalPrice;
	}
	public void setItemRentalPrice(int itemRentalPrice) {
		this.itemRentalPrice = itemRentalPrice;
	}
	public String getRentalId() {
		return rentalId;
	}
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPice() {
		return itemPice;
	}
	public void setItemPice(int itemPice) {
		this.itemPice = itemPice;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
	
}
