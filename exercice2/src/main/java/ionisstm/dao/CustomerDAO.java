package ionisstm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ionisstm.bo.Customer;

public final class CustomerDAO
    extends DAO<Customer>
{

  @Override
  public Customer findById(int id)
  {
    try
    {
      final PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE CustomerId = ?");
      statement.setInt(1, id);

      final ResultSet resultSet = statement.executeQuery();

      if (resultSet.next() == true)
      {
        final int customerId = resultSet.getInt("CustomerId");
        final String firstName = resultSet.getString("FirstName");
        final String lastName = resultSet.getString("LastName");
        final String phone = resultSet.getString("Phone");
        final String email = resultSet.getString("Email");

        resultSet.close();
        statement.close();

        return new Customer(customerId, firstName, lastName, phone, email);
      }
      else
      {
        resultSet.close();
        statement.close();

        return null;
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(Customer customer)
  {
    try
    {
      final PreparedStatement updateStatement = connection.prepareStatement(
          "UPDATE customers " +
              "SET FirstName = ?," +
              "LastName = ?," +
              "Phone = ?," +
              "Email = ? " +
              "WHERE CustomerId = ?");

      updateStatement.setString(1, customer.firstname);
      updateStatement.setString(2, customer.lastname);
      updateStatement.setString(3, customer.phone);
      updateStatement.setString(4, customer.email);
      updateStatement.setInt(5, customer.id);

      updateStatement.executeUpdate();

      updateStatement.close();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

}
