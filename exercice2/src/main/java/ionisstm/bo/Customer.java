package ionisstm.bo;

import java.io.Serializable;

public final class Customer
    implements Serializable
{

  public final int id;

  public String firstname;

  public String lastname;

  public String phone;

  public String email;

  public Customer(int id, String firstname, String lastname, String phone, String email)
  {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.email = email;
  }

}
