package ionisstm.bo;

import java.io.Serializable;

public final class Artist
    implements Serializable
{

  public final String name;

  public int id;

  public Artist(String name)
  {
    this.name = name;
  }

  public Artist(int id, String name)
  {
    this(name);
    this.id = id;
  }

}
