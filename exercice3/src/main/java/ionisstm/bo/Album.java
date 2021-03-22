package ionisstm.bo;

import java.io.Serializable;

public final class Album
    implements Serializable
{

  public final String name;

  public final Artist artist;

  public Album(String name, Artist artist)
  {
    this.name = name;
    this.artist = artist;
  }

}
