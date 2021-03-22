import ionisstm.bo.Customer;
import ionisstm.dao.CustomerDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomerDAOTest
{

  private CustomerDAO customerDAO;

  @BeforeEach
  public void setup()
  {
    customerDAO = new CustomerDAO();
  }

  @AfterEach
  public void after()
  {
    //On restaure les valeurs par défaut de l'utilisateur
    //Sinon les tests ne peuvent pas se produire 2 fois de suite
    final Customer customer = new Customer(8, "Daan", "Peeters", "+32 02 219 03 03", "daan_peeters@apple.be");
    customerDAO.update(customer);
  }

  @Test
  public void findByIdTest()
  {
    //8
    //Daan
    //Peeters
    // +32 02 219 03 03
    // daan_peeters@apple.be
    final Customer customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Daan", customer.firstname);
    Assertions.assertEquals("Peeters", customer.lastname);
    Assertions.assertEquals("+32 02 219 03 03", customer.phone);
    Assertions.assertEquals("daan_peeters@apple.be", customer.email);
    Assertions.assertEquals(8, customer.id);

    final Customer customer2 = customerDAO.findById(480000);

    Assertions.assertNull(customer2);
  }

  @Test
  public void updateTest()
  {
    Customer customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Daan", customer.firstname);
    Assertions.assertEquals("Peeters", customer.lastname);
    Assertions.assertEquals("+32 02 219 03 03", customer.phone);
    Assertions.assertEquals("daan_peeters@apple.be", customer.email);
    Assertions.assertEquals(8, customer.id);

    //On met à jour le prenom et on vérifie la MAJ
    customer.firstname = "Ludovic";
    customerDAO.update(customer);

    customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Ludovic", customer.firstname);
    Assertions.assertEquals("Peeters", customer.lastname);
    Assertions.assertEquals("+32 02 219 03 03", customer.phone);
    Assertions.assertEquals("daan_peeters@apple.be", customer.email);
    Assertions.assertEquals(8, customer.id);

    //On met à jour le nom et on vérifie la MAJ
    customer.lastname = "ROLAND";
    customerDAO.update(customer);

    customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Ludovic", customer.firstname);
    Assertions.assertEquals("ROLAND", customer.lastname);
    Assertions.assertEquals("+32 02 219 03 03", customer.phone);
    Assertions.assertEquals("daan_peeters@apple.be", customer.email);
    Assertions.assertEquals(8, customer.id);

    //On met à jour le téléphone et on vérifie la MAJ
    customer.phone = "+33 06 02 04 48 12";
    customerDAO.update(customer);

    customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Ludovic", customer.firstname);
    Assertions.assertEquals("ROLAND", customer.lastname);
    Assertions.assertEquals("+33 06 02 04 48 12", customer.phone);
    Assertions.assertEquals("daan_peeters@apple.be", customer.email);
    Assertions.assertEquals(8, customer.id);

    //On met à jour le mail et on vérifie la MAJ
    customer.email = "contact@rolandl.fr";
    customerDAO.update(customer);

    customer = customerDAO.findById(8);

    Assertions.assertNotNull(customer);
    Assertions.assertEquals(8, customer.id);
    Assertions.assertEquals("Ludovic", customer.firstname);
    Assertions.assertEquals("ROLAND", customer.lastname);
    Assertions.assertEquals("+33 06 02 04 48 12", customer.phone);
    Assertions.assertEquals("contact@rolandl.fr", customer.email);
    Assertions.assertEquals(8, customer.id);
  }

}
