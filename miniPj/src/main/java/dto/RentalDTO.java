package dto;

public class RentalDTO {

	int itemsTotalPrice;
	String rentalId;
	String userId;
	
	public int getItemsTotalPrice() {
		return itemsTotalPrice;
	}
	public void setItemsTotalPrice(int itemsTotalPrice) {
		this.itemsTotalPrice = itemsTotalPrice;
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
	
}
