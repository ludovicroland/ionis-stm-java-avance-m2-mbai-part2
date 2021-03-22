package io.ionisstm.dao;

import java.sql.Connection;

import io.ionisstm.db.ChinookConnection;

public abstract class DAO<T>
{

  protected final Connection connection = ChinookConnection.getInstance();

}
