package com.digitalware.demodw.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum tipo_factura {

    TYPE1("Operacional"), TYPE2("No operacional"),TYPE3("Venta directa");

    private String tipo;

    private tipo_factura(String tipo) {
        this.tipo = tipo;
    }

    @JsonCreator
    public static tipo_factura decode(final String code) {
        return Stream.of(tipo_factura.values()).filter(targetEnum -> targetEnum.tipo.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return tipo;
    }
}
