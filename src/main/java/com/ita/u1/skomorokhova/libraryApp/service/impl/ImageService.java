package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Image;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import lombok.val;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
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

    @Override
    public Entity getById(long parseLong) {
        return null;
    }

    public List<Image> setImagesList(List<Part> parts) throws IOException {
        val images = new ArrayList<Image>();

        for (Part filePart : parts) {
            Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();

            byte[] bytes = IOUtils.toByteArray(fileContent);
            String encoded = Base64.encodeBase64String(bytes);
            images.add(Image.builder().imageString(encoded).build());

        }

        return images;
    }
}
