import pytest

@pytest.fixture
def wallet():
   amount = 0
   return amount

@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(wallet, earned, spent, expected):

    print("I have "+ str(wallet) +" amount in my wallet")
    wallet += earned
    print("I have added "+ str(earned) +" amount in my wallet and have "+ str(wallet) +" amount in my wallet")
    
    wallet -= spent
    print("I have spent "+ str(spent) +" amount in my wallet and have "+ str(wallet) +" amount in my wallet")

    assert wallet == expected