def fib(number):
    if number <= 1:
        return number
    else:
        return(fib(number-1) + fib(number-2))


number = int(input("how many Fibonnaci numbers to generate : "))

for i in range(number):
        print(fib(i))


