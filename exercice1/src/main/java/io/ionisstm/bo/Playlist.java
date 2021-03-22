package io.ionisstm.bo;

import java.io.Serializable;

public final class Playlist
    implements Serializable
{

  public final int id;

  public final String name;

  public Playlist(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString()
  {
    return id + ". " + name;
  }

}