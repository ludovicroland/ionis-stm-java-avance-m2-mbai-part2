package io.ionisstm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ChinookConnection
{

  private Connection connection;

  private static volatile ChinookConnection instance;

  public static Connection getInstance()
  {
    if (instance == null)
    {
      synchronized (ChinookConnection.class)
      {
        if (instance == null)
        {
          instance = new ChinookConnection();
        }
      }
    }

    return instance.connection;
  }

  private ChinookConnection()
  {
    try
    {
      //WARNING : Change with "jdbc:sqlite:src/main/resources/chinook.db" for the tests
      connection =  DriverManager.getConnection("jdbc:sqlite:exercice1/src/main/resources/chinook.db");
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

}
