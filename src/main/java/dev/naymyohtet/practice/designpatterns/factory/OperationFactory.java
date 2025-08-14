package dev.naymyohtet.practice.designpatterns.factory;

public interface OperationFactory {
    Operation getInstance(int choice) throws InvalidOperation;
}
