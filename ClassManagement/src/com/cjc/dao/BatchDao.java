package com.cjc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Batch;

public interface BatchDao {
	void insertBatch(ArrayList<Batch> batches) throws SQLException;

	HashMap<Integer, Batch> displayBatch() throws SQLException;

	void deleteBatch(Integer bid);

	HashMap<Integer, Batch> searchFacultyIdWise(Integer batch_id);
}
