package com.codewith.abhishek;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class PdfController {


    @GetMapping("/")
    public String index() {
        return "download";
    }


    @GetMapping("/download-pdf")
    public ResponseEntity<InputStreamResource> downloadpdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"code.pdf\"");
        InputStream inputStream = new ClassPathResource("static/image/code.pdf").getInputStream();
        InputStreamResource input = new InputStreamResource(inputStream);
        return ResponseEntity.ok(input);
    }


}
