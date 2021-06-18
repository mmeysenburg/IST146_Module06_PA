import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * IST 146 Module 06 PA: use recursion to draw a Sierpinski triangle.
 */
public class Main {
  /**
   * Recursive method to draw the Sierpinski fractal on this panel. The method
   * draws one triangle, then calls itself three more times to draw the
   * subtriangles inside the original.
   *
   * @param gc Graphics context to draw on.
   *
   * @param p1 First vertex of the triangle.
   *
   * @param p2 Second vertex of the triangle.
   *
   * @param p3 Third vertex of the triangle.
   *
   * @param c Color for the triangle. Note that you should change color at
   *          each level of the recursion, so you will be able to see the
   *          fractal's detail.
   *
   * @param currentDepth Current depth of the recursion. Note that this
   *     parameter should COUNT UP until it reaches the value held in the
   *     maxDepth parameter.
   *
   * @param maxDepth Maximum depth value to end the recursion.
   */
  public static void drawSierpinski(Graphics2D gc, Point2D p1, Point2D p2,
                                    Point2D p3, Color c, int currentDepth,
                                    int maxDepth) {

    // TODO: ***** WRITE THIS METHOD! *****
    // This is the recursive method used to draw the fractal.

  }

  /**
   * Draw a colored triangle on the Sierpinski Fractal canvas.
   *
   * @param gc Graphics context of the canvas.
   *
   * @param p1 First vertex of the triangle.
   *
   * @param p2 Second vertex of the triangle.
   *
   * @param p3  Third vertex of the triangle.
   *
   * @param c Color to fill the triangle with.
   */
  private static void coloredTriangle(Graphics2D gc, Point2D p1, Point2D p2,
                                      Point2D p3, Color c) {

    Path2D path = new Path2D.Double();
    path.moveTo(p1.getX(), p1.getY());
    path.lineTo(p2.getX(), p2.getY());
    path.lineTo(p3.getX(), p3.getY());
    path.closePath();

    gc.setPaint(c);

    gc.fill(path);
  }

  /**
   * Compute the midpoint of the line segment defined by two points.
   *
   * @param p1 First endpoint of the line segment.
   *
   * @param p2 Second endpoint of the line segment.
   *
   * @return A new Point2D.Double object, holding the (x, y) coordinates
   * of the specified line segment's midpoint.
   */
  private static Point2D midpoint(Point2D p1, Point2D p2) {
    // TODO: ***** WRITE THIS METHOD! *****
    // Currently, this method is hard-wired to return (0, 0).

    return new Point2D.Double(0, 0);
  }

  /**
   * Application entry point.
   *
   * @param args Command-line arguments; ignored by this app.
   */
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    System.out.print("Enter maximum depth for the Sierpinski recursion: ");
    int maxDepth = 7;
    try {
      maxDepth = stdin.nextInt();
    } catch (NumberFormatException nfe) {
    }
    BufferedImage image =
        new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
    drawSierpinski(image.createGraphics(), new Point2D.Double(0, 0),
                   new Point2D.Double(999, 0), new Point2D.Double(499, 999),
                   Color.ORANGE, 0, maxDepth);
    try {
      ImageIO.write(image, "jpg", new File("sierpinski.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
