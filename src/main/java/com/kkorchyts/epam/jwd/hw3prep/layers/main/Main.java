package com.kkorchyts.epam.jwd.hw3prep.layers.main;

import com.kkorchyts.epam.jwd.hw3prep.layers.bean.Fraction;
import com.kkorchyts.epam.jwd.hw3prep.layers.logic.FractionLogic;
import com.kkorchyts.epam.jwd.hw3prep.layers.view.FractionView;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);

        FractionLogic fractionLogic = new FractionLogic();
        FractionView fractionView = new FractionView();

        Fraction f;

        f = fractionLogic.addition(f1, f2);
        String resFractionView = fractionView.print(f1, f2, f, '+');

        System.out.println(resFractionView);
    }
}
