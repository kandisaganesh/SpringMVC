package com.ganesh.springmvc.controllers;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.springmvc.inventory.DVDDetails;
import com.ganesh.springmvc.inventory.InvalidDvdIdException;
import com.ganesh.springmvc.inventory.InventoryManager;

@Controller
@RequestMapping(value = "AddDVD.form")
public class AddDVDController {

  @Inject
  @Named("inventoryManager")
  private InventoryManager manager;

  @RequestMapping(method = RequestMethod.POST)
  protected ModelAndView onSubmit(@ModelAttribute("command") DVDDetails d) {

    try {
      manager.addDvd(d);
    } catch (InvalidDvdIdException e) {
      return new ModelAndView("AddDVD", "command", d);
    }

    return new ModelAndView("Detail", "dvd", d);

  }

  @RequestMapping(method = RequestMethod.GET)
  protected ModelAndView showForm() throws Exception {

    return new ModelAndView("AddDVD", "command", new DVDDetails());

  }

  public InventoryManager getManager() {
    return manager;
  }

  public void setManager(InventoryManager manager) {
    this.manager = manager;
  }

}
