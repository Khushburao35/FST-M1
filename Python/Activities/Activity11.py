fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15,
    "cherry": 10
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, "+ key_to_check + " is available @ $" + str(fruit_shop.get(key_to_check)) +"/kg")
else:
    print("No, "+ key_to_check + " is not available")