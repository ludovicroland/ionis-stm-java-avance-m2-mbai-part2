package io.ionisstm.bo;

import java.io.Serializable;

public final class Track
    implements Serializable
{

  public final String title;

  public Track(String title)
  {
    this.title = title;
  }

  @Override
  public String toString()
  {
    return title;
  }

}
