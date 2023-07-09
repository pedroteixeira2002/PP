/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package exceptions;

/**
 * this exception is thrown when a submission is up-to-date
 */
public class SubmissionsUpToDate extends Exception{
    public SubmissionsUpToDate(String message) {
        super(message);
    }
}
