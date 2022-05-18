import py
import pytest
import math

def test_sum():
    num1 = 5
    num2= 2
    assert num1+num2 == 7


def test_difference():
    num1 = 5
    num2= 2
    assert num1- num2 ==3

def test_product():
    num1 = 5
    num2= 2
    assert num1 * num2 == 10

@pytest.mark.activity
def test_quotient():
    num1 = 4
    num2= 2
    assert num1/num2 == 2