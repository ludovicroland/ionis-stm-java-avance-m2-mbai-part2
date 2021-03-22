package io.ionisstm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.ionisstm.bo.Track;

public final class TrackDAO
    extends DAO<Track>
{

  public List<Track> getAllByPlaylistId(int playlistId)
  {
    final List<Track> tracks = new ArrayList<>();

    try
    {
      final PreparedStatement statement = connection.prepareStatement(
          "SELECT tracks.Name as Name " +
              "FROM tracks " +
              "INNER JOIN playlist_track ON tracks.TrackId = playlist_track.TrackId " +
              "WHERE playlist_track.PlaylistId = ? ");

      statement.setInt(1, playlistId);

      final ResultSet resultSet = statement.executeQuery();

      while (resultSet.next() == true)
      {
        final String name = resultSet.getString("Name");

        tracks.add(new Track(name));
      }

      resultSet.close();
      statement.close();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }

    return tracks;
  }

}
