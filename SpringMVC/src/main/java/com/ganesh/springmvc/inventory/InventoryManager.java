package com.ganesh.springmvc.inventory;

import java.util.Collection;

public interface InventoryManager {

  public void addDvd(DVDDetails details) throws InvalidDvdIdException;

  public DVDDetails getDetails(String dvdID);

  public Collection<DVDInfo> getAll();
}
