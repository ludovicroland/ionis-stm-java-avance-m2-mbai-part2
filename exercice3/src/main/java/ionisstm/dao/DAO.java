package ionisstm.dao;

import java.sql.Connection;

import ionisstm.db.ChinookConnection;

public abstract class DAO<T>
{

  protected final Connection connection = ChinookConnection.getInstance();

  public abstract int insert(T object);

}
