numbers = list(input("Enter a sequence of comma separated values: ").split(","))
#numbers=[3,4,5]
sum = 0

for number in numbers:
    sum += int(number)

print(sum)