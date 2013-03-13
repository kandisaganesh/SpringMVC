package com.ganesh.springmvc.inventory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.ganesh.springmvc.inventory.DVDDetails;
import com.ganesh.springmvc.inventory.DVDInfo;
import com.ganesh.springmvc.inventory.InvalidDvdIdException;
import com.ganesh.springmvc.inventory.InventoryManager;

@Component("inventoryManager")
public class InventoryManagerMock implements InventoryManager {

  @Inject
  Map<String, DVDDetails> catalog;

  public void addDvd(DVDDetails details) throws InvalidDvdIdException {
    String id = details.getId();
    if (catalog.containsKey(id))
      throw new InvalidDvdIdException(id + " is in use");
    catalog.put(id, details);
  }

  public DVDDetails getDetails(String dvdID) {
    System.out.println("dvdID:" + dvdID);
    for (Entry<String, DVDDetails> entry : catalog.entrySet()) {
      System.out.println("entry.getKey():" + entry.getKey());

    }
    return catalog.get(dvdID);
  }

  public Collection<DVDInfo> getAll() {
    Collection<DVDDetails> collection = catalog.values();
    Collection<String> keys = catalog.keySet();
    for (String key : keys) {
      System.out.println("key:" + key);
    }
    List<DVDInfo> result = new ArrayList<DVDInfo>(collection.size());
    for (DVDDetails details : collection) {
      result.add(new DVDInfo(details.getId(), details.getTitle()));
    }
    return result;
  }

  public Map<String, DVDDetails> getCatalog() {
    return catalog;
  }

  public void setCatalog(Map<String, DVDDetails> catalog) {
    this.catalog = catalog;
  }

}
