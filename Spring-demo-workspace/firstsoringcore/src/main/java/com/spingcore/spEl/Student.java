package com.spingcore.spEl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("#{2+5}")
    private int x;
    
    @Value("5")
    private int y;
    @Value("#{T(java.lang.Math).sqrt(25)}")
    private double Z;
    @Value("#{T(java.lang.Math).PI}")
private double Pi;
    @Value("#{new java.lang.String('jigyasa')}")
private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPi() {
		return Pi;
	}

	public void setPi(double pi) {
		Pi = pi;
	}

	public double getZ() {
		return Z;
	}

	public void setZ(double z) {
		Z = z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
	public String toString() {
		return "Student [x=" + x + ", y=" + y + ", Z=" + Z + ", Pi=" + Pi + ", name=" + name + "]";
	}
}
