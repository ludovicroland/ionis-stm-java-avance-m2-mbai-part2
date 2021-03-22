import java.util.List;

import io.ionisstm.bo.Playlist;
import io.ionisstm.dao.PlaylistDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class PlaylistDAOTest
{

  private PlaylistDAO playlistDAO;

  @BeforeEach
  public void setup()
  {
    playlistDAO = new PlaylistDAO();
  }

  @Test
  public void getAllTest()
  {
    final List<Playlist> playlists = playlistDAO.getAll();

    Assertions.assertEquals(18, playlists.size());

    final Playlist playlistMusic = playlists.get(0);
    Assertions.assertEquals(1, playlistMusic.id);
    Assertions.assertEquals("Music", playlistMusic.name);
    Assertions.assertEquals("1. Music", playlistMusic.toString());
  }

}
