package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
public class ErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -130292785026387590L;
    private List<String> errors = new ArrayList<>();
}
