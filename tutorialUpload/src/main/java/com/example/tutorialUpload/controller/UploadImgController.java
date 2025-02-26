package com.example.tutorialUpload.controller;

import com.example.tutorialUpload.model.payload.UtenteDTO;
import com.example.tutorialUpload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadImgController {

    @Autowired
    UploadService service;

    // metodo di caricamento file su servizio cloud (cloudinary)
    @PostMapping("/prova")
    public String caricaFile(@RequestPart("file")MultipartFile file, @RequestPart("dto") UtenteDTO dto){

        // Check
        if(file == null  || file.isEmpty() || file.getName()==null){
            return "File non presente";
        }else{

            try {

                // inviare tutti i dati ad un servizio

                return service.upload(file, dto);

            } catch (IOException e) {
                return "Problemi di caricamento";
            }

        }


    }

}
