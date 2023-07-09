package cbl;

import java.util.Arrays;

public class Evaluations {
    private static final int SIZE = 20;
    private EvaluationImp[] evaluations;
    private int evaluationCount;

    public Evaluations() {
        this.evaluations = new EvaluationImp[SIZE];
    }

    public void addEvaluation(EvaluationImp evaluation) {
        this.evaluations[evaluationCount] = evaluation;
        evaluationCount++;
    }

    @Override
    public String toString() {
        return "\n--------- Evaluations ------------" +
                "\n Evaluations=" + Arrays.toString(evaluations) +
                "\n EvaluationCount=" + evaluationCount;
    }
}
