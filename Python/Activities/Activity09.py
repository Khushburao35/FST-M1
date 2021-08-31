listOne = [1,2,3,4,5,6,7,8,9,10]
listTwo = [11,12,13,14,15,16,17,18,19,20]

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)
        
for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("Result List is:")
print(thirdList)