package io.ionisstm.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.ionisstm.bo.Playlist;

public final class PlaylistDAO
    extends DAO<Playlist>
{

  public List<Playlist> getAll()
  {
    final List<Playlist> playlists = new ArrayList<>();

    try
    {
      final Statement playlistStatement = connection.createStatement();
      final ResultSet playlistResultSet = playlistStatement.executeQuery("SELECT * FROM playlists");

      while (playlistResultSet.next() == true)
      {
        final int playlistId = playlistResultSet.getInt("PlaylistId");
        final String name = playlistResultSet.getString("Name");

        playlists.add(new Playlist(playlistId, name));
      }

      playlistResultSet.close();
      playlistStatement.close();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }

    return playlists;
  }

}
