import java.util.List;

import io.ionisstm.bo.Track;
import io.ionisstm.dao.TrackDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class TrackDAOTest
{

  private TrackDAO trackDAO;

  @BeforeEach
  public void setup()
  {
    trackDAO = new TrackDAO();
  }

  @Test
  public void getAllByPlaylistIdTest()
  {
    final List<Track> tracks = trackDAO.getAllByPlaylistId(1);

    Assertions.assertEquals(3290, tracks.size());

    final Track firstTrack = tracks.get(0);
    Assertions.assertEquals("For Those About To Rock (We Salute You)", firstTrack.title);
    Assertions.assertEquals("For Those About To Rock (We Salute You)", firstTrack.toString());
  }

}
