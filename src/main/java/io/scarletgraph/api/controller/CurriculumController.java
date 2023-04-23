package io.scarletgraph.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.curriculumDTO.CurriculumRequest;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.service.CurriculumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    private final CurriculumService curriculumService;
    private final UserRepository userRepository;

    public CurriculumController (CurriculumService curriculumService, UserRepository userRepository) {
        this.curriculumService = curriculumService;
        this.userRepository = userRepository;
    }

    @PostMapping("/generate-curriculum")
    public ResponseEntity<Void> generateCurriculum(@RequestBody CurriculumRequest request, HttpServletResponse response) {
        try {
            User user = userRepository.findUserByUsername(request.username);
            ByteArrayInputStream pdfInputStream = curriculumService.generatePdf(user);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=curriculum.pdf");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            FileCopyUtils.copy(pdfInputStream, response.getOutputStream());

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}