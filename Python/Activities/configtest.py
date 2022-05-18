import pytest

@pytest.fixture
def list_initiliazation():
    list = []
    for i in range(11):
        list.append(i)
        return list
    print(list)