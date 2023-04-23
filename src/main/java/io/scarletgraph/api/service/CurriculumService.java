package io.scarletgraph.api.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.scarletgraph.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Service
public class CurriculumService {

    @Autowired
    private TemplateEngine templateEngine;

    public ByteArrayInputStream generatePdf(User userData) throws DocumentException, IOException {
        Context context = new Context();
        context.setVariables(UserDatatoMap(userData));

        String html = templateEngine.process("curriculum", context);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        renderer.createPDF(out);

        return new ByteArrayInputStream(out.toByteArray());
    }


    public Map<String, Object> UserDatatoMap(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", user.getEmail());
        map.put("firstName", user.getFirstName());
        map.put("lastName", user.getLastName());
        map.put("cellphone", user.getCellphone());
        map.put("description",user.getProfile().getDescription());
        map.put("location", user.getProfile().getLocation());
        map.put("previousExperiences", user.getProfile().getPreviousXP());
        return map;
    }
}

