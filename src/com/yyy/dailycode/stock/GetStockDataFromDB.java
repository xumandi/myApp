package com.yyy.dailycode.stock;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.db.loadproperties.LoadProperties;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 * @类名： GetStockDataFromDB
 * @描述： 获取基础信息类
 * @作者： 杨文胜
 * @生成时间： 2015-12-21 下午04:42:27
 * @修改人：
 * @修改时间：
 **/
public class GetStockDataFromDB {
	private static final Logger logger = Logger.getLogger(LoadProperties.class);

	public static void main(String[] args) {
		new GetStockDataFromDB().getStockItems();
	}

	public List<StockItems> getStockItems() {
		List<StockItems> stockItemsList = new ArrayList<StockItems>();
		try {
			OracleUnit.getConnection();// 获得链接
			String sql = "select * from stock_items order by stock_code";
			ResultSet set = OracleUnit.query(sql);
			while (set.next()) {
				StockItems s = new StockItems();
				String stock_id = set.getString("stock_id");
				String stock_code = set.getString("stock_code");
				String stock_name = set.getString("stock_name");
				s.setStock_id(stock_id);
				s.setStock_code(stock_code);
				s.setStock_name(stock_name);
				stockItemsList.add(s);
			}
		} catch (Exception e) {
			logger.error("查询失败！", e);
		} finally {
			OracleUnit.closeConnection();
		}
		return stockItemsList;
	}
}
