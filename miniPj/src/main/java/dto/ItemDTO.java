package dto;

import java.util.Date;

public class ItemDTO {

	private String itemId;
	private String userId;
	private String itemName;
	private String itemContents;
	private int itemPrice;
	private Date itemRegist;
	private String itemMainImage;
	private String itemMainStoreImage;
	private String itemDetailImage;
	private String itemDetailStoreImage;
	private Date itemUpdateDate;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public String getItemContents() {
		return itemContents;
	}
	public void setItemContents(String itemContents) {
		this.itemContents = itemContents;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Date getItemRegist() {
		return itemRegist;
	}
	public void setItemRegist(Date itemRegist) {
		this.itemRegist = itemRegist;
	}
	public String getItemMainImage() {
		return itemMainImage;
	}
	public void setItemMainImage(String itemMainImage) {
		this.itemMainImage = itemMainImage;
	}
	public String getItemMainStoreImage() {
		return itemMainStoreImage;
	}
	public void setItemMainStoreImage(String itemMainStoreImage) {
		this.itemMainStoreImage = itemMainStoreImage;
	}
	public String getItemDetailImage() {
		return itemDetailImage;
	}
	public void setItemDetailImage(String itemDetailImage) {
		this.itemDetailImage = itemDetailImage;
	}
	public String getItemDetailStoreImage() {
		return itemDetailStoreImage;
	}
	public void setItemDetailStoreImage(String itemDetailStoreImage) {
		this.itemDetailStoreImage = itemDetailStoreImage;
	}
	public Date getItemUpdateDate() {
		return itemUpdateDate;
	}
	public void setItemUpdateDate(Date itemUpdateDate) {
		this.itemUpdateDate = itemUpdateDate;
	}
	
}
