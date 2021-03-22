package ionisstm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ionisstm.bo.Artist;

public final class ArtistDAO
    extends DAO<Artist>
{

  @Override
  public int insert(Artist artist)
  {
    try
    {
      final PreparedStatement artistStatement = connection.prepareStatement("INSERT INTO artists (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
      artistStatement.setString(1, artist.name);
      artistStatement.executeUpdate();

      final ResultSet artistResultSet = artistStatement.getGeneratedKeys();

      if (artistResultSet.next() == true)
      {
        final int artistId = artistResultSet.getInt(1);

        artistStatement.close();
        artistResultSet.close();

        return artistId;
      }
      else
      {
        artistStatement.close();
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
