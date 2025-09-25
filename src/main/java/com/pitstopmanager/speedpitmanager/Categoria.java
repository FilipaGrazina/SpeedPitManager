package com.pitstopmanager.speedpitmanager;

/**
 *
 * @author anafilipa
 */
public enum Categoria {
    
    FORMULA_1("Fórmula 1"),
    MOTOGP("MotoGP"),
    RALLY("Rally");

    private final String nomeFormatado;

    Categoria(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public static Categoria fromString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula!");
        }

        String normalized = input.trim().toLowerCase();

        switch (normalized) {
            case "f1":
            case "formula1":
            case "formula 1":
            case "fórmula 1":
                return FORMULA_1;
            case "motogp":
            case "moto":
            case "gp":
                return MOTOGP;
            case "rally":
                return RALLY;
            default:
                throw new IllegalArgumentException("Categoria inválida: " + input +
                        ". Escolha entre 'Fórmula 1', 'MotoGP' ou 'Rally'.");
        }
    }
}
