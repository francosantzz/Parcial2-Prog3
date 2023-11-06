package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Main.is_mutant;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    // Prueba para verificar la función checkLinea con una secuencia mutante y no mutante

    @Test
    void TestcheckLinea() {
        char[] mutantDNA = {'A', 'A', 'A', 'A', 'A', 'A'};
        char[] nonMutantDNA = {'A', 'C', 'T', 'G', 'C', 'A'};
        assertTrue(Main.checkLinea(mutantDNA));
        assertFalse(Main.checkLinea(nonMutantDNA));
    }
    // Prueba para verificar la función is_mutant con una matriz mutante y no mutante
    @Test
    void TestIs_mutant() {
        String[] mutantDNA = {"AAAAAA", "CCCCCC", "TTTTTT", "GGGGGG", "AAAAAA", "CCCCCC"};

        String[] nonMutantDNA = {"ATCGTA", "TACGCT", "GCATAC", "CTAGTC", "ACGCTA", "AGTACG"};

        assertTrue(is_mutant(mutantDNA));
        assertFalse(is_mutant(nonMutantDNA));
    }
    // Pruebas adicionales para verificar la función is_mutant con diferentes casos
    @Test
    public void testIsMutantMutantInRow() {
        String[] mutantMatrix = {
                "ATaaaa",
                "TACGCA",
                "GCATAC",
                "CTAGTC",
                "ACaaaa",
                "AGTACG"
        };
        assertTrue(is_mutant(mutantMatrix));
    }

    @Test
    public void testIsMutantMutantInColumn() {
        String[] mutantMatrix = {
                "AtCGAa",
                "TtCGCa",
                "GtATAa",
                "CtAGTa",
                "ACGCTC",
                "AGTACG"
        };
        assertTrue(is_mutant(mutantMatrix));
    }

    @Test
    public void testIsMutantMutantInDiagonal() {
        String[] mutantMatrix = {
                "Atcgaa",
                "tAccgt",
                "gcAtaC",
                "ctaACt",
                "acgCta",
                "agCacc"
        };
        assertTrue(is_mutant(mutantMatrix));
    }

    @Test
    public void testIsMutantNonMutant() {
        String[] nonMutantMatrix = {
                "ATCGTA",
                "TACGCT",
                "GCATAC",
                "CTAGTC",
                "ACGCTA",
                "AGTACG"
        };
        assertFalse(is_mutant(nonMutantMatrix));
    }

    @Test
    public void testIsMutantWithNumbers() {
        String[] matrixWithNumbers = {
                "ATCGAA",
                "TACGCT",
                "GCATAC",
                "CTAGTC",
                "ACGCTA",
                "AGTA12"
        };
        assertFalse(is_mutant(matrixWithNumbers));
    }

    @Test
    public void testIsMutantEmptyMatrix() {
        String[] emptyMatrix = new String[6];
        assertFalse(is_mutant(emptyMatrix));
    }

    @Test
    public void testIsMutantInvalidCharacter() {
        String[] matrixWithInvalidChar = {
                "ATCGAA",
                "TACGCT",
                "GCATAC",
                "CTAGTC",
                "ACGCTA",
                "AGTACX"
        };
        assertFalse(is_mutant(matrixWithInvalidChar));
    }

    @Test
    public void testIsMutantMutantWithMultipleSequences() {
        String[] mutantMatrix = {
                "ATCGAA",
                "TACGCT",
                "GCATAC",
                "CTAACC",
                "ACGCTA",
                "AGCCCC"
        };
        assertTrue(is_mutant(mutantMatrix));
    }
}