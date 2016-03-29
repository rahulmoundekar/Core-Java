package com.cjc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Batch;
import com.cjc.model.Faculty;

public interface BatchService {
	void addBatch(ArrayList<Batch> batchs) throws SQLException;

	HashMap<Integer, Batch> displayBatch() throws SQLException;

	void deleteBatch(Integer bid);

	HashMap<Integer, Batch> searchFacultyIdWise(Integer batch_id);

}
