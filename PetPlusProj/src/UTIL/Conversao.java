/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author geral
 */
public class Conversao {
    
    public String saberExtensao (String arquivo){
        String extensao = "";
        
        int i = arquivo.lastIndexOf('.');
        if (i>0) {
            extensao = arquivo.substring(i+1);
        }
        return extensao;
    }
    
    
    public  byte[] arquivoParaByte(BufferedImage img,String caminho) throws IOException{
         String ext = saberExtensao(caminho);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, ext, baos);
        byte[] imgBytes = baos.toByteArray();
        
        return imgBytes;
    }
    
}
