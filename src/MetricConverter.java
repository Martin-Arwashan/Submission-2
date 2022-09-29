import java.util.Scanner;

class MetricConverter {

  public static float converter(String intialMetric, String finalMetric, float intialNum) {
    String badInput = "Your input is not currently handled by this app, please input another query, for example, 1 cm = in";
    float finalNum = 0;
    switch (intialMetric) {
      case "cm":
        switch (finalMetric) {
          case "in":
            finalNum = (float) (intialNum * 0.3937008);
            break;
          case "m":
            finalNum = (intialNum / 100);
            break;
          default:
            System.out.println(badInput);
            return 0;
        }
      break;

      case "m":
        switch (finalMetric) {
          case "cm":
            finalNum = (intialNum * 100);
            break;
          case "in":
            finalNum = (float) (intialNum * 39.370);
            break;
          default:
            System.out.println(badInput);
            return 0;
        }
      break;

      default:
        System.out.printf("%.2f %s = %.2f %s \n", intialNum, intialMetric, finalNum, finalMetric);
    }
    return finalNum;
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    String str;
    String[] stringArray;
    float intialNum;
    String intialMetric;
    String finalMetric;
    float finalNum;
    while (true) {
      System.out.println("Please input your metric to be converted, ex: 5m = in, or exit to quit.");
      System.out.println("Avaible conversions are:");
      System.out.println("    Centimeters to Inches");
      System.out.println("    Centimeters to Meters");
      System.out.println("    Meters to Inches");
      System.out.println("    Meters to Centimeters");

      str = scanner.nextLine();
      if (str.equals("exit")) {
        System.out.println("Thank you, goodbye");
        scanner.close();
        break;
      }
      stringArray = str.split(" ");
      if (stringArray.length != 4) {
        System.out.println("Please input in the correct format.");
      } else {
        intialNum = Float.parseFloat(stringArray[0]);
        intialMetric = stringArray[1];
        finalMetric = stringArray[3];
        converter(intialMetric, finalMetric, intialNum);
      }
    }
  }
}