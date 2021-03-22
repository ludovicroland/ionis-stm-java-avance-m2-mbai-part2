package ionisstm.dao;

import java.sql.Connection;

import ionisstm.db.ChinookConnection;

public abstract class DAO<T>
{

  protected final Connection connection = ChinookConnection.getInstance();

  public abstract T findById(int id);

  public abstract void update(T object);

}
