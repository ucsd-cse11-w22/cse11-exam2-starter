// Point class, DO NOT MODIFY
class Point {
	int x, y;
	Point(int x, int y) { this.x = x; this.y = y; }
	boolean belowLeftOf(Point p) { return this.x < p.x && this.y < p.y; }
	boolean aboveRightOf(Point p) { return this.x > p.x && this.y > p.y; }
	double distance(Point p) {
	  int dx = p.x - this.x;
	  int dy = p.y - this.y;
	  return Math.sqrt(dx * dx + dy * dy);
	}
}

interface Region { 
    boolean contains(Point p); 
    
    // Task 1.3: onEdge
    // Your code here
}

class RectRegion implements Region {
	Point lowerLeft, upperRight;
	
    RectRegion(Point lowerL, Point upperR) {
	  this.lowerLeft = lowerL;
	  this.upperRight = upperR;
	}
	
    public boolean contains(Point p) { 
        return this.lowerLeft.belowLeftOf(p) && this.upperRight.aboveRightOf(p); 
    }
    
    // Task 1.3: onEdge
    // Your code here
}

class CircleRegion implements Region {
	Point center;
	int radius;
	
    CircleRegion(Point center, int radius) { 
        this.center = center; 
        this.radius = radius; 
    }
	
    public boolean contains(Point p) { 
        return this.center.distance(p) < this.radius; 
    }
    
    // Task 1.3: onEdge
    // Your code here
}
