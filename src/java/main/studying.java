import java.util.Scanner;

public class studying {
    public static void main(String[] args) {
        final double TIME_UNIT = .00001;
        Scanner kb = new Scanner(System.in);
        String data = kb.nextLine();

        int subjects = Integer.parseInt(data.split(" ")[0]);
        double time = Double.parseDouble(data.split(" ")[1]);
        int index;
        double maxValue;
        double sum = 0;

        //studyEqs has all the input. timespendeach holds how much time you have spent on each currently
        //valueOfTime is used to find the best use of youre next TIME_UNIT
        GradeEquation[] studyEqs = new GradeEquation[subjects];
        double[] timeSpentEach = new double[subjects];
        double[] valueOfTime = new double[subjects];

        //initialize timespenteach to 0 for all indices
        for (int i = 0; i < subjects; i++) {
            timeSpentEach[i] = 0;
        }

        //take in input for gradeEquations
        for (int i = 0; i < subjects; i++) {
            studyEqs[i] = new GradeEquation(kb.nextDouble(),kb.nextDouble(),kb.nextDouble());
        }

        while(time > 0){

            for (int i = 0; i < subjects; i++) {
                if(perfectGrade(studyEqs[i],timeSpentEach[i])){
                    valueOfTime[i] = 0;
                }
                else {
                    valueOfTime[i] =
                            studyEqs[i].pointsEarned(timeSpentEach[i] + TIME_UNIT) -
                                    studyEqs[i].pointsEarned(timeSpentEach[i]);
                }
            }
            maxValue = valueOfTime[0];
            index = 0;
            for (int i = 1; i < subjects; i++) {
                if(maxValue< valueOfTime[i]){
                    index = i;
                    maxValue = valueOfTime[i];
                }
            }
            timeSpentEach[index] += TIME_UNIT;
            time-=TIME_UNIT;
        }
        for (int i = 0; i < subjects; i++) {
            sum+= studyEqs[i].pointsEarned(timeSpentEach[i]);
        }
        System.out.println(sum/subjects);
    }

    private static boolean perfectGrade(GradeEquation studyEq, double timeSpentEach) {
        return Math.abs(studyEq.pointsEarned(timeSpentEach) - 100) <= .05;
    }
}

//stores a b and c values for equation telling you value of studying
   class GradeEquation {
    double a,b,c;
    public GradeEquation(double i, double j, double k){
        a = i;
        b = j;
        c = k;
    }
    public double pointsEarned(double time){
        return (Math.pow(time,2)*a + time * b + c);
    }
}
