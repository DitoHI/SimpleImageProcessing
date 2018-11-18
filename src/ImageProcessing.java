import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class ImageProcessing {
    private BufferedImage image;
    private BufferedImage grayImage;
    private int width = 0;
    private int height = 0;
    private int newWidth = 400;
    private int newHeight = 400;

    public ImageProcessing() {
    }

    public ImageProcessing(BufferedImage image) {
        this.image = image;
        this.defaultResize();
    }

    public void setImage(BufferedImage image) { this.image = image; }

    private void setWidth() {
        this.width = this.image.getWidth();
    }

    private void setHeight() {
        this.height = this.image.getHeight();
    }

    // automatic resize of resolution
    // under 400
    public void defaultResize(int defaultWidth, int defaultHeight) {
        if (defaultWidth == 0) {
            defaultResize(newWidth, defaultHeight);
        }
        setWidth();
        setHeight();
        if (this.width >= this.height) {
            if (this.width > defaultWidth) {
                newHeight = (this.height * defaultWidth) / this.width;
                this.image = this.resize(defaultWidth, newHeight);
                setWidth();
                setHeight();
            }
        } else {
            if (this.height > defaultHeight) {
                newWidth = (this.width * defaultHeight) / this.height;
                this.image = this.resize(newWidth, defaultHeight);
                setWidth();
                setHeight();
            }
        }
    }

    // overloading for defaultResize to any width and height
    public void defaultResize() {
        defaultResize(newWidth, newHeight);
    }

    public void defaultResize(int defaultWidth) {
        defaultResize(defaultWidth, newHeight);
    }

    // src : https://stackoverflow.com/a/9417836/5771652
    // by : Ocracoke
    private BufferedImage resize(int newW, int newH) {
        Image tmp = this.image.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public BufferedImage getImage() { return this.image; }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public BufferedImage getGrayImage() {
        if (this.grayImage == null) {
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            this.grayImage = op.filter(this.image, null);
        }
        return this.grayImage;
    }

    // src : https://stackoverflow.com/a/9131755/5771652
    // by : Martijn Courteaux
    public void convertImgToGray() {
        grayImage = this.image;
        for (int x = 0; x < grayImage.getWidth(); ++x) {
            for (int y = 0; y < grayImage.getHeight(); ++y) {
                int rgb = grayImage.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                int grayLevel = (r + g + b) / 3;
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                grayImage.setRGB(x, y, gray);
            }
        }
    }
}
