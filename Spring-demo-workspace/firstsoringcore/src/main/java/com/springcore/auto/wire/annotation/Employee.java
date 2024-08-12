package com.springcore.auto.wire.annotation;

public class Employee {
    private Address address;

    public Employee() {
        super();
    }

    public Employee(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [address=" + address + "]";
    }
}
