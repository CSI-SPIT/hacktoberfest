'''
    A program to play the simple game of FizzBuzz from 1 to N.
    For every number between 1 and N (inclusive),
    print a single line containing:
    -   'Fizz' if the number is a multiple of 3.
    -   'Buzz' if the number is a multiple of 5.
    -   'FizzBuzz' if the number is a multiple of both 3 and 5.
    -   The number itself if the number is a multiple of neither.
'''

print("Enter the upper limit (N): ")
n = int(input())

for i in range(1,n+1):
    if i%3==0:
        print("Fizz")
    if i%5==0:
        print("Buzz")
    if i%3!=0 and i%5!=0:
        print(i)