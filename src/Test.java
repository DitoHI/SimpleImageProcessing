import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BufferedImage image;

        // get current directory
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        // static dir to get the image
        String mainDir = s + "/src/" + "images/img_test.jpg";

        File file = new File(mainDir);
        if (file.isFile()) {
            try {
                image = ImageIO.read(file);

                // Testing for Histogram
                System.out.println("=====HISTOGRAM=====");
                ImageProcessing histo = new Histogram(image);
                System.out.println("Default Width " + histo.getWidth() + " & Default Height " + histo.getHeight());
                int[] histoPixel = ((Histogram) histo).makeHisto();
                System.out.println("===Pixel value of Histogram===\n" + Arrays.toString(histoPixel));

                System.out.println();

                // Testing for LBP
                System.out.println("=====LBP=====");
                ImageProcessing lbp = new LBP(image);
                System.out.println("Default Width " + lbp.getWidth() + " & Default Height " + lbp.getHeight());
                int[] lbpPixel = ((LBP) lbp).makeLBP();
                System.out.println("===Pixel value of LBP===\n" + Arrays.toString(lbpPixel));
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
}
