import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFT1_GiftWrapping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGifts = scanner.nextInt();
        int numberOfGiftWrap = scanner.nextInt();

        int[] giftSizes = new int[numberOfGifts];
        for (int i = 0; i < numberOfGifts; i++) {
            giftSizes[i] = scanner.nextInt();
        }

        int[] paperSizes = new int[numberOfGiftWrap];
        for (int i = 0; i < numberOfGiftWrap; i++) {
            paperSizes[i] = scanner.nextInt();
        }

        Arrays.sort(giftSizes);
        Arrays.sort(paperSizes);

        int giftIndex = 0;
        int paperIndex = 0;
        int wrappedGifts = 0;

        while (giftIndex < numberOfGifts && paperIndex < numberOfGiftWrap) {
            if (giftSizes[giftIndex] * 3 < paperSizes[paperIndex]) {
                giftIndex++;

            } else if (paperSizes[paperIndex] < 2 * giftSizes[giftIndex]) {
                paperIndex++;
            } else if (paperSizes[paperIndex] >= 2 * giftSizes[giftIndex]
                    && paperSizes[paperIndex] <= 3 * giftSizes[giftIndex]) {
                wrappedGifts++;
                giftIndex++;
                paperIndex++;
            }
            // if (paperSizes[paperIndex] / giftSizes[giftIndex] <= 3
            // || paperSizes[paperIndex] / giftSizes[giftIndex] >= 2) {
            // wrappedGifts++;
            // }else if(paperSizes[paperIndex]/giftSizes[giftIndex]<2){
            // paperIndex++;
            // }else if(paperSizes[paperIndex]/giftSizes[giftIndex]>3){
            // giftIndex++;
            // }
        }

        System.out.println(wrappedGifts);

        scanner.close();
    }
}