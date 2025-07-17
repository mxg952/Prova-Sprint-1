package com.itAcademy.exceptions;

public class NotFoundProductException extends RuntimeException {
  public NotFoundProductException(String message) {
    super(message);
  }
}
