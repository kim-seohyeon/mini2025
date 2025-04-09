package dto;

import java.util.Date;

public class WishDTO {

	private String userId;
	private String userId2;
	private String itemId;
	private String wishDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getWishDate() {
		return wishDate;
	}
	public void setWishDate(String wishDate) {
		this.wishDate = wishDate;
	}
	
}
