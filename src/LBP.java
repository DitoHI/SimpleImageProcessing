import java.awt.image.BufferedImage;

public class LBP extends ImageProcessing {
    private int sumBin = 256;
    private int[] nilaiLBP = new int[sumBin];

    public LBP(BufferedImage image) {
        super(image);
        super.defaultResize(200,200);
        // default LBP
        for (int i = 0; i < sumBin; ++i) {
            nilaiLBP[i] = 0;
        }
    }

    private int convertData(int[] data, int sumData) {
        int retVal = 0;
        int[] tmp = new int[sumData];
        int cnt = sumData - 1;
        for (int i = 0; i < sumData; ++i) {
            tmp[i] = data[cnt];
            --cnt;
        }
        for (int i = 0; i < sumData; ++i) {
            if (tmp[i] == 1) {
                retVal += Math.pow(2, i);
            }
        }

        return retVal;
    }

    private int[] swapData(int[] data, int sumData) {
        int tmp = 0;
        for (int i = 0; i < sumData; ++i) {
            if (i == 0) {
                tmp = data[i];
            } else if (i == sumData - 1) {
                data[i] = tmp;
                break;
            }
            data[i] = data[i + 1];
        }

        return data;
    }

    private int minLBP(int x, int y) {
        int sumData = 8;
        int[] data = new int[sumData];
        int minData = 256;
        int p = super.getGrayImage().getRGB(x, y);
        int r = (p >> 16) & 0xff;
        if (r > ((super.getGrayImage().getRGB(x - 1, y - 1) >> 16) & 0xff)) { data[0] = 0; }
        else data[0] = 1;
        if (r > ((super.getGrayImage().getRGB(x, y - 1) >> 16) & 0xff)) { data[1] = 0; }
        else data[1] = 1;
        if (r > ((super.getGrayImage().getRGB(x + 1, y - 1) >> 16) & 0xff)) { data[2] = 0; }
        else data[2] = 1;
        if (r > ((super.getGrayImage().getRGB(x + 1, y) >> 16) & 0xff)) { data[3] = 0; }
        else data[3] = 1;
        if (r > ((super.getGrayImage().getRGB(x + 1, y + 1) >> 16) & 0xff)) { data[4] = 0; }
        else data[4] = 1;
        if (r > ((super.getGrayImage().getRGB(x, y + 1) >> 16) & 0xff)) { data[5] = 0; }
        else data[5] = 1;
        if (r > ((super.getGrayImage().getRGB(x - 1, y + 1) >> 16) & 0xff)) { data[6] = 0; }
        else data[6] = 1;
        if (r > ((super.getGrayImage().getRGB(x - 1, y) >> 16) & 0xff)) { data[7] = 0; }
        else data[7] = 1;

        for (int i = 0;i < sumData; ++i) {
            int tmpData = this.convertData(data, sumData);
            if (tmpData < minData) {
                minData = tmpData;
            }
            data = this.swapData(data, sumData);
        }

        return minData;
    }

    public int[] makeLBP() {
        for (int i = 1; i < super.getHeight() - 1; ++i) {
            for (int j = 1; j < super.getWidth() - 1; ++j) {
                int value = this.minLBP(j, i);
                ++nilaiLBP[value];
            }
        }
        return nilaiLBP;
    }

    public int[] getNilaiLBP() { return nilaiLBP; }
}
