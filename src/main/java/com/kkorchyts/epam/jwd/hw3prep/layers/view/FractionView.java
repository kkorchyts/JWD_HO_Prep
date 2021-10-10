package com.kkorchyts.epam.jwd.hw3prep.layers.view;

import com.kkorchyts.epam.jwd.hw3prep.layers.bean.Fraction;

public class FractionView {
    public String print(Fraction f1, Fraction f2, Fraction res, char operation) {
        String str;
        str = print(f1);
        str = str + " "  + operation + " ";
        str = str + print(f2);
        str = str + " = ";
        str = str + print(res);
        return str;
    }

    private String print(Fraction f) {
        return f.getNumerator() + "/" + f.getDenominator();
    }


}
