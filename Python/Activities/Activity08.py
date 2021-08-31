#numbers = list(input("Enter a sequence of comma separated values: ").split(", "))

print ("Press simply Enter to finish input")
sum = 0
list = []
while True:

    a = input("Enter Numbers : ")
    if a == "":
      break
    list.append(a)
  
print(list)

firstnum = list[0]
lastnum = list[-1]

if firstnum == lastnum:
    print(True)
else:
    print(False)