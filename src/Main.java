import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[] arr1 = {43,5,2,6,7,3,2,1,63,6};
    static int[] arr2 = {9,7,5,3,2,6,7,8};
    static int[] arr3 = {5,7,34,7,9,3,7,8};

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("***************MENU**************");
            System.out.println("1. hiển thị các mảng số nguyên");
            System.out.println("2. gộp 2 mảng số nguyên");
            System.out.println("3. gộp 3 mảng số nguyên");
            System.out.println("4. hiển 1 mảng");
            System.out.println("5. dừng chương trình");
            System.out.println("nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showArr(arr1, "mảng 1:");
                    showArr(arr2, "mảng 2: ");
                    showArr(arr3, "mảng 3: ");
                    break;
                case 2:
                    int[] arr = gopMang();
                    System.out.println("mảng sau khi gộp là: " + Arrays.toString(arr));
                    break;
                case 3:
                    System.out.println(Arrays.toString(gop3Mang()));
                    break;
                case 4:
                    arrayHandle();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void arrayHandle() {
        System.out.println("Nhập mảng bạn muốn in: ");
        int choice = scanner.nextInt();
        int[] arr = laymang(choice);
        System.out.println("Mảng " + choice + " là " + Arrays.toString(arr));
        System.out.println("1. Thêm một phần tử vào cuối");
        System.out.println("2. Thêm một phần tử vào đầu");
        System.out.println("3. Xóa một phần tử tại vị trí đã chọn");
        System.out.println("4. Quay lại.");
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                arr = themCuoi(arr);
                break;
            case 2:
                arr = themDau(arr);
                break;
            case 3:
                arr = xoaPhanTu(arr);
                break;
        }
        System.out.println("Mảng sau khi thay đổi: " + Arrays.toString(arr));
    }

    private static int[] themCuoi(int[] arr) {
        System.out.println("Nhập giá trị phần tử muốn thêm vào cuối mảng: ");
        int value = scanner.nextInt();
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = value;
        return newArr;
    }

    private static int[] themDau(int[] arr) {
        System.out.println("Nhập giá trị phần tử muốn thêm vào đầu mảng: ");
        int value = scanner.nextInt();
        int[] newArr = new int[arr.length + 1];
        newArr[0] = value;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    private static int[] xoaPhanTu(int[] arr) {
        System.out.println("Nhập vị trí của phần tử muốn xóa: ");
        int position = scanner.nextInt();
        if (position < 0 || position >= arr.length) {
            System.out.println("Vị trí không hợp lệ!");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != position) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    private static int[] gop3Mang() {
        int[] gop3mang = new int[arr1.length + arr2.length + arr3.length];
        for (int i = 0; i < gop3mang.length; i++) {
            if (i < arr1.length) {
                gop3mang[i] = arr1[i];
            } else if (i < (arr1.length + arr2.length)) {
                gop3mang[i] = arr2[i - arr1.length];
            } else {
                gop3mang[i] = arr3[i - arr1.length - arr2.length];
            }

        }
        return gop3mang;
    }

    private static int[] gopMang() {
        System.out.println("nhập 2 mảng bạn muốn gộp: ");
        int choice = scanner.nextInt();
        int[] mang1 = laymang(choice);
        System.out.println("mảng 2: ");
        choice = scanner.nextInt();
        int[] mang2 = laymang(choice);

        int[] newArr = new int[mang1.length + mang2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < mang1.length) {
                newArr[i] = mang1[i];
            } else {
                newArr[i] = mang2[i - mang1.length];
            }
        }
        return newArr;
    }

    private static void showArr(int[] arr, String tenmang) {
        System.out.println(tenmang + Arrays.toString(arr));
    }

    private static int[] laymang(int somang) {
        switch (somang) {
            case 1:
                return arr1;
            case 2:
                return arr2;
            case 3:
                return arr3;
        }
        return null;
    }
}