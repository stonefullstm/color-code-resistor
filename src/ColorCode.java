import java.util.StringTokenizer;

public class ColorCode {

  private String[] colors = {"preto", "marrom", "vermelho", "laranja", "amarelo", "verde", "azul", "violeta", "cinza", "branco"};

  private String getValue(String value) {
    StringTokenizer st = new StringTokenizer(value, " ");
    return st.nextToken();
  }

  private char getMultiplier(String value) {
    return value.charAt(value.length() - 1);
  }

  public String decode(String value) {
    boolean hasDecimal = false;
    int zeroes = 0;
    StringBuffer sb = new StringBuffer("");
    String resistorValue = getValue(value);
    char resistorMultiplier = getMultiplier(resistorValue);
    if (resistorMultiplier == 'k' || resistorMultiplier == 'M') {
      resistorValue = resistorValue.substring(0, resistorValue.length() - 1);
    }
    Float resistorFloatValue = Float.parseFloat(resistorValue);
    if (resistorFloatValue % 1.0 > 0) {
      hasDecimal = true;
      resistorFloatValue = resistorFloatValue * 10;
    }
    if (resistorFloatValue / 10 >= 10) {
      zeroes = 1;
      resistorFloatValue = resistorFloatValue / 10;
    }
    if (resistorFloatValue >= 10) {
      sb.append(colors[ (int) ((Math.floor(resistorFloatValue)) / 10) ] + " ");
      sb.append(colors[ (int) ((Math.floor(resistorFloatValue)) % 10) ] + " ");
    } else {
      sb.append(colors[ (int) Math.floor(resistorFloatValue) ] + " preto ");
      zeroes--;
    }
    if (resistorMultiplier == 'k') {
      zeroes += 3;
    } else if (resistorMultiplier == 'M') {
      zeroes += 6;
    }
    if (hasDecimal) {
      zeroes--;
    }
    sb.append(colors[zeroes] + " dourado");
    return sb.toString();
  }
}
