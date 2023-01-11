import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        // EX. 1 & 2
        ArrayList<Point> points = new ArrayList<>();

        FileProcessor fileProcessor = new FileProcessor(args[0]);
        fileProcessor.getItems();
        int pairCounter = 0;
        Double[] pair = new Double[2];
        for(String word : fileProcessor.words){
            pair[pairCounter] = Double.parseDouble(word);
            pairCounter += 1;
            if(pairCounter == 2){
                points.add(new Point(pair[0], pair[1]));
                pairCounter = 0;
            }
        }

        System.out.println("\nBefore sorting:");
        for(Point point: points){
            point.print();
        }

        // EX. 3 and a part of 4
        Collections.sort(points, Comparator.comparing((Point a) -> a.x));
        System.out.println("\nAfter sorting:");

        Double sumX = 0.0;
        Double sumY = 0.0;

        for(Point point: points){
            point.print();
            sumX += point.x;
            sumY += point.y;
        }
        Double minX = points.get(0).x;
        Double minY = points.get(0).y;
        Double maxX = points.get(0).x;
        Double maxY = points.get(0).y;
        for(Point point: points){
            if(point.x > maxX){maxX = point.x;}
            if(point.x < minX){minX = point.x;}
            if(point.y > maxY){maxY = point.y;}
            if(point.y < minY){minY = point.y;}
        }
        System.out.println("Min X= " + minX + " Min Y= " + minY +
                           "Max X= " + maxX + " Max Y= " + maxY);

        // Ex. 4
        Double avgX = sumX / points.size();
        Double avgY = sumY / points.size();
        Double uA = 0.0;
        Double uB = 0.0;
        Double sY = 0.0;
        Double a = 0.0;
        Double b = 0.0;

        Double D = 0.0;
        for(Point point: points){
            D += Math.pow((point.x - avgX), 2);
        }
        for(Point point: points){
            a += point.y * (point.x - avgX);
        }
        a = a / D;
        b = avgY - a * avgX;

        System.out.println("\ny = " + a + "x + " + b);

        Double temp = 0.0;
        for(Point point: points){
            temp += Math.pow(point.y - (a * point.x + b), 2);
        }
        sY = Math.sqrt(temp / (points.size() - 2));
        uA = sY / Math.sqrt(D);
        uB = sY * Math.sqrt((1.0 / (points.size())) + (Math.pow(avgX, 2)/D));

        System.out.println("u(a)= " + uA + " u(b)= " + uB);
    }
}



