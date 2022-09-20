package org.code.neighborhood.support;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorHelpers {
  private static final String HEX_WEB_COLOR_PATTERN = "^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$";
  private static final Pattern PATTERN = Pattern.compile(HEX_WEB_COLOR_PATTERN);
  private static final Set<String> WEB_COLORS =
      Set.of(
          "white",
          "silver",
          "gray",
          "black",
          "red",
          "maroon",
          "yellow",
          "olive",
          "lime",
          "green",
          "aqua",
          "teal",
          "blue",
          "navy",
          "fuchsia",
          "purple",
          "mediumvioletred",
          "deeppink",
          "palevioletred",
          "hotpink",
          "lightpink",
          "pink",
          "darkred",
          "firebrick",
          "crimson",
          "indianred",
          "lightcoral",
          "salmon",
          "darksalmon",
          "lightsalmon",
          "orangered",
          "tomato",
          "darkorange",
          "coral",
          "orange",
          "darkkhaki",
          "gold",
          "khaki",
          "peachpuff",
          "palegoldenrod",
          "moccasin",
          "papayawhip",
          "lightgoldenrodyellow",
          "lemonchiffon",
          "lightyellow",
          "brown",
          "saddlebrown",
          "sienna",
          "chocolate",
          "darkgoldenrod",
          "peru",
          "rosybrown",
          "goldenrod",
          "sandybrown",
          "tan",
          "burlywood",
          "wheat",
          "navajowhite",
          "bisque",
          "blanchedalmond",
          "cornsilk",
          "darkgreen",
          "darkolivegreen",
          "forestgreen",
          "seagreen",
          "olivedrab",
          "mediumseagreen",
          "limegreen",
          "springgreen",
          "mediumspringgreen",
          "darkseagreen",
          "mediumaquamarine",
          "yellowgreen",
          "lawngreen",
          "chartreuse",
          "lightgreen",
          "greenyellow",
          "palegreen",
          "darkcyan",
          "lightseagreen",
          "cadetblue",
          "darkturquoise",
          "mediumturquoise",
          "turquoise",
          "cyan",
          "aquamarine",
          "paleturquoise",
          "lightcyan",
          "darkblue",
          "mediumblue",
          "midnightblue",
          "royalblue",
          "steelblue",
          "dodgerblue",
          "deepskyblue",
          "cornflowerblue",
          "skyblue",
          "lightskyblue",
          "lightsteelblue",
          "lightblue",
          "powderblue",
          "indigo",
          "darkmagenta",
          "darkviolet",
          "darkslateblue",
          "blueviolet",
          "darkorchid",
          "magenta",
          "slateblue",
          "mediumslateblue",
          "mediumorchid",
          "mediumpurple",
          "orchid",
          "violet",
          "plum",
          "thistle",
          "lavender",
          "mistyrose",
          "antiquewhite",
          "linen",
          "beige",
          "whitesmoke",
          "lavenderblush",
          "oldlace",
          "aliceblue",
          "seashell",
          "ghostwhite",
          "honeydew",
          "floralwhite",
          "azure",
          "mintcream",
          "snow",
          "ivory",
          "darkslategray",
          "dimgray",
          "slategray",
          "lightslategray",
          "darkgray",
          "lightgray",
          "gainsboro");

  public static boolean isColor(String color) {
    Matcher matcher = PATTERN.matcher(color);
    return matcher.matches() || WEB_COLORS.contains(color.toLowerCase());
  }
}
