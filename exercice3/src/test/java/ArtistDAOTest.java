import ionisstm.bo.Artist;
import ionisstm.dao.ArtistDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class ArtistDAOTest
{

  private ArtistDAO artistDAO;

  @BeforeEach
  public void setup()
  {
    artistDAO = new ArtistDAO();
  }

  @Test
  public void insertTest()
  {
    final Artist artist = new Artist("Naamah");
    final int artistId = artistDAO.insert(artist);
    Assertions.assertNotEquals(0, artistId);

  }

}
