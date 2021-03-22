package ionisstm;

import java.util.Scanner;

import ionisstm.bo.Customer;
import ionisstm.dao.CustomerDAO;

/**
 * @author Ludovic Roland
 * @since 2021.03.21
 */
final class Main
{

  public static void main(String[] args)
  {
    final CustomerDAO customerDAO = new CustomerDAO();
    final Scanner scanner = new Scanner(System.in);

    System.out.println("Saisir votre identifiant personnel :");
    final int customerId = scanner.nextInt();
    scanner.nextLine();

    final Customer customer = customerDAO.findById(customerId);

    if (customer != null)
    {
      System.out.println("Utilisateur trouvé");

      int userChoice = 0;

      do
      {
        System.out.println("Quelle information souhaitez-vous mettre à jour ?");
        System.out.println("1. Prénom");
        System.out.println("2. Nom");
        System.out.println("3. Téléphone");
        System.out.println("4. Email");

        userChoice = scanner.nextInt();
        scanner.nextLine();
      } while (userChoice < 1 || userChoice > 4);

      System.out.println("Saisir la nouvelle valeur :");
      final String newValue = scanner.nextLine();

      switch (userChoice)
      {
        case 1:
          customer.firstname = newValue;
          break;

        case 2:
          customer.lastname = newValue;
          break;

        case 3:
          customer.phone = newValue;
          break;

        case 4:
          customer.email = newValue;
          break;
      }

      customerDAO.update(customer);
    }
    else
    {
      System.out.println("Utilisateur non trouvé");
    }
  }

}
