  
num = 10

def sum(n):
  if n <= 0:
    return n
  else:
    return n + sum(n-1)

print("The sum is: ", sum(num))
