listone = list(input("Enter a sequence of comma separated values: ").split(","))
listtwo = list(input("Enter a sequence of comma separated values: ").split(","))
print("First List ", listone)
print("Second List ", listtwo)
thirdList = []
for num in listone:
    i = int(num)
    if (i % 2 != 0):
        thirdList.append(i)
for num in listtwo:
    i = int(num)
    if (i % 2 == 0):
        thirdList.append(i)

# Print result
print("result List is:")
print(thirdList)