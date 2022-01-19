package com.ita.u1.skomorokhova.libraryApp.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RequestService {
    public List<Part> getFileParts(HttpServletRequest request, String partName) throws IOException, ServletException {
        return request.getParts().stream()
                .filter(part -> partName.equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
    }
}
