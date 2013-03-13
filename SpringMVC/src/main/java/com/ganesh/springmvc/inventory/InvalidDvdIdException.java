package com.ganesh.springmvc.inventory;

public class InvalidDvdIdException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidDvdIdException() {
  }

  public InvalidDvdIdException(String message) {
    super(message);
  }

  public InvalidDvdIdException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidDvdIdException(Throwable cause) {
    super(cause);
  }
}
