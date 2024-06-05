package extras;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	public static void main(String[] args) {
		int alto = 500;
		int ancho = 500;
		int[][] pixels = new int [alto][ancho];
		pixels = generarPixeles(pixels);
		
		crearMarco(pixels, alto, ancho, 40);
		
		BufferedImage imagen = crearImagen(pixels);
		
		guardarImagen(imagen, "imagen.jpg");
		
		System.out.println("Imagen generada correctamente");
	}

	public static void crearMarco(int[][] pixels, int alto, int ancho, int borde) {
		for(int i = 0;i<ancho;i++) {
			for(int j = 0;j<borde;j++) {
				pixels[i][j] = 110;
			}
			for(int j = (alto-borde);j<alto;j++) {
				pixels[i][j] = 110;
			}
		}
		for(int i = 0;i<alto;i++) {
			for(int j = 0;j<borde;j++) {
				pixels[j][i] = 110;
			}
			for(int j = (ancho-borde);j<alto;j++) {
				pixels[j][i] = 110;
			}
		}
	}

	public static int[][] generarPixeles(int[][] pixels) {
		int numero = 0;
		for(int i = 0; i<pixels.length;i++) {
			for(int j = 0;j<pixels[0].length;j++) {
				numero = (int) (Math.random()*256);
				pixels[i][j] = numero;
			}
		}
		return pixels;
	}
	
	private static BufferedImage crearImagen(int[][] pixels) {
        int ancho = pixels.length;
        int alto = pixels[0].length;

        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagen.setRGB(i, j, (pixels[i][j] << 16) | (pixels[i][j] << 8) | pixels[i][j]);
            }
        }

        return imagen;
    }

    private static void guardarImagen(BufferedImage imagen, String filePath) {
        try {
            File file = new File(filePath);
            ImageIO.write(imagen, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
