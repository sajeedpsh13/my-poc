package com.mdb.datasrc.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorOracleDatabaseImpl;


/**
 * To avoid numeric overflow error on app startup
 * https://stackoverflow.com/questions/58570032/hibernate-could-not-fetch-the-sequenceinformation-from-the-database
 * 
 * @author gpanda
 *
 */
public class AppSequenceInformationExtractor extends SequenceInformationExtractorOracleDatabaseImpl {
   
   public static final AppSequenceInformationExtractor INSTANCE = new AppSequenceInformationExtractor();
   
   @Override
   protected Long resultSetMinValue(ResultSet resultSet) throws SQLException {
      return resultSet.getBigDecimal("min_value").longValue();
   }
}