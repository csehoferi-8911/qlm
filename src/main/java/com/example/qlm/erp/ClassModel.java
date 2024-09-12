package com.example.qlm.erp;

import java.util.Set;

@ValidClassModel
public record ClassModel(int numberOfTables, Set<Integer> reservedTables) {
}
