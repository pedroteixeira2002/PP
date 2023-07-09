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
 * This exception is thrown when there is no active edition
 */
public class NoActveEdition extends Exception {
    public NoActveEdition(String message) {
        super(message);
    }
}
