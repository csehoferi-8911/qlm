package com.example.qlm.erp;


import org.springframework.stereotype.Service;

@Service
public class SeatingArrangementService {

    public int calculateSeatingArrangements(final ClassModel classModel) {
        final var numberOfTables = classModel.numberOfTables();
        final var reservedTables = classModel.reservedTables();
        if (numberOfTables > 24) {
            throw new IllegalArgumentException("Az asztalok száma nem lehet több mint 24.");
        }
        for (int table : reservedTables) {
            if (table < 1 || table > numberOfTables) {
                throw new IllegalArgumentException("Nem létező asztal van megadva foglaltnak: " + table);
            }
        }

        int seatingArrangements = 0;
        for (int i = 1; i <= numberOfTables; i++) {
            // ha az aktuális foglalt, következőre ugrik
            if (reservedTables.contains(i)) {
                continue;
            }
            // horizontal pairing
            if (i % 2 != 0 && i + 1 <= numberOfTables && !reservedTables.contains(i + 1)) {
                seatingArrangements++;
            }
            // vertical pairing
            if (i + 2 <= numberOfTables && !reservedTables.contains(i + 2)) {
                seatingArrangements++;
            }
        }
        return seatingArrangements;
    }

}
