0xFF & 35 //and
0xFF | 35 //or
0xFF ^ 35 //xor

(0xFFFFFF >> 8).equals(0x00FFFF) // shift on 1 byte to right
(0xFF << 16).equals(0xFF0000) // shift on 2 bytes to left

type Color = (Int, Int, Int)

val red:Color = (255,0,0)

def makeInt(c:Color):Int = {
  val color = c._1 :: c._2 :: c._3 :: Nil // make a list
  def sumColor(acc:Int = 0, i:Int = 0):Int = {
    if (i > 2) acc else
      sumColor(acc + ((0xFF & color(i)) << 16 - 8*i), i + 1)
  }
  sumColor()
}

def getColor(hex:Int):Color = ((hex >> 16) & 0xFF, (hex >> 8) & 0xFF, (hex >> 0) & 0xFF)

makeInt(red)
makeInt(red).equals(0xFF0000)
getColor(makeInt(red))
getColor(makeInt(red)).equals(red)

getColor(0xFF0A0F)