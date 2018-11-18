# Simple Image Processing

For starter, this library helps you to get through of simple processing of your images. See our class `Test.java` to helps you understand the basic of usage

### Histogram

This class is used to get the histogram chart of the images. Here is basic example to get the histogram of the image.

```java
ImageProcessing histo = new Histogram(image);
int[] histoPixel = ((Histogram) histo).makeHisto();
// this is the output by using the example image
// [2519, 16443, 0, 25913, 20320, 16, 0, 0, 0, 54496, 3243, 0, 26301, 684, 2, 2, 2, 0, 116, 36, 0, 246, 61, 0, 0, 0, 0]
```

### LBP

This class is useful to get the shape of your image. Here is the basic example of the usage.

```java
ImageProcessing lbp = new LBP(image);
int[] lbpPixel = ((LBP) lbp).makeLBP();
// this is the output by using the example image
// [967, 2334, 0, 2510, 0, 263, 0, 3497, 0, 316, 0, 481, 0, 557, 0, 7162, 0, 211, 0, 226, 0, 23, 0, 235, 0, 198, 0, 247, 0, 291, 0, 4858, 0, 0, 0, 0, 0, 34, 0, 201, 0, 0, 0, 23, 0, 85, 0, 588, 0, 0, 0, 54, 0, 20, 0, 176, 0, 0, 0, 185, 0, 502, 0, 4098, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 0, 0, 0, 41, 0, 0, 0, 341, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 329, 0, 0, 0, 0, 0, 0, 0, 136, 0, 0, 0, 0, 0, 0, 0, 3540, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2054]
```
