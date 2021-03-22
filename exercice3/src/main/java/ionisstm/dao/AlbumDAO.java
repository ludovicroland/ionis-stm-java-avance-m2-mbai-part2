package ionisstm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ionisstm.bo.Album;

public final class AlbumDAO
    extends DAO<Album>
{

  @Override
  public int insert(Album album)
  {
    try
    {
      final PreparedStatement albumStatement = connection.prepareStatement("INSERT INTO albums (Title, ArtistId) VALUES (?, ?)");
      albumStatement.setString(1, album.name);
      albumStatement.setInt(2, album.artist.id);
      albumStatement.executeUpdate();

      final ResultSet albumResultSet = albumStatement.getGeneratedKeys();

      if (albumResultSet.next() == true)
      {
        final int albumId = albumResultSet.getInt(1);

        albumResultSet.close();
        albumResultSet.close();

        return albumId;
      }
      else
      {
        albumStatement.close();
        return -1;
      }
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
      return -1;
    }
  }

}
