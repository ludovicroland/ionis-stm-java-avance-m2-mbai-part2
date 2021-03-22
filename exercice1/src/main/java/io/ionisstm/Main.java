package io.ionisstm;

import java.util.List;
import java.util.Scanner;

import io.ionisstm.bo.Playlist;
import io.ionisstm.bo.Track;
import io.ionisstm.dao.PlaylistDAO;
import io.ionisstm.dao.TrackDAO;

/**
 * @author Ludovic Roland
 * @since 2021.03.21
 */
final class Main
{

  public static void main(String[] args)
  {
    final List<Playlist> playlists = new PlaylistDAO().getAll();

    for (final Playlist playlist : playlists)
    {
      System.out.println(playlist);
    }

    final Scanner scanner = new Scanner(System.in);
    System.out.println("Saisir le numéro de la playlist à afficher :");
    final int playlistId = scanner.nextInt();

    final List<Track> tracks = new TrackDAO().getAllByPlaylistId(playlistId);

    for (final Track track : tracks)
    {
      System.out.println(track);
    }
  }

}
