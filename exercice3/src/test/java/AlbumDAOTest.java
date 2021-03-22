import ionisstm.bo.Album;
import ionisstm.bo.Artist;
import ionisstm.dao.AlbumDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class AlbumDAOTest
{

  private AlbumDAO albumDAO;

  @BeforeEach
  public void setup()
  {
    albumDAO = new AlbumDAO();
  }

  @Test
  public void insertTest()
  {
    final Artist artist = new Artist(1, "AC/DC");
    final Album album = new Album("Test!", artist);
    final int albumId = albumDAO.insert(album);

    Assertions.assertNotEquals(0, albumId);
  }

}
