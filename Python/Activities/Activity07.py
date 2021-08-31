#numbers = list(input("Enter a sequence of comma separated values: ").split(", "))


print ("Press simply Enter to finish input")
sum = 0
number = []
while True:

    a = input("Enter Numbers : ")
    if a == "":
      break
    number.append(a)
  

print(number)

for num in number:
  sum += int(num)

print(sum)