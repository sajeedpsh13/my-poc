package com.mdb.datasrc.common.dto;

import java.util.List;

public class ItemResponseDTO {
	
	private List<ItemReservationsDTO> itemReservations;
	private List<ItemUOMDTO> itemUOM;
	private List<ItemOnHandDTO> itemOnHand;
	private ItemAvailableSummaryDTO itemTotalSummary;
	
	public List<ItemReservationsDTO> getItemReservations() {
		return itemReservations;
	}
	public void setItemReservations(List<ItemReservationsDTO> itemReservations) {
		this.itemReservations = itemReservations;
	}
	public List<ItemUOMDTO> getItemUOM() {
		return itemUOM;
	}
	public void setItemUOM(List<ItemUOMDTO> itemUOM) {
		this.itemUOM = itemUOM;
	}
	public List<ItemOnHandDTO> getItemOnHand() {
		return itemOnHand;
	}
	public void setItemOnHand(List<ItemOnHandDTO> itemOnHand) {
		this.itemOnHand = itemOnHand;
	}
	public ItemAvailableSummaryDTO getItemTotalSummary() {
		return itemTotalSummary;
	}
	public void setItemTotalSummary(ItemAvailableSummaryDTO itemTotalSummary) {
		this.itemTotalSummary = itemTotalSummary;
	}
	
		

}
