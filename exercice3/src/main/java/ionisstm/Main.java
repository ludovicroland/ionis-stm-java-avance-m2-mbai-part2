package ionisstm;

import java.util.Scanner;

import ionisstm.bo.Album;
import ionisstm.bo.Artist;
import ionisstm.dao.AlbumDAO;
import ionisstm.dao.ArtistDAO;

/**
 * @author Ludovic Roland
 * @since 2021.03.21
 */
final class Main
{

  public static void main(String[] args)
  {
    final Scanner scanner = new Scanner(System.in);

    System.out.println("Saisir le nom de l'artiste à ajouter :");
    final String artistName = scanner.nextLine();

    System.out.println("Ajout de l'artist : " + artistName);
    final Artist artist = new Artist(artistName);
    final int artistId = new ArtistDAO().insert(artist);

    if (artistId != -1)
    {
      System.out.println("Artist correctement ajouté");
      artist.id = artistId;

      System.out.println("Saisir le nom de l'album à ajouter :");
      final String albumName = scanner.nextLine();

      System.out.println("Ajout de l'album : " + albumName);
      final Album album = new Album(albumName, artist);

      final int albumId = new AlbumDAO().insert(album);

      if (albumId != -1)
      {
        System.out.println("Album correctement ajouté");
      }
      else
      {
        System.out.println("Une erreur est survenue pendant l'ajout de l'album");
      }
    }
    else
    {
      System.out.println("Une erreur est survenue pendant l'ajout de l'artiste");
    }
  }

}
