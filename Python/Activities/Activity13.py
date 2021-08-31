numbers = list(input("Enter a sequence of comma separated values: ").split(","))
for i in range(0, len(numbers)):
    numbers[i] = int(numbers[i])
print(numbers)


result = sum(numbers)
print("Sum is :" + str(result))


def sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum