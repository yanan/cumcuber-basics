package com.example.cucumber.transformation;

import cucumber.api.Transformer;

public class SalaryCountTransformer extends Transformer<Integer> {
    @Override
    public Integer transform(String salary) {
        return salary.length();
    }
}
