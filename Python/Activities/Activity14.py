def fib(n):
  if n <= 1:
    return n
  else:
    return (fib(n-1) + fib(n-2))
  

num = int(input("Enter how many finbonacci numbers to generate"))
for i in range(num):
    print("The fib is: ", fib(i))