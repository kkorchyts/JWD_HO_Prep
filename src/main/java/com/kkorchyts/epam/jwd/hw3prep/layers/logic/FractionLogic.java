package com.kkorchyts.epam.jwd.hw3prep.layers.logic;

import com.kkorchyts.epam.jwd.hw3prep.layers.bean.Fraction;
import com.kkorchyts.epam.jwd.hw3prep.layers.util.MathUtil;

public class FractionLogic {

    public Fraction addition(Fraction f1, Fraction f2) {
        int num, den;

        num = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
        den = f1.getDenominator() * f2.getDenominator();

        return new Fraction(num, den);
    }

    public Fraction subtraction(Fraction f1, Fraction f2) {
        int num, den;

        num = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getNumerator();
        den = f1.getDenominator() * f2.getDenominator();

        return new Fraction(num, den);
    }

    public void reduction(Fraction f) {
        int nod = MathUtil.nod(f.getNumerator(), f.getDenominator());
        f.setNumerator(f.getNumerator() / nod);
        f.setDenominator(f.getDenominator() / nod);
    }
}
