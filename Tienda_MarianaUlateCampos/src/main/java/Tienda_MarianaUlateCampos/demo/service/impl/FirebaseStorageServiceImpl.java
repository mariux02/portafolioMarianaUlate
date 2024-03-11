/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda_MarianaUlateCampos.demo.service.impl;

import Tienda_MarianaUlateCampos.demo.service.FirebaseStorageService;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageOptions;
import com.Tienda_MarianaUlateCampos.service.FirebaseStorageService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FirebaseStorageServiceImpl implements FirebaseStorageService {

    private Object BlobId;
    private Object StorageOptions;
    private Object GoogleCredentials;
    private String carpeta;
    private String fileName;
    private Object json;
    private Object SignUrlOption;
    
    @Override
    @SuppressWarnings("empty-statement")
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id){
    try{
    String extension = archivoLocalCliente.getOriginalFilename();
    
    String fileName = "img" + sacaNumero(id) + extension;
    
    File file = this.convertToFile(archivoLocalCliente);
    
    String URL = this.uploadFile(file, carpeta, fileName);
    
    file.delete();
    
    return URL;
    } catch (IOException e) {
    e.printStackTrace();
    return null;
            
    }
}
private String uploadFile(File file,
        String carpeta,
        String fileName) throws IOException(

        ClassPathResource json = new ClassPathResource(rutaJsonFile + File.separator + archivoJsonFile);
        BlobId blobId = BlobId.of(BucketName,
                rutaSuperiorStorage + "/" + carpeta + "/" + fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        
        Credentials credentials = GoogleCredentials.fromStream(json.getInputStream());
        
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        
        storage.create(blobInfo,Files.readAllBytes(file.toPath()));
        String url = storage.signUrl(blobInfo,3650,TimeUnit.DAYS,SignUrlOption.signWith((ServiceAccountSigner) credentials)).toString();
        
return url;
    
    
}

