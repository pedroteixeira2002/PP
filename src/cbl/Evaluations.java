/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */


package cbl;

import java.util.Arrays;

/**
 * This class represents the evaluations
 */
public class Evaluations {
    private static final int SIZE = 20;
    private EvaluationImp[] evaluations;
    private int evaluationCount;

    /**
     * Constructor for the class
     */
    public Evaluations() {
        this.evaluations = new EvaluationImp[SIZE];
    }

    /**
     * method to add an evaluation
     * @param evaluation the evaluation to be added
     */
    public void addEvaluation(EvaluationImp evaluation) {
        this.evaluations[evaluationCount] = evaluation;
        evaluationCount++;
    }

    /**
     * method that gives information about the evaluations
     * @return the information about the evaluations
     */
    @Override
    public String toString() {
        return "\n--------- Evaluations ------------" +
                "\n Evaluations=" + Arrays.toString(evaluations) +
                "\n EvaluationCount=" + evaluationCount;
    }
}
