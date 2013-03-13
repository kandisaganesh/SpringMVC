package com.ganesh.springmvc.controllers;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.springmvc.inventory.DVDDetails;
import com.ganesh.springmvc.inventory.DVDInfo;
import com.ganesh.springmvc.inventory.InventoryManager;

@Controller
public class ViewDVDController {

  public ViewDVDController() {
    System.out.println("In ViewDVDController");
  }

  @Inject
  @Named("inventoryManager")
  private InventoryManager manager;

  @RequestMapping(value = "viewAll.view", method = RequestMethod.GET)
  public ModelAndView viewAll() throws Exception {
    Collection<DVDInfo> all = manager.getAll();
    return new ModelAndView("ListAll", "catalog", all);
  }

  @RequestMapping(value = "details.view")
  public ModelAndView details(@RequestParam(value = "dvdID", defaultValue = "1") String dvdID) {
    System.out.println("dvdID:" + dvdID);
    DVDDetails details = manager.getDetails(dvdID);
    System.out.println("details:" + details);
    System.out.println(details.getId());
    return new ModelAndView("Detail", "dvd", details);
  }

  public InventoryManager getManager() {
    return manager;
  }

  public void setManager(InventoryManager manager) {
    this.manager = manager;
  }

}
