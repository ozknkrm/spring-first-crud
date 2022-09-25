package org.factoriaf5.democrud.payload.response;

import lombok.*;
import org.factoriaf5.democrud.model.Coder;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CoderResponse {
    private Coder coder;
    private Set<String> courses;
}
