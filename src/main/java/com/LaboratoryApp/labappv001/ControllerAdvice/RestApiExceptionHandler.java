package com.LaboratoryApp.labappv001.ControllerAdvice;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Exception.ResearcherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(ResearcherNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String researcherNotFoundException (ResearcherNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(LaboratoryLogNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String laboratoryLogNotFoundException (LaboratoryLogNotFoundException e) {
        return e.getMessage();
    }
}
