package com.negocio.ReservasYCitas.Service.Controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response<T> {
    T data;
    String error;


}
