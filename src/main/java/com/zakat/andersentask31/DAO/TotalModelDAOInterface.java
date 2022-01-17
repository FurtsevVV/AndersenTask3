package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.model.TotalInfoModel;

import java.sql.SQLException;

public interface TotalModelDAOInterface {

    void addTotalModelToDatabase(TotalInfoModel totalInfoModel) throws SQLException;

}
