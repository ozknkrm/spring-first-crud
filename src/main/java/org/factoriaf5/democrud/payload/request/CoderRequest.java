package org.factoriaf5.democrud.payload.request;

import lombok.Getter;
import lombok.Setter;

//DTO transportar datos de un sitio a otro
@Getter
@Setter
public class CoderRequest {
    private Long id;
    private String name;
    private String email;
    private int age;
}
