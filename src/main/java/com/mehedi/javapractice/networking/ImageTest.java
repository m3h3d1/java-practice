package com.mehedi.javapractice.networking;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageTest {
    public static void main(String[] args)
    {
        URL url = null;
        Image imageRef;
        try {
            url = new URL("https://github.com/bhoffman0/CSAwesome/raw/master/_sources/Unit6-Arrays/6-1-images/kitten.jpg");
            imageRef = javax.imageio.ImageIO.read(url);
            System.out.println(imageRef);
        }
        catch (MalformedURLException e) {
           System.out.println( "Malformed URL: " + e) ;
        }
        catch (IOException e) {
           System.out.println("I/O Exception " + e);
        }
    }
}
