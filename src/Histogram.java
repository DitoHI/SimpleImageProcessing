import java.awt.image.BufferedImage;

public class Histogram extends ImageProcessing {

    //initialize 28 bin
    private int[][] bin = { {0,0,0}, {0,0,178}, {0,0,255}, {0,178,0}, {0,178,178}, {0,178, 255},
            {0,255,0}, {0,255,178}, {0,255,255}, {178,0,0}, {178,0,178}, {178,0,255},
            {178,178,0}, {178,178,178}, {178,178,255}, {178,255,0}, {178,255,178}, {178,255,255},
            {255,0,0}, {255,0,178}, {255,0,255}, {255,178,0}, {255,178,178}, {255,178,255},
            {255,255,0}, {255,255,178}, {255,255,255}};
    private int[] histo = new int[bin.length];

    public Histogram(BufferedImage image) {
        super(image);
        super.defaultResize();
        // default histo : zero value
        for (int i = 0; i < bin.length; ++i) {
            histo[i] = 0;
        }
    }

    public int[][] getBin() { return bin; }

    public int[] makeHisto() {
        for (int i = 0; i < super.getWidth(); ++i ) {
            for (int j = 0; j < super.getHeight(); ++j) {
                int p = super.getImage().getRGB(i, j);
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = (p) & 0xff;
                int dist = 999;
                int cnt = 0;
                for (int h = 0; h < bin.length; ++h) {
                    int x = Math.abs(r - bin[h][0]) + Math.abs(g - bin[h][1]) + Math.abs(b - bin[h][2]);
                    if (x < dist) {
                        dist = x;
                        cnt = h;
                    }
                }
                ++histo[cnt];
            }
        }
        return histo;
    }
}
