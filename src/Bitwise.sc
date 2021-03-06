import scala.annotation.tailrec

0xFF & 35 //and
0xFF | 35 //or
0xFF ^ 35 //xor

(0xFFFFFF >> 8).equals(0x00FFFF) // shift on 1 byte to right
(0xFF << 16).equals(0xFF0000) // shift on 2 bytes to left

type Color = (Int, Int, Int)

val red: Color = (255, 0, 0)

def makeInt(c: Color): Int = {
  @tailrec
  def sumColor(color: List[Int], acc: Int = 0, i: Int = 0): Int = {
    if (i > 2) acc
    else
      sumColor(color, acc + ((0xFF & color(i)) << 16 - 8 * i), i + 1)
  }
  sumColor(color = c._1 :: c._2 :: c._3 :: Nil)
}

def getColor(hex: Int): Color = ((hex >> 16) & 0xFF, (hex >> 8) & 0xFF, (hex >> 0) & 0xFF)

makeInt(red)
makeInt(red).equals(0xFF0000)
getColor(makeInt(red))
getColor(makeInt(red)).equals(red)
getColor(0xFF0A0F)

// make it \w case class
case class ColorClass(red: Int = 0, blue: Int = 0, green: Int = 0) {
  @tailrec
  final def mkInt(color: List[Int] = red :: blue :: green :: Nil, acc: Int = 0, i: Int = 0): Int = if (i > 2) acc else mkInt(color, acc + ((0xFF & color(i)) << 16 - 8 * i), i + 1)

  def equalToHex(hex: Int): Boolean = hex == mkInt()

  def getColorFromHex(hex: Int): ColorClass = ColorClass((hex >> 16) & 0xFF, (hex >> 8) & 0xFF, (hex >> 0) & 0xFF)

  def mkString(): String = "0x%02X%02X%02X".format(red, blue, green)
}

val orange = new ColorClass().getColorFromHex(0xFFA500)
orange.mkInt()
orange equalToHex 0xFFA500
println(orange.mkString())