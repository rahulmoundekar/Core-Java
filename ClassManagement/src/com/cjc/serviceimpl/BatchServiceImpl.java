package com.cjc.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.BatchDao;
import com.cjc.daoimpl.BatchDaoImpl;
import com.cjc.model.Batch;
import com.cjc.service.BatchService;

public class BatchServiceImpl implements BatchService {

	BatchDao batchDao = new BatchDaoImpl();

	@Override
	public void addBatch(ArrayList<Batch> batchs) throws SQLException {
		batchDao.insertBatch(batchs);
	}

	@Override
	public HashMap<Integer, Batch> displayBatch() throws SQLException {
		return batchDao.displayBatch();
	}

	@Override
	public void deleteBatch(Integer bid) {
			batchDao.deleteBatch(bid);
	}

	@Override
	public HashMap<Integer, Batch> searchFacultyIdWise(Integer batch_id) {
		return batchDao.searchFacultyIdWise(batch_id);
	}

}
