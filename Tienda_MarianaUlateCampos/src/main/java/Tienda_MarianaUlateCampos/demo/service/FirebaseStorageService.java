/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tienda_MarianaUlateCampos.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
  
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //el bucket list es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "techshop-70262.appspot.com";
    
    //esta es la ruta básica de este proyecto techshop
    final String rutaSuperiorStorage = "techshop";
    
    //ubicación donde se encuentra el archivo de configuración de json
    final String rutaJsonFile = "firebase";
    
    //el nombre del archivo Json
    final String archivoJsonFile = "techshop-70262-firebase-adminsdk-ftnwx-0442f8d411.json";
}
