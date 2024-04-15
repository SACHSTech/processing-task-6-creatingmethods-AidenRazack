import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * A. Razack
   * A program that draws colored stickment and hearts 
   */
  public void settings() {
	// put your size call here
    size(800, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
    frameRate(3); // This is here to make sure the draw() function only runs 3 times a second, preventing your eyes from being overwhelmed by the flashing lights
    realDraw();
}

  /**
     * Draws a grid of stickmen and hearts, this is put in a separate method for neatness
     */
    public void realDraw() {
      for (int i = 20; i < height; i += 60) {
          for (int x = 20; x < width; x += 60) {
              drawStickman(x, i);
              drawHeart(x + 10, i + 25);
          }
      }
  }

  /**
   * Draws a heart
   *
   * @param x - the X value of top left corner of where the heart will be drawn
   * @param y - the Y value of top left corner of where the heart will be drawn
   */
  public void drawHeart(int x, int y) {
      int[] heartColor = randomColour();
      fill(heartColor[0], heartColor[1], heartColor[2]);
      // Draw the left half of the heart
      beginShape();
      vertex(x + 5, y + 3);
      bezierVertex(x + 5, y, x, y, x, y + 3);
      endShape(CLOSE);
      // Draw the right half of the heart
      beginShape();
      vertex(x + 5, y + 3);
      bezierVertex(x + 5, y, x + 10, y, x + 10, y + 3);
      endShape(CLOSE);
      // Draw the bottom triangle of the heart
      beginShape();
      vertex(x, y + 3);
      vertex(x + 10, y + 3);
      vertex(x + 5, y + 10);
      endShape(CLOSE);
  }

  /**
   * Draws a stickman
   *
   * @param x - the X value of top left corner of where the stickman will be drawn
   * @param y - the Y value of top left corner of where the stickman will be drawn
   */
  public void drawStickman(int x, int y) {
      // Draw the head
      fill(0);
      ellipse(x + 5, y + 5, 10, 10);
      // Draw the body
      line(x + 5, y + 12, x + 5, y + 30);
      // Draw the arms
      line(x, y + 15, x + 10, y + 15);
      // Draw the legs
      line(x + 5, y + 30, x, y + 45);
      line(x + 5, y + 30, x + 10, y + 45);
  }

  /**
   * Description: creates a random colour
   *
   * @return int[] - integers representing the RGB color values 
   */
  public int[] randomColour() {
      int[] colour = new int[3];
      for (int i = 0; i < 3; i++) {
          colour[i] = (int) random(0, 255);
      }
      return colour;
  }

}