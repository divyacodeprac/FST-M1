import pytest

@pytest.fixture
def list_initiliazation():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list


def test_result(list_initiliazation):
    sum = 0
    for i in list_initiliazation:
        sum = sum + i
        print(sum)
    assert sum == 55
