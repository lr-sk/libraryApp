package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import com.ita.u1.skomorokhova.libraryApp.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageService implements EntityService {

    @Override
    public List getAll() {
        return null;
    }

    public List<InputStream> setImagesList(HttpServletRequest request, String partName) throws IOException, ServletException {
        List<InputStream> images = new ArrayList<>();

        for (Part filePart : new RequestService().getFileParts(request, partName)) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            images.add(fileContent);
        }

        return images;
    }

}
