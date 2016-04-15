import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardWithObstacles {

    static List<Integer[]> obstacles = new ArrayList<Integer[]>(){{
//            add(new Integer[]{1,1});
            add(new Integer[]{0,2});
            add(new Integer[]{2,0});

    }};

    static Integer []  startPoint = {0,0};

    static Integer []  endPoint = {4,4};

    static List<Integer[]> reachedPoints = new ArrayList<Integer[]>(){{
        add(endPoint);
    }};


    static int moveCount = 1;

    private static boolean isPointsEqual(Integer[] first, Integer[] second){
        return first[0] == second[0] &&  first[1] == second[1];
    }

    private static boolean isObstacle(Integer[] point){
        for(int i=0;i<obstacles.size();i++){
            if(isPointsEqual(obstacles.get(i), point)){
                return true;
            }
        }
        return false;
    }

    private static List<Integer[]>  findPointsCanBeReached(Integer[] point){
        int m = point[0];
        int n = point[1];
        List<Integer[]> newReachedPoints = new ArrayList<Integer[]>();
        //horizontal
        for(int i=n-1; i>=0; i--){
            Integer[] newPoint = {m, i};
            if(isObstacle(newPoint)){
                break;
            }
            newReachedPoints.add(newPoint);
        }
        //vertical
        for(int i=m-1; i>=0; i--){
            Integer[] newPoint = {i, n};
            if(isObstacle(newPoint)){
                break;
            }
            newReachedPoints.add(newPoint);
        }

        return newReachedPoints;
    }

    private static boolean isStartPointAmongReached(){
        for(int i=0;i<reachedPoints.size();i++){
            if(isPointsEqual(reachedPoints.get(i), startPoint)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        while(!isStartPointAmongReached()) {
            moveCount++;
            List<Integer[]> newReachedPoints = new ArrayList<Integer[]>();
            for(Integer[] reachedPoint : reachedPoints){
                newReachedPoints.addAll(findPointsCanBeReached(reachedPoint));
            }
            reachedPoints.addAll(newReachedPoints);
        }
        System.out.println("[5, 5] can be reached in " + moveCount + " moves from [1,1]");
    }
}
