package com.mdb.datasrc.common.repo;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mdb.datasrc.common.dto.ItemAvailableSummaryDTO;
import com.mdb.datasrc.common.dto.ItemOnHandDTO;
import com.mdb.datasrc.common.dto.ItemReservationsDTO;
import com.mdb.datasrc.common.dto.ItemResponseDTO;
import com.mdb.datasrc.common.dto.ItemSearchRegionsResDTO;
import com.mdb.datasrc.common.dto.ItemUOMDTO;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

@Repository
public class CommonRepo {
	@Autowired
	@Qualifier("primaryEntityManagerFactory")
	EntityManager primaryEm;
	
	@Autowired
	@Qualifier("secondaryEntityManagerFactory")
	EntityManager secondaryEm;
	protected static final String ITEM_REGIONS = "call XXSP_ITEM_SEARCH_SCREEN_PKG.get_regions(?)";
	private final static String GET_ITEM_DETAILS = "call XXSP_INV_SUPPLYDEMAND_PKG. get_item_details(?,?,?,?,?)";
	private final static String GET_TOTAL_SUMMARY = "call XXSP_UTIL_PKG.get_item_quantity_summary(?,?,?,?,?,?)";

	public ItemSearchRegionsResDTO getRegions() {
		Session s = this.primaryEm.unwrap(Session.class);
		return s.doReturningWork((con) -> {
			
			ItemSearchRegionsResDTO result = new ItemSearchRegionsResDTO();
			List<String> regions = new ArrayList<>();
			
			DatabaseMetaData dmd = con.getMetaData();
			OracleConnection conn = dmd.getConnection().unwrap(OracleConnection.class);
			try (CallableStatement stmt = conn.prepareCall(ITEM_REGIONS)) {
				stmt.setFetchSize(500);
				stmt.registerOutParameter(1, OracleTypes.CURSOR);
				stmt.execute();
				ResultSet rs = ((OracleCallableStatement) stmt).getCursor(1);
				if (rs != null) {
					while (rs.next()) {
						regions.add(rs.getString(1));
					}
				}
				result.setRegions(regions);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return result;
		});
	}
	
	
	public ItemResponseDTO getItemDetails(BigDecimal divisionId, BigDecimal itemId, String db) {
		Session s = this.primaryEm.unwrap(Session.class);
		return s.doReturningWork((con) -> {
			ItemResponseDTO result =  new ItemResponseDTO();
			DatabaseMetaData dmd = con.getMetaData();
			OracleConnection conn = dmd.getConnection().unwrap(OracleConnection.class);
			try (CallableStatement stmt = conn.prepareCall(GET_ITEM_DETAILS)) {
				stmt.setFetchSize(3000);
//				stmt.setBigDecimal(1, SpUtil.getLoggedInUserId());
				stmt.setBigDecimal(1, divisionId);
				stmt.setBigDecimal(2, itemId);
				stmt.registerOutParameter(3, OracleTypes.CURSOR);
				stmt.registerOutParameter(4, OracleTypes.CURSOR);
				stmt.registerOutParameter(5, OracleTypes.CURSOR);

				stmt.execute();
				ResultSet rsuom = ((OracleCallableStatement) stmt).getCursor(3);
				ResultSet rsoh = ((OracleCallableStatement) stmt).getCursor(4);
				ResultSet rsres = ((OracleCallableStatement) stmt).getCursor(5);
				
				List<ItemUOMDTO> uoms = new ArrayList<ItemUOMDTO>();
				List<ItemOnHandDTO> ohs = new ArrayList<ItemOnHandDTO>();
				List<ItemReservationsDTO> res = new ArrayList<ItemReservationsDTO>();

				if (rsuom != null) {
					while (rsuom.next()) {
						ItemUOMDTO order = new ItemUOMDTO();
						order.setPrimaryUomCode(rsuom.getString(1));
						order.setFromQty(rsuom.getString(2));
						order.setUom(rsuom.getString(3));
						order.setToQty(rsuom.getString(4));
//						order.setConvRate(rsuom.getBigDecimal(3));
						uoms.add(order);
					}
				}
				result.setItemUOM(uoms);
				
				if (rsoh != null) {
					while (rsoh.next()) {
						ItemOnHandDTO order = new ItemOnHandDTO();
						order.setSubInventory(rsoh.getString(1));
						order.setLocator(rsoh.getString(2));
						order.setOnHandQty(rsoh.getBigDecimal(3));
						order.setReservedQty(rsoh.getBigDecimal(4));
						order.setAvailableQty(rsoh.getBigDecimal(5));
						order.setOnReceiptQty(rsoh.getBigDecimal(6));
						order.setOnDemandQty(rsoh.getBigDecimal(7));
						order.setOnKitQty(rsoh.getBigDecimal(8));
						order.setKitReceipt(rsoh.getBigDecimal(9));
						ohs.add(order);
					}
				}
				result.setItemOnHand(ohs);
				
				if (rsres != null) {
					while (rsres.next()) {
						ItemReservationsDTO order = new ItemReservationsDTO();
						order.setRequiredDate(rsres.getDate(1));
						order.setSupplyDemandType(rsres.getString(2));
						order.setSubInventoryCode(rsres.getString(3));
						order.setLocator(rsres.getString(4));
						order.setIdentifier(rsres.getString(5));
						order.setDemandQty(rsres.getBigDecimal(6));
						order.setSupplyQty(rsres.getBigDecimal(7));
						order.setUom(rsres.getString(8));
						order.setLineNumber(rsres.getBigDecimal(9));
						order.setRequestDate(rsres.getDate(10));
						order.setCustomerName(rsres.getString(11));
						order.setAvailableQty(rsres.getBigDecimal(12));
						order.setReservedQty(rsres.getBigDecimal(13));
						order.setLotNumber(rsres.getString(14));
						order.setReservationType(rsres.getBigDecimal(15));
						order.setLineId(rsres.getBigDecimal(16));
						res.add(order);
					}
				}
				result.setItemReservations(res);
				ItemAvailableSummaryDTO totalData = this.getTotalSummary(divisionId, itemId, db);
				result.setItemTotalSummary(totalData);
				
			} catch (SQLException e) {
				// conn.rollback();
				e.printStackTrace();
				throw e;
			}
			return result;
		});
	}
	
	public ItemAvailableSummaryDTO getTotalSummary(BigDecimal divisionId, BigDecimal itemNumber, String db) {
		EntityManager em = this.primaryEm;
		if (db != null && db.equalsIgnoreCase("S")) {
			em = this.secondaryEm;
			System.out.println("Call is from Secondary em");
		}
		Session s = em.unwrap(Session.class);
		return s.doReturningWork((con) -> {
			ItemAvailableSummaryDTO result =  new ItemAvailableSummaryDTO();
			DatabaseMetaData dmd = con.getMetaData();
			OracleConnection conn = dmd.getConnection().unwrap(OracleConnection.class);
			try (CallableStatement stmt = conn.prepareCall(GET_TOTAL_SUMMARY)) {
				stmt.setFetchSize(3000);
				stmt.setBigDecimal(1, divisionId);
				stmt.setBigDecimal(2, itemNumber);
				stmt.registerOutParameter(3, OracleTypes.NUMBER);
				stmt.registerOutParameter(4, OracleTypes.NUMBER);
				stmt.registerOutParameter(5, OracleTypes.NUMBER);
				stmt.registerOutParameter(6, OracleTypes.NUMBER);
				stmt.execute();
				result.setTotalOnhand(((OracleCallableStatement) stmt).getBigDecimal(3));
				result.setTotalDemand(((OracleCallableStatement) stmt).getBigDecimal(4));
				result.setTotalSupply(((OracleCallableStatement) stmt).getBigDecimal(5));
				result.setSummary(((OracleCallableStatement) stmt).getBigDecimal(6));				
				
			} catch (SQLException e) {
				// conn.rollback();
				e.printStackTrace();
				throw e;
			}
			return result;
		});
	}
}
