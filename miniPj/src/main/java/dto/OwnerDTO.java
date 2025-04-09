package dto;

import java.util.Date;

public class OwnerDTO {

	//상품
	String itemId;
	String userId; // 빌려준 사람
	String itemName;
	int itemQty;
	
	//대여자 리스트
	Date rentalDate;
	Date rentalStart;
	Date rentalEnd;
	int itemRentalPrice;
	
	// 대여
	String rentalId;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
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

}
